package com.example.kynansong.drinkable.Controllers;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
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
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

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
    protected LocationRequest mLocationRequest = new LocationRequest();
    private static final int REQUEST_CODE_RESOLUTION = 1;



    //added for location services 24/01/2018
    private LocationCallback mLocationCallback;
    private Boolean mRequestingLocationUpdates;
    private final static String KEY_REQUESTING_LOCATION_UPDATES = "requesting-location-updates";




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

        ArrayList<BarLocation> location = barLocationRepo.getListBars(cocktailID);

        for(BarLocation bar : location){
            barLat = bar.getLatitude();
            barLong = bar.getLongitude();
            barName = bar.getBarName();
        }

//        //Location services code.
//
//        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
//
//        mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
//            @Override
//            public void onSuccess(Location location) {
//                if(location != null) {
//
//                }
//            }
//        });

        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(mLocationRequest);

        SettingsClient client = LocationServices.getSettingsClient(this);
        Task<LocationSettingsResponse> task = client.checkLocationSettings(builder.build());

        task.addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {

            }
        });

        task.addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(e instanceof ResolvableApiException) {
                    try{
                        ResolvableApiException resolvable = (ResolvableApiException) e;
                        resolvable.startResolutionForResult(BarLocationsActivity.this,
                                REQUEST_CODE_RESOLUTION);
                    } catch (IntentSender.SendIntentException sendEX) {
                        //will ignore the error.

                    }
                }
            }
        });

        mLocationCallback = new LocationCallback() {
          @Override
            public void onLocationResult(LocationResult locationResult) {
              for (Location userLocation : locationResult.getLocations()) {
                  //update UI with location data here.
              }
          }
        };

//        updateValuesFromBundle(savedInstanceState);

    }
//
//    //Request Location Updates
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if(mRequestingLocationUpdates) {
//            startLocationUpdates();
//        }
//
//
//    }
//
//    private void startLocationUpdates() {
//        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, null);
//                //Will need location permission access.
//    }
//
//    //Stop Location Updates
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        stopLocationUpdates();
//    }
//
//    private void stopLocationUpdates() {
//        mFusedLocationClient.removeLocationUpdates(mLocationCallback);
//    }
//
//    //Save the state of the activity
//
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        outState.putBoolean(KEY_REQUESTING_LOCATION_UPDATES,
//                mRequestingLocationUpdates);
//
//        super.onSaveInstanceState(outState);
//    }
//
//    private void updateValuesFromBundle(Bundle savedInstanceState) {
//        if(savedInstanceState.keySet().contains(KEY_REQUESTING_LOCATION_UPDATES)) {
//            mRequestingLocationUpdates = savedInstanceState.getBoolean(
//                    KEY_REQUESTING_LOCATION_UPDATES);
//        }
//
////        updateUI(); from tutorial regarding a button press.
//    }
//
//
//




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


    }




}
