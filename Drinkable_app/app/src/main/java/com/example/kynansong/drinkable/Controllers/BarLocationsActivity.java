package com.example.kynansong.drinkable.Controllers;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.kynansong.drinkable.Models.BarLocation;
import com.example.kynansong.drinkable.R;
import com.example.kynansong.drinkable.Repo.BarLocationRepo;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class BarLocationsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private BarLocation barLocation;
    BarLocationRepo barLocationRepo;
    private double barLat = 0;
    private double barLong = 0;


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

        Integer cocktailID = extras.getInt("IngredientID");
//
//        ArrayList<BarLocation> location = barLocationRepo.getListBars(cocktailID);
//
//        //do i need an adaptor??
//


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

        // Add a marker in Lebowskis and move the camera
        LatLng lebowskis = new LatLng(55.946117, -3.206457);
        mMap.addMarker(new MarkerOptions().position(lebowskis).title("Marker Lebowskis"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lebowskis));

        // Add a marker in The Voyage of Buck and move the camera
        LatLng voyage = new LatLng(55.949632, -3.212400);
        mMap.addMarker(new MarkerOptions().position(voyage).title("Marker The Voyage of Buck"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(voyage));

        // Add a marker in Voodoo and move the camera
        LatLng voodoo = new LatLng(55.953956, -3.190682);
        mMap.addMarker(new MarkerOptions().position(voodoo).title("Marker The Voodoo Rooms"));
        float zoomLevel = 14.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(voodoo, zoomLevel));
    }

    //add location manager and cursor to loop through array of locations based on cocktail id.
}
