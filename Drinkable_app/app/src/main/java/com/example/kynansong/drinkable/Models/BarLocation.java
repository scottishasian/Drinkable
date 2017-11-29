package com.example.kynansong.drinkable.Models;

/**
 * Created by kynansong on 29/11/2017.
 */

public class BarLocation {

    private Integer bar_id;
    private String bar_name;
    private double longitude;
    private double latitude;

    public BarLocation(Integer bar_id, String bar_name, double longitude, double latitude) {
        this.bar_id = bar_id;
        this.bar_name = bar_name;
        this.longitude = longitude;
        this.latitude = latitude;

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
}
