package com.example.kynansong.drinkable.Models;

/**
 * Created by kynansong on 24/11/2017.
 */

public class Brand {

    private Integer brand_id;
    private String brand_name;
    private String brand_website;
    private String type;

    public Brand(Integer brand_id, String brand_name, String brand_website, String brand_type) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.brand_website = brand_website;
        this.type = brand_type;
    }

    //Need to create getters and setters.

    public Integer getBrand_id() {
        return this.brand_id;
    }

    public String getBrand_name(){
        return this.brand_name;
    }

    public void setBrand_name(String name) {
        this.brand_name = name;
    }

    public String get_website() {
        return this.brand_website;
    }

    public void setBrand_website(String website) {
        this.brand_website = website;
    }

    public String getBrand_type() {
        return this.type;
    }

    public void setSpiritType(String type) {
        this.type = type;
    }
}
