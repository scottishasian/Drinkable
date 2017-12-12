package com.example.kynansong.drinkable.Models;

import java.util.ArrayList;

/**
 * Created by kynansong on 29/11/2017.
 */

public class BarLocation {

    private Integer bar_id;
    private String bar_name;
    private double latitude;
    private double longitude;


    public BarLocation(Integer bar_id, String bar_name, double latitude, double longitude ) {
        this.bar_id = bar_id;
        this.bar_name = bar_name;
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public int getBarID() {
        return this.bar_id;
    }

    public String getBarName() {
        return this.bar_name;
    }

    public void setBarName(String barName) {
        this.bar_name = barName;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double barLat(ArrayList<BarLocation> location) {
        double result = 0;
        for(BarLocation i : location) {
            result = i.getLatitude();
        }
        return result;
    }

    public double barLong(ArrayList<BarLocation> location) {
        double result = 0;
        for(BarLocation j : location) {
            result = j.getLongitude();
        }
        return result;
    }
}
