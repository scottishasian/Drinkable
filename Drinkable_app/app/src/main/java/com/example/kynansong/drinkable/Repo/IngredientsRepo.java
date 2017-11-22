package com.example.kynansong.drinkable.Repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.kynansong.drinkable.Database.DrinkableDatabase;
import com.example.kynansong.drinkable.Models.Ingredients;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kynansong on 20/11/2017.
 */

public class IngredientsRepo {

    //Ingredients table
    public static final String TAG = Ingredients.class.getSimpleName();
    public static final String TABLE_INGREDIENTS = "ingredients_table";
    public static final String KEY_INGREDIENT_ID = "key_ingredient_ID";   //not case sensitive, causes ambiguous name errors.
    private static final String INGREDIENT_NAME = "ingredient_NAME";
    private Context context;

    private String ingredientID;

    public IngredientsRepo(Context context) {
        this.context = context;
        this.ingredientID = KEY_INGREDIENT_ID;
    }


    public static String createTable() {
        return "CREATE TABLE " + TABLE_INGREDIENTS + "(" + KEY_INGREDIENT_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + INGREDIENT_NAME + " TEXT " + ")";
    }

    public boolean insertIngredients(SQLiteDatabase db, String name) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(INGREDIENT_NAME, name);
        long result = db.insert(TABLE_INGREDIENTS, null, contentValues);
        return result != -1;
    }

    public void IngredientSeeds(SQLiteDatabase db) {
        insertIngredients(db,"Bourbon");
        insertIngredients(db,"Gin");
        insertIngredients(db,"Ginger Wine");
        insertIngredients(db,"Rum");
        insertIngredients(db,"Tequila");
        insertIngredients(db,"Vodka");
        insertIngredients(db,"Whisky");
        insertIngredients(db,"Apple");
        insertIngredients(db,"Agave");
        insertIngredients(db,"Bitters");
        insertIngredients(db,"Grapefruit");
        insertIngredients(db,"Mint");
        insertIngredients(db,"Lemon");
        insertIngredients(db,"Lime");
        insertIngredients(db,"Salt");
        insertIngredients(db,"Sugar");



    }






}
