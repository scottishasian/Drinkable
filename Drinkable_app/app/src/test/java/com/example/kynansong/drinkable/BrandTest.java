package com.example.kynansong.drinkable;

import com.example.kynansong.drinkable.Models.Brand;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * Created by kynansong on 24/11/2017.
 */

public class BrandTest {

    Brand brand;

    @Before
    public void before(){
        brand = new Brand(1, "Arbikie", "https://www.arbikie.com", "Gin and Vodka");

    }

    @Test
    public void canGetBrandIdTest() {
        assertEquals((Integer)1, brand.getBrand_id());
    }

    @Test
    public void canGetBrandNameTest() {
        assertEquals("Arbikie", brand.getBrand_name());
    }

    @Test
    public void canSetBrandNameTest() {
        this.brand.setBrand_name("Kettle One");
        assertEquals("Kettle One", brand.getBrand_name());
    }


    @Test
    public void canGetBrandWebsiteTest() {
        assertEquals("https://www.arbikie.com", brand.get_website());
    }

    @Test
    public void canSetBrandWebsiteTest() {
        this.brand.setBrand_website("test");
        assertEquals("test", brand.get_website());
    }

    @Test
    public void canGetSpiritType() {
        assertEquals("Gin and Vodka", brand.getBrand_type());
    }

    @Test
    public void canSetSpiritType() {
        this.brand.setSpiritType("Rum");
        assertEquals("Rum", brand.getBrand_type());
    }
}
