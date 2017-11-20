package com.example.kynansong.drinkable.Repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.kynansong.drinkable.Models.Drinks;

/**
 * Created by kynansong on 20/11/2017.
 */

public class DrinksRepo{

    //Drinks join table
    public static final String TAG = Drinks.class.getSimpleName();
    public static final String TABLE_DRINKS = "drinks_table";
    private static final String DRINK_ID = "Drink_ID";
    public static final String COCKTAIL_ID = "cocktail_id";
    public static final String INGREDIENT_ID = "ingredient_id";

    private Drinks drink;
    private Context context;

    public DrinksRepo(Context context) {
        this.drink = new Drinks();
        this.context = context;
    }

    public static String createTable() {
        return "CREATE TABLE " + TABLE_DRINKS + "(" + DRINK_ID + " INTEGER, " + COCKTAIL_ID + " INTEGER, " + INGREDIENT_ID + " INTEGER " + ")";
    }




}
