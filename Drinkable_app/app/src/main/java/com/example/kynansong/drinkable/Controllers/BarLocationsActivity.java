package com.example.kynansong.drinkable.Controllers;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.example.kynansong.drinkable.Models.BarLocation;
import com.example.kynansong.drinkable.R;
import com.example.kynansong.drinkable.Repo.BarLocationRepo;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;

import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

public class BarLocationsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private BarLocation barLocation, barLocation2;
    BarLocationRepo barLocationRepo;
    private FusedLocationProviderClient mFusedLocationClient;
    private double barLat = 0;
    private double barLong = 0;
    private String barName = "";
    private LocationRequest mLocationRequest;

    private long UPDATE_INTERVAL = 10 * 1000; // 10 second interval.
    private long FASTEST_INTERVAL = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_locations);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        Integer cocktailID = extras.getInt("locationInfo");

        barLocationRepo = new BarLocationRepo(this);

        ArrayList<BarLocation> location = barLocationRepo.getListBars(cocktailID); //breaks here

        for(BarLocation bar : location){
            barLat = bar.getLatitude();
            barLong = bar.getLongitude();
            barName = bar.getBarName();
        }

//        startLocationUpdates();


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     *
     * ____________________________________________________________________________
     * On the google credentials, make sure the package path is global for the app!
     * ----------------------------------------------------------------------------
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        Integer cocktailID = extras.getInt("locationInfo");

        ArrayList<BarLocation> location = barLocationRepo.getListBars(cocktailID);

        for(BarLocation bar : location){
            barLat = bar.getLatitude();
            barLong = bar.getLongitude();
            barName = bar.getBarName();

            LatLng newTag = new LatLng(barLat, barLong);
            mMap.addMarker(new MarkerOptions().position(newTag).title(barName));
            float zoomLevel = 14.0f;
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newTag, zoomLevel));

        }

//        if(checkPermissions()) {
//            googleMap.setMyLocationEnabled(true);
//        }

    }

//    private boolean checkPermissions() {
//        if(ContextCompat.checkSelfPermission(this,
//                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                return true;
//        } else {
//            requestPermissions();
//            return false;
//        }
//    }

//    private void requestPermissions() {
//        ActivityCompat.requestPermissions(this,
//                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                REQUEST_FINE_LOCATION);
//    }
//
//    protected void startLocationUpdates() {
//
//        //Initial request to start recieving updates.
//        mLocationRequest = new LocationRequest();
//        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        mLocationRequest.setInterval(UPDATE_INTERVAL);
//        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
//
//        //Create a LocationSettingsRequest object.
//
//        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
//        builder.addLocationRequest(mLocationRequest);
//        LocationSettingsRequest locationSettingsRequest = builder.build();
//
//        //Accessing the google settingsclient API for location services.
//        SettingsClient settingsClient = LocationServices.getSettingsClient(this);
//        settingsClient.checkLocationSettings(locationSettingsRequest);
//
//        getFusedLocationProviderClient(this).requestLocationUpdates(mLocationRequest, new LocationCallback() {
//            @Override
//            public void onLocationResult(LocationResult locationResult) {
//                onLocationChanged(locationResult.getLastLocation());
//            }
//        },
//                Looper.myLooper());
//
//    }
//
//    public void onLocationChanged(Location location) {
//
//        String msg = "Updated Location: " +
//                Double.toString(location.getLatitude()) + "," +
//                Double.toString(location.getLongitude());
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
//
//        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
//
//    }
//
//    public void getLastLocation() {
//        FusedLocationProviderClient locationProviderClient =  getFusedLocationProviderClient(this);
//
//        locationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
//            @Override
//            public void onSuccess(Location location) {
//                if(location != null) {
//                    onLocationChanged(location);
//                }
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.d("BarLocationsActivity", "Error tying to get last position");
//                e.printStackTrace();
//            }
//        });
//    }
//
//


}
