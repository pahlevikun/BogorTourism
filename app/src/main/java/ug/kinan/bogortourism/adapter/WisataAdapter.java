package ug.kinan.bogortourism.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ug.kinan.bogortourism.R;
import ug.kinan.bogortourism.WisataDetailActivity;
import ug.kinan.bogortourism.pojo.Data;

/**
 * Created by farhan on 6/30/17.
 */

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.ViewHolder> {
    private ArrayList<Data> wisataData;
    private Context context;
    private Data movie;

    public WisataAdapter(Context context, ArrayList<Data> wisataData) {
        this.wisataData = wisataData;
        this.context = context;
    }

    @Override
    public WisataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_wisata, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WisataAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.textView1.setText(wisataData.get(i).getJudul());
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WisataDetailActivity.class);
                intent.putExtra("namaLokasi", wisataData.get(i).getJudul());
                intent.putExtra("alamatLokasi", wisataData.get(i).getAlamat());
                intent.putExtra("hargaLokasi", wisataData.get(i).getHarga());
                intent.putExtra("operasionalLokasi", wisataData.get(i).getOperasional());
                intent.putExtra("deskripsiLokasi", wisataData.get(i).getDeskripsi());
                intent.putExtra("latLokasi", wisataData.get(i).getLat());
                intent.putExtra("lngLokasi", wisataData.get(i).getLng());
                intent.putExtra("fotoLokasi", wisataData.get(i).getFoto());
                intent.putExtra("fotoLokasi2", wisataData.get(i).getFoto2());
                intent.putExtra("tipeLokasi", wisataData.get(i).getTipe());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wisataData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView1;
        private CardView cardView;

        public ViewHolder(View view) {
            super(view);
            textView1 = (TextView) view.findViewById(R.id.textViewMovie1);
            cardView = (CardView) view.findViewById(R.id.cardViewMovie);
        }
    }

}

