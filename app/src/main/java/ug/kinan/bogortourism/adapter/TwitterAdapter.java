package ug.kinan.bogortourism.adapter;

/**
 * Created by farhan on 6/22/17.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ug.kinan.bogortourism.R;
import ug.kinan.bogortourism.pojo.Twitter;


public class TwitterAdapter extends ArrayAdapter<Twitter> {

    Context context;
    ViewHolder viewHolder;
    ArrayList<Twitter> al_newslist=new ArrayList<>();

    public TwitterAdapter(Context context, ArrayList<Twitter> al_newslist) {
        super(context, R.layout.adapter_layout, al_newslist);
        this.al_newslist=al_newslist;
        this.context=context;
    }

    @Override
    public int getCount() {
        Log.e("ADAPTER LIST SIZE",al_newslist.size()+"");
        return al_newslist.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        if (al_newslist.size() > 0) {
            return al_newslist.size();
        } else {
            return 1;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_layout, parent, false);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.textViewAdapter);
            viewHolder.iv_twit = (ImageView) convertView.findViewById(R.id.imageViewAdapter);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        Twitter m = al_newslist.get(position);
        viewHolder.tv_name.setText(m.getUsername()+"\n"+m.getText());
        Picasso.with(getContext())
                .load(m.getImage())
                .into(viewHolder.iv_twit);

        return convertView;
    }

    private static class ViewHolder {
        TextView tv_name;
        ImageView iv_twit;
    }

}