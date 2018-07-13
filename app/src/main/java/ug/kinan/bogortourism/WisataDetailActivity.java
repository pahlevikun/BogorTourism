package ug.kinan.bogortourism;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import ug.kinan.bogortourism.config.GPSTracker;


public class WisataDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mGoogleMap;
    private String namaLokasi, alamatLokasi, hargaLokasi, operasionalLokasi, deskripsiLokasi,
            latLokasi, lngLokasi, tipeLokasi, fotoLokasi,fotoLokasi2;
    private Button btNavigasi;
    private ImageView ivGambar;
    private TextView tvNama, tvJam, tvKeterangan, tvInfo;
    private Double dLat, dLng;
    private CardView cardViewInfo;
    private SliderLayout sliderShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle(getString(R.string.wisata_detail));

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);

        tvInfo = (TextView) findViewById(R.id.tvInfoDetail);
        tvNama = (TextView) findViewById(R.id.tvNamaDetail);
        tvJam = (TextView) findViewById(R.id.tvJamDetail);
        tvKeterangan = (TextView) findViewById(R.id.tvKeteranganDetail);
        ivGambar = (ImageView) findViewById(R.id.ivGambarDetail);
        btNavigasi = (Button) findViewById(R.id.btNavDetail);
        cardViewInfo = (CardView) findViewById(R.id.cardViewInfo);
        sliderShow = (SliderLayout) findViewById(R.id.slider);

        Intent intent = getIntent();
        namaLokasi = intent.getStringExtra("namaLokasi");
        alamatLokasi = intent.getStringExtra("alamatLokasi");
        hargaLokasi = intent.getStringExtra("hargaLokasi");
        operasionalLokasi = intent.getStringExtra("operasionalLokasi");
        deskripsiLokasi = intent.getStringExtra("deskripsiLokasi");
        latLokasi = intent.getStringExtra("latLokasi");
        lngLokasi = intent.getStringExtra("lngLokasi");
        fotoLokasi = intent.getStringExtra("fotoLokasi");
        fotoLokasi2 = intent.getStringExtra("fotoLokasi2");
        tipeLokasi = intent.getStringExtra("tipeLokasi");

        tvNama.setText(namaLokasi);
        tvJam.setText(operasionalLokasi);
        tvInfo.setText("Alamat Lokasi : " + alamatLokasi + "\nBiaya/Rentang Harga : " + hargaLokasi);
        tvKeterangan.setText(deskripsiLokasi);

        Log.d("HASIL", fotoLokasi2+ " " + fotoLokasi + " " + getResources().getIdentifier(fotoLokasi, "drawable", getPackageName()));
        ivGambar.setImageResource(getResources().getIdentifier(fotoLokasi, "drawable", getPackageName()));
        ivGambar.setVisibility(View.GONE);
        if (deskripsiLokasi.length() < 5) {
            cardViewInfo.setVisibility(View.GONE);
        }

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put(namaLokasi+"1",getResources().getIdentifier(fotoLokasi, "drawable", getPackageName()));
        file_maps.put(namaLokasi+"2",getResources().getIdentifier(fotoLokasi2, "drawable", getPackageName()));
        for(String name : file_maps.keySet()){
            DefaultSliderView defaultSliderView = new DefaultSliderView(WisataDetailActivity.this);
            defaultSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            sliderShow.addSlider(defaultSliderView);
        }
        sliderShow.setPresetTransformer(SliderLayout.Transformer.Default);
        sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderShow.setCustomAnimation(new DescriptionAnimation());
        sliderShow.setDuration(5000);

        GPSTracker gps = new GPSTracker(WisataDetailActivity.this);
        final Double locLat = gps.getLatitude();
        final Double locLng = gps.getLongitude();
        btNavigasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WisataDetailActivity.this, NavigateActivity.class);
                intent.putExtra("locLat", locLat);
                intent.putExtra("locLng", locLng);
                intent.putExtra("markerLat", latLokasi);
                intent.putExtra("markerLng", lngLokasi);
                intent.putExtra("tipe", tipeLokasi);
                intent.putExtra("markerNama", namaLokasi);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
        mGoogleMap.getUiSettings().setAllGesturesEnabled(false);
        mGoogleMap.getUiSettings().setMyLocationButtonEnabled(true);
        mGoogleMap.getUiSettings().setCompassEnabled(true);
        mGoogleMap.getUiSettings().setMapToolbarEnabled(false);

        Intent intent = getIntent();
        latLokasi = intent.getStringExtra("latLokasi");
        lngLokasi = intent.getStringExtra("lngLokasi");

        Double latitude = Double.parseDouble(latLokasi);
        Double longitude = Double.parseDouble(lngLokasi);

        LatLng lokasi = new LatLng(latitude, longitude);

        if (tipeLokasi.equals("1")) {
            mGoogleMap.addMarker(new MarkerOptions()
                    .title(namaLokasi)
                    .position(lokasi)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_kuliner)))
                    .showInfoWindow();
        } else if (tipeLokasi.equals("2")) {
            mGoogleMap.addMarker(new MarkerOptions()
                    .title(namaLokasi)
                    .position(lokasi)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_alam)))
                    .showInfoWindow();
        } else if (tipeLokasi.equals("3")) {
            mGoogleMap.addMarker(new MarkerOptions()
                    .title(namaLokasi)
                    .position(lokasi)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_sejarah)))
                    .showInfoWindow();
        }
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi, 17));
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
