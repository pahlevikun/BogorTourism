package ug.kinan.bogortourism;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import ug.kinan.bogortourism.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private boolean doubleBackToExitPressedOnce = false;

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private ViewPagerAdapter adapter;
    private MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Beranda");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                viewPager.setCurrentItem(0);
                                setTitle("Beranda");
                                break;
                            case R.id.action_map:
                                viewPager.setCurrentItem(1);
                                setTitle("Peta");
                                break;
                            case R.id.action_news:
                                viewPager.setCurrentItem(3);
                                setTitle("Berita");
                                break;
                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
                //setTitle(adapter.getPageTitle(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(viewPager);

        requestPermissionSMS();
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "Beranda");
        adapter.addFragment(new MapFragment(), "Peta");
        adapter.addFragment(new NewsFragment(), "Berita");
        viewPager.setAdapter(adapter);
    }

    public void requestPermissionSMS(){
        final int PERMISSION_REQUEST_CODE = 1;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

            if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED
                    && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_DENIED
                    && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {

                String[] permissions = {Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION};

                requestPermissions(permissions, PERMISSION_REQUEST_CODE);

            }
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan lagi untuk keluar!", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
