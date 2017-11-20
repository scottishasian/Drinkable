package com.example.kynansong.drinkable.Models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kynansong on 19/11/2017.
 */

public class Ingredients {



    private String ingredientID;
    private String ingredientNAME;

    public String getIngredientID() {
        return ingredientID;
    }

    public String getIngredientName(){
        return ingredientNAME;
    }

}
