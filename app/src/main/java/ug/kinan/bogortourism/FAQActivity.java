package ug.kinan.bogortourism;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

public class FAQActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.app_bantuan);

        WebView webViewKetentuan = (WebView) findViewById(R.id.webviewKetentuan);
        String text = getString(R.string.bantuan);
        text = text.replace("\n","<br/>");
        text = "<html><head></head><body style='margin:0;padding:0;background-color:#f0f0f0;'><div style='text-align:justify;font-size:11pt;padding:10px;margin:0;color:#777777'>"+text+"</body></html></div>";
        webViewKetentuan.loadData(text,"text/html","UTF-8");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
