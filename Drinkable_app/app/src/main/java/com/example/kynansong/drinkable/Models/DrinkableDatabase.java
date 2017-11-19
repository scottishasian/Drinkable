package com.example.kynansong.drinkable.Models;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kynansong on 19/11/2017.
 */

public class DrinkableDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "drinkable.db";
    private static final String TABLE_COCKTAILS = "cocktails_table";
    private static final String COCKTAIL_ID = "ID";
    private static final String COCKTAIL_NAME = "COCKTAIL_NAME";
    private static final String COCKTAIL_DESCRIPTION = "COCKTAIL_DESCRIPTION";
    private static final String TABLE_INGREDIENTS = "ingredients_table";
    private static final String INGREDIENT_ID = "ID";
    private static final String INGREDIENT_NAME = "INGREDIENT_NAME";





    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
