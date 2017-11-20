package com.example.kynansong.drinkable.Models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kynansong on 17/11/2017.
 */

public class Cocktails {

    //Cocktail table
    private static final String TAG = Cocktails.class.getSimpleName();
    private static final String TABLE_COCKTAILS = "cocktails_table";
    private static final String KEY_COCKTAIL_ID = "Cocktail_ID";
    private static final String COCKTAIL_NAME = "COCKTAIL_NAME";
    private static final String COCKTAIL_DESCRIPTION = "COCKTAIL_DESCRIPTION";

    private String cocktailID;
    private String cocktailName;
    private String cocktailDescription;

    public String getCocktailID() {
        return cocktailID;
    }

    public String getCocktailName() {
        return cocktailName;
    }

    public String getCocktailDescription() {
        return cocktailDescription;
    }

}
