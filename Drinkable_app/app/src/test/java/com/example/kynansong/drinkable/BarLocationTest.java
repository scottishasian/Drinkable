package com.example.kynansong.drinkable;

/**
 * Created by kynansong on 29/11/2017.
 */

import com.example.kynansong.drinkable.Models.BarLocation;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class BarLocationTest {

    BarLocation barLocation;

    @Before
    public void before() {
        this.barLocation = new BarLocation(1, "The Voodoo Rooms", 55.953956, -3.190682);
    }

    @Test
    public void getBarIDTest() {
        assertEquals(1, barLocation.getBarID());
    }

    @Test
    public void getBarNameTest() {
        assertEquals("The Voodoo Rooms", barLocation.getBarName());
    }

    @Test
    public void setBarNameTest() {
        this.barLocation.setBarName("Treacle");
        assertEquals("Treacle", barLocation.getBarName());
    }

    @Test
    public void getLongitudeTest() {
        assertEquals(-3.190682, barLocation.getLongitude(), 0.01);
    }

    @Test
    public void setLongitudeTest() {
        this.barLocation.setLongitude(123.21321);
        assertEquals(123.21321, barLocation.getLongitude(), 0.01);
    }

    @Test
    public void getLatitudeTest() {
        assertEquals(55.953956, barLocation.getLatitude(), 0.01);
    }

    @Test
    public void setLatitudeTest() {
        this.barLocation.setLatitude(-123.123);
        assertEquals(-123.123, barLocation.getLatitude(), 0.01);
    }
}
