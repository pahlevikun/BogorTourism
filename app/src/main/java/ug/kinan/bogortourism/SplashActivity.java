package ug.kinan.bogortourism;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;

public class SplashActivity extends AppCompatActivity {


    private static final int REQUEST = 123;
    private boolean resume = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (isNetworkAvailable() || isOnline()) {
            SharedPreferences settings = getSharedPreferences(getString(R.string.sharedSetting), 0);
            HashMap<String, String> map = (HashMap<String, String>) settings.getAll();

            if (Build.VERSION.SDK_INT >= 23) {
                Log.d("TAG", "IN IF Build.VERSION.SDK_INT >= 23");
                String[] PERMISSIONS = {
                        android.Manifest.permission.INTERNET,
                        android.Manifest.permission.ACCESS_NETWORK_STATE,
                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                };

                if (!hasPermissions(SplashActivity.this, PERMISSIONS)) {
                    Log.d("TAG", "IN IF hasPermissions");
                    ActivityCompat.requestPermissions((Activity) SplashActivity.this, PERMISSIONS, REQUEST);
                } else {
                    Log.d("TAG", "IN ELSE hasPermissions");
                    splashLanding();
                }
            } else {
                Log.d("TAG", "IN ELSE  Build.VERSION.SDK_INT >= 23");
                splashLanding();
            }
        } else {
            android.support.v7.app.AlertDialog.Builder alert = new android.support.v7.app.AlertDialog.Builder(SplashActivity.this);
            alert.setTitle("Warning!");
            alert.setMessage("Please turn on Internet connection and re-open Sekampus!");
            alert.setCancelable(false);
            alert.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                            startActivity(intent);
                        }
                    });
            alert.setNegativeButton("No",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            if (isNetworkAvailable()||isOnline()){
                                finish();
                                startActivity(getIntent());
                            }else{
                                finish();
                            }
                        }
                    });
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG", "Resume ya");
        if (resume) {
            if (isNetworkAvailable() || isOnline()) {
                SharedPreferences settings = getSharedPreferences(getString(R.string.sharedSetting), 0);
                HashMap<String, String> map = (HashMap<String, String>) settings.getAll();

                if (Build.VERSION.SDK_INT >= 23) {
                    Log.d("TAG", "IN IF Build.VERSION.SDK_INT >= 23");
                    String[] PERMISSIONS = {
                            android.Manifest.permission.INTERNET,
                            android.Manifest.permission.ACCESS_NETWORK_STATE,
                            android.Manifest.permission.ACCESS_FINE_LOCATION,
                            android.Manifest.permission.ACCESS_COARSE_LOCATION,
                    };

                    if (!hasPermissions(SplashActivity.this, PERMISSIONS)) {
                        Log.d("TAG", "IN IF hasPermissions");
                        ActivityCompat.requestPermissions((Activity) SplashActivity.this, PERMISSIONS, REQUEST);
                    } else {
                        Log.d("TAG", "IN ELSE hasPermissions");
                        splashLanding();
                    }
                } else {
                    Log.d("TAG", "IN ELSE  Build.VERSION.SDK_INT >= 23");
                    splashLanding();
                }
            } else {
                android.support.v7.app.AlertDialog.Builder alert = new android.support.v7.app.AlertDialog.Builder(SplashActivity.this);
                alert.setTitle("Warning!");
                alert.setMessage("Please turn on Internet connection and re-open Sekampus!");
                alert.setCancelable(false);
                alert.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                                startActivity(intent);
                            }
                        });
                alert.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                if (isNetworkAvailable()||isOnline()){
                                    finish();
                                    startActivity(getIntent());
                                }else{
                                    finish();
                                }
                            }
                        });
                alert.show();
            }
        }
        resume = true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("TAG", "PERMISSIONS grant");
                    splashLanding();
                } else {
                    Log.d("TAG", "PERMISSIONS Denied");
                    android.support.v7.app.AlertDialog.Builder alert = new android.support.v7.app.AlertDialog.Builder(SplashActivity.this);
                    alert.setTitle("Warning!");
                    alert.setMessage("Please give permission for Sekampus!");
                    alert.setCancelable(false);
                    alert.setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub
                                    finish();
                                    startActivity(getIntent());
                                }
                            });
                    alert.show();
                }
            }
        }
    }

    private static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public Boolean isOnline() {
        try {
            Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 www.deggan.com/internet");
            int returnVal = p1.waitFor();
            boolean reachable = (returnVal == 0);
            return reachable;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }


    private void splashLanding() {
        int SPLASH_TIME_OUT = 2500;
        new Handler().postDelayed(new Thread() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    public void onBackPressed() {
    }

}
