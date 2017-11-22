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

    public Cocktails(Integer cocktailID, String cocktailName, String cocktailMeasurements) {
        this.cocktailID = cocktailID;
        this.cocktailName = cocktailName;
        this.cocktailMeasurements = cocktailMeasurements;

    }

    public Integer getCocktailID() {
        return this.cocktailID;
    }

    public String getCocktailName() {
        return this.cocktailName;
    }

    public String getCocktailMeasurements() {
        return this.cocktailMeasurements;
    }

}
