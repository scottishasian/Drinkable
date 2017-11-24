package com.example.kynansong.drinkable;

import com.example.kynansong.drinkable.Models.Brand;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by kynansong on 24/11/2017.
 */

public class BrandTest {

    Brand brand;

    @Before
    public void before(){
        brand = new Brand(1, "Arbikie", "https://www.arbikie.com", 6);

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
    public void canGetAssociatedCocktailId() {
        assertEquals((Integer)6, brand.getCocktail_ID());
    }

    @Test
    public void canSetCocktailId() {
        this.brand.setCocktail_id(4);
        assertEquals((Integer)4, brand.getCocktail_ID());
    }
}
