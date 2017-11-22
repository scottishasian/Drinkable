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
    private String cocktailDescription;

    public Cocktails(Integer cocktailID, String cocktailName, String cocktailDescription) {
        this.cocktailID = cocktailID;
        this.cocktailName = cocktailName;
        this.cocktailDescription = cocktailDescription;

    }

    public Integer getCocktailID() {
        return this.cocktailID;
    }

    public String getCocktailName() {
        return this.cocktailName;
    }

    public String getCocktailDescription() {
        return this.cocktailDescription;
    }

}
