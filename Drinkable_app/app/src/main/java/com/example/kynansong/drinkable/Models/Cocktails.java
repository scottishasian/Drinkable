package com.example.kynansong.drinkable.Models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kynansong on 17/11/2017.
 */

public class Cocktails {


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
