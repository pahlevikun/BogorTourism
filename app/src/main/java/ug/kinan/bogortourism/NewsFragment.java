package ug.kinan.bogortourism;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;

import ug.kinan.bogortourism.adapter.TwitterAdapter;
import ug.kinan.bogortourism.config.Authenticate;
import ug.kinan.bogortourism.pojo.Twitter;

/**
 * Created by farhan on 6/22/17.
 */

public class NewsFragment extends Fragment {

    final static String ScreenName = "pemkotabogor";
    final static String LOG_TAG = "rnc";
    ListView lv_list;
    ArrayList<Twitter> al_text = new ArrayList<>();
    TwitterAdapter obj_adapter;

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_news, container, false);
        //((MainActivity) getActivity()).setTitle("Berita");

        lv_list = (ListView) view.findViewById(R.id.lv_list);

        downloadTweets();

        return view;
    }

    public void downloadTweets() {

        ConnectivityManager connMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            new DownloadTwitterTask().execute(ScreenName);
        } else {
            Toast.makeText(getActivity(),"Please check your internet connection",Toast.LENGTH_SHORT).show();
        }
    }

    // Uses an AsyncTask to download a Twitter user's timeline
    private class DownloadTwitterTask extends AsyncTask<String, Void, String> {
        final static String CONSUMER_KEY = "nW88XLuFSI9DEfHOX2tpleHbR";
        final static String CONSUMER_SECRET = "hCg3QClZ1iLR13D3IeMvebESKmakIelp4vwFUICuj6HAfNNCer";
        final static String TwitterTokenURL = "https://api.twitter.com/oauth2/token";
        final static String TwitterStreamURL = "https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=";
        final ProgressDialog dialog = new ProgressDialog(getActivity());

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.setTitle("Mohon Tunggu");
            dialog.setMessage("Sedang Memuat");
            dialog.show();

        }

        @Override
        protected String doInBackground(String... screenNames) {
            String result = null;

            if (screenNames.length > 0) {
                result = getTwitterStream(screenNames[0]);
            }
            return result;
        }

        // onPostExecute convert the JSON results into a Twitter object (which is an Array list of tweets
        @Override
        protected void onPostExecute(String result) {
            Log.e("result",result);
            dialog.dismiss();

            try {
                JSONArray jsonArray_data = new JSONArray(result);
                al_text.clear();
                for (int i=0; i<jsonArray_data.length();i++){
                    JSONObject jsonObject = jsonArray_data.getJSONObject(i);
                    String text = jsonObject.getString("text");
                    JSONObject user = jsonObject.getJSONObject("user");
                    String name = user.getString("name");
                    String profil_image_url = user.getString("profile_image_url");
                    al_text.add(new Twitter(i+"",text,name,profil_image_url));
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            // send the tweets to the adapter for rendering
            obj_adapter= new TwitterAdapter(getActivity(), al_text);
            lv_list.setAdapter(obj_adapter);
        }


        // convert a JSON authentication object into an Authenticated object
        private Authenticate jsonToAuthenticated(String rawAuthorization) {
            Authenticate auth = null;
            if (rawAuthorization != null && rawAuthorization.length() > 0) {
                try {
                    Gson gson = new Gson();
                    auth = gson.fromJson(rawAuthorization, Authenticate.class);
                } catch (IllegalStateException ex) {
                    // just eat the exception
                }
            }
            return auth;
        }

        private String getResponseBody(HttpRequestBase request) {
            StringBuilder sb = new StringBuilder();
            try {

                DefaultHttpClient httpClient = new DefaultHttpClient(new BasicHttpParams());
                HttpResponse response = httpClient.execute(request);
                int statusCode = response.getStatusLine().getStatusCode();
                String reason = response.getStatusLine().getReasonPhrase();

                if (statusCode == 200) {

                    HttpEntity entity = response.getEntity();
                    InputStream inputStream = entity.getContent();

                    BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                    String line = null;
                    while ((line = bReader.readLine()) != null) {
                        sb.append(line);
                    }
                } else {
                    sb.append(reason);
                }
            } catch (UnsupportedEncodingException ex) {
            } catch (ClientProtocolException ex1) {
            } catch (IOException ex2) {
            }
            return sb.toString();
        }

        private String getTwitterStream(String screenName) {
            String results = null;

            // Step 1: Encode consumer key and secret
            try {
                // URL encode the consumer key and secret
                String urlApiKey = URLEncoder.encode(CONSUMER_KEY, "UTF-8");
                String urlApiSecret = URLEncoder.encode(CONSUMER_SECRET, "UTF-8");

                // Concatenate the encoded consumer key, a colon character, and the
                // encoded consumer secret
                String combined = urlApiKey + ":" + urlApiSecret;

                // Base64 encode the string
                String base64Encoded = Base64.encodeToString(combined.getBytes(), Base64.NO_WRAP);

                // Step 2: Obtain a bearer token
                HttpPost httpPost = new HttpPost(TwitterTokenURL);
                httpPost.setHeader("Authorization", "Basic " + base64Encoded);
                httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
                httpPost.setEntity(new StringEntity("grant_type=client_credentials"));
                String rawAuthorization = getResponseBody(httpPost);
                Authenticate auth = jsonToAuthenticated(rawAuthorization);

                // Applications should verify that the value associated with the
                // token_type key of the returned object is bearer
                if (auth != null && auth.token_type.equals("bearer")) {

                    // Step 3: Authenticate API requests with bearer token
                    HttpGet httpGet = new HttpGet(TwitterStreamURL + screenName);

                    // construct a normal HTTPS request and include an Authorization
                    // header with the value of Bearer <>
                    httpGet.setHeader("Authorization", "Bearer " + auth.access_token);
                    httpGet.setHeader("Content-Type", "application/json");
                    // update the results with the body of the response
                    results = getResponseBody(httpGet);
                }
            } catch (UnsupportedEncodingException ex) {
            } catch (IllegalStateException ex1) {
            }
            return results;
        }
    }

}
