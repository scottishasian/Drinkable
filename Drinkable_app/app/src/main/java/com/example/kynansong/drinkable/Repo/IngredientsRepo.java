package com.example.kynansong.drinkable.Repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.kynansong.drinkable.Database.DatabaseManager;
import com.example.kynansong.drinkable.Models.Ingredients;

/**
 * Created by kynansong on 20/11/2017.
 */

public class IngredientsRepo {

    //Ingredients table
    public static final String TAG = Ingredients.class.getSimpleName();
    public static final String TABLE_INGREDIENTS = "ingredients_table";
    private static final String KEY_INGREDIENT_ID = "INGREDIENT_ID";
    private static final String INGREDIENT_NAME = "INGREDIENT_NAME";

    private Ingredients ingredient;

    public IngredientsRepo() {
        this.ingredient = new Ingredients();

    }


    public static String createTable() {
        return "CREATE TABLE " + TABLE_INGREDIENTS + "(" + KEY_INGREDIENT_ID
                + " PRIMARY KEY " + INGREDIENT_NAME + " TEXT " + ")";
    }

    public int insertDrink(Ingredients ingredient) { //Save method
        int ingredientID;
        SQLiteDatabase db = DatabaseManager.getInstance().openDrinkableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_INGREDIENT_ID, ingredient.getIngredientID());
        values.put(INGREDIENT_NAME, ingredient.getIngredientName());

        ingredientID=(int)db.insert(IngredientsRepo.TABLE_INGREDIENTS, null, values);
        DatabaseManager.getInstance().closeDrinkableDatabase();

        return ingredientID;
    }

    public void deleteDrink() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDrinkableDatabase();
        db.delete(IngredientsRepo.TABLE_INGREDIENTS,null, null);
        DatabaseManager.getInstance().closeDrinkableDatabase();
    }
}
