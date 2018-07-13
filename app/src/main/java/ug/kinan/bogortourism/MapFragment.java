package ug.kinan.bogortourism;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import ug.kinan.bogortourism.database.DatabaseHandler;
import ug.kinan.bogortourism.pojo.Data;

/**
 * Created by farhan on 6/22/17.
 */

public class MapFragment extends Fragment implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mGoogleMap;
    private LocationRequest mLocationRequest;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private Marker mCurrLocationMarker;

    private List<Data> wisataList = new ArrayList<>();
    private List<Data> kulinerList = new ArrayList<>();
    private List<Data> sejaraList = new ArrayList<>();
    private List<Data> dataList = new ArrayList<>();

    private DatabaseHandler dataSource;


    public MapFragment() {
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
        final View view = inflater.inflate(R.layout.fragment_map, container, false);
        //((MainActivity) getActivity()).setTitle("Peta");

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);

        dataSource = new DatabaseHandler(getActivity());

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        mGoogleMap = googleMap;

        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getActivity(),
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mGoogleMap.setMyLocationEnabled(true);
            }
        } else {
            buildGoogleApiClient();
            mGoogleMap.setMyLocationEnabled(true);
        }

        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mGoogleMap.setMyLocationEnabled(true);
        mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
        mGoogleMap.getUiSettings().setAllGesturesEnabled(true);
        mGoogleMap.getUiSettings().setMyLocationButtonEnabled(true);
        mGoogleMap.getUiSettings().setCompassEnabled(true);
        mGoogleMap.getUiSettings().setMapToolbarEnabled(false);

        kulinerList = dataSource.getAllKuliner();
        sejaraList = dataSource.getAllSejarah();
        wisataList = dataSource.getAllWisata();

        for (int i = 0; i < kulinerList.size(); i++) {
            dataList.add(new Data(kulinerList.get(i).getJudul(),
                    kulinerList.get(i).getAlamat(),
                    kulinerList.get(i).getHarga(),
                    kulinerList.get(i).getOperasional(),
                    kulinerList.get(i).getDeskripsi(),
                    kulinerList.get(i).getLat(),
                    kulinerList.get(i).getLng(),
                    kulinerList.get(i).getFoto(),
                    kulinerList.get(i).getFoto2(),
                    kulinerList.get(i).getTipe()));
        }
        for (int i = 0; i < wisataList.size(); i++) {
            dataList.add(new Data(wisataList.get(i).getJudul(),
                    wisataList.get(i).getAlamat(),
                    wisataList.get(i).getHarga(),
                    wisataList.get(i).getOperasional(),
                    wisataList.get(i).getDeskripsi(),
                    wisataList.get(i).getLat(),
                    wisataList.get(i).getLng(),
                    wisataList.get(i).getFoto(),
                    wisataList.get(i).getFoto2(),
                    wisataList.get(i).getTipe()));
        }
        for (int i = 0; i < sejaraList.size(); i++) {
            dataList.add(new Data(sejaraList.get(i).getJudul(),
                    sejaraList.get(i).getAlamat(),
                    sejaraList.get(i).getHarga(),
                    sejaraList.get(i).getOperasional(),
                    sejaraList.get(i).getDeskripsi(),
                    sejaraList.get(i).getLat(),
                    sejaraList.get(i).getLng(),
                    sejaraList.get(i).getFoto(),
                    sejaraList.get(i).getFoto2(),
                    sejaraList.get(i).getTipe()));
        }

        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).getTipe().equals("1")){
                mGoogleMap.addMarker(new MarkerOptions()
                        .title(dataList.get(i).getJudul())
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_kuliner))
                        .position(new LatLng(Double.parseDouble(dataList.get(i).getLat()),
                                Double.parseDouble(dataList.get(i).getLng()))));
            }else if (dataList.get(i).getTipe().equals("2")){
                mGoogleMap.addMarker(new MarkerOptions()
                        .title(dataList.get(i).getJudul())
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_alam))
                        .position(new LatLng(Double.parseDouble(dataList.get(i).getLat()),
                                Double.parseDouble(dataList.get(i).getLng()))));
            }else if (dataList.get(i).getTipe().equals("3")){
                mGoogleMap.addMarker(new MarkerOptions()
                        .title(dataList.get(i).getJudul())
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_sejarah))
                        .position(new LatLng(Double.parseDouble(dataList.get(i).getLat()),
                                Double.parseDouble(dataList.get(i).getLng()))));
            }
        }

        mGoogleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                String id = marker.getId();
                id = id.replace("m", "");
                int position = Integer.parseInt(id);

                Intent intent = new Intent(getActivity(), WisataDetailActivity.class);
                intent.putExtra("namaLokasi", dataList.get(position).getJudul());
                intent.putExtra("alamatLokasi", dataList.get(position).getAlamat());
                intent.putExtra("hargaLokasi", dataList.get(position).getHarga());
                intent.putExtra("operasionalLokasi", dataList.get(position).getOperasional());
                intent.putExtra("deskripsiLokasi", dataList.get(position).getDeskripsi());
                intent.putExtra("latLokasi", dataList.get(position).getLat());
                intent.putExtra("lngLokasi", dataList.get(position).getLng());
                intent.putExtra("fotoLokasi", dataList.get(position).getFoto());
                intent.putExtra("fotoLokasi2", dataList.get(position).getFoto2());
                intent.putExtra("tipeLokasi", dataList.get(position).getTipe());
                startActivity(intent);
            }
        });

    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(getActivity(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mGoogleMap.moveCamera(CameraUpdateFactory.zoomTo(13));

        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }


}
