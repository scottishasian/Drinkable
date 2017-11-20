package com.example.kynansong.drinkable.Models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kynansong on 19/11/2017.
 */

public class Ingredients {

    //Ingredients table
    private static final String TAG = Ingredients.class.getSimpleName();
    private static final String TABLE_INGREDIENTS = "ingredients_table";
    private static final String KEY_INGREDIENT_ID = "INGREDIENT_ID";
    private static final String INGREDIENT_NAME = "INGREDIENT_NAME";

    private String ingredientID;
    private String ingredientNAME;

    public String getIngredientID() {
        return ingredientID;
    }

    public String getIngredientName(){
        return ingredientNAME;
    }

}
