package com.example.kynansong.drinkable.Models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kynansong on 17/11/2017.
 */

public class Cocktails {


    private Integer cocktailID;
    private String cocktailName;
    private String cocktailMeasurements;
    private String cocktailDescription;

    public Cocktails(Integer cocktailID, String cocktailName, String cocktailMeasurements, String cocktailDescription) {
        this.cocktailID = cocktailID;
        this.cocktailName = cocktailName;
        this.cocktailMeasurements = cocktailMeasurements;
        this.cocktailDescription = cocktailDescription;

    }

    public Integer getCocktailID() {
        return this.cocktailID;
    }

    public void setCocktailID(Integer ID){
        this.cocktailID = ID;
    }

    public String getCocktailName() {
        return this.cocktailName;
    }

    public void setCocktailName(String name){
        this.cocktailName = name;

    }

    public String getCocktailMeasurements() {
        return this.cocktailMeasurements;
    }

    public void setCocktailMeasurements(String measurements) {
        this.cocktailMeasurements = measurements;
    }

    public String getCocktailDescription() {
        return this.cocktailDescription;
    }

    public void setCocktailDescription(String description) {
        this.cocktailDescription = description;
    }

}
