package com.example.kynansong.drinkable.Repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.kynansong.drinkable.Database.DrinkableDatabase;
import com.example.kynansong.drinkable.Models.Ingredients;

/**
 * Created by kynansong on 20/11/2017.
 */

public class IngredientsRepo {

    //Ingredients table
    public static final String TAG = Ingredients.class.getSimpleName();
    public static final String TABLE_INGREDIENTS = "ingredients_table";
    public static final String KEY_INGREDIENT_ID = "INGREDIENT_ID";
    private static final String INGREDIENT_NAME = "INGREDIENT_NAME";
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
        insertIngredients(db,"Rum");
        insertIngredients(db,"Bourbon");
        insertIngredients(db,"Vodka");
        insertIngredients(db,"Gin");
        insertIngredients(db,"Lime Juice");
        insertIngredients(db,"Sugar");
        insertIngredients(db,"Mint");
        insertIngredients(db,"Bitters");
    }




}
