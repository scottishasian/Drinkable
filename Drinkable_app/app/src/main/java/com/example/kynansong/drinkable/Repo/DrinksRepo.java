package com.example.kynansong.drinkable.Repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.kynansong.drinkable.Database.DatabaseManager;
import com.example.kynansong.drinkable.Models.Cocktails;
import com.example.kynansong.drinkable.Models.Drinks;

/**
 * Created by kynansong on 20/11/2017.
 */

public class DrinksRepo {

    //Drinks join table
    public static final String TAG = Drinks.class.getSimpleName();
    public static final String TABLE_DRINKS = "drinks_table";
    private static final String DRINK_ID = "Drink_ID";
    private static final String COCKTAIL_ID = "cocktail_id";
    private static final String INGREDIENT_ID = "ingredient_id";

    private Drinks drink;

    public DrinksRepo() {
        this.drink = new Drinks();

    }


    public static String createTable() {
        return "CREATE TABLE " + TABLE_DRINKS + "(" + DRINK_ID + " INTEGER " +
                COCKTAIL_ID + "  INTEGER  ," + INGREDIENT_ID + " INTEGER " + ")";
    }

    public int insertDrink(Drinks drink) { //Save method
        int drinkID;
        SQLiteDatabase db = DatabaseManager.getInstance().openDrinkableDatabase();
        ContentValues values = new ContentValues();
        values.put(DRINK_ID, drink.getDrinkId());
        values.put(COCKTAIL_ID, drink.getCocktailID());
        values.put(INGREDIENT_ID, drink.getIngredientID());

        drinkID=(int)db.insert(DrinksRepo.TABLE_DRINKS, null, values);
        DatabaseManager.getInstance().closeDrinkableDatabase();

        return drinkID;
    }

    public void deleteDrink() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDrinkableDatabase();
        db.delete(DrinksRepo.TABLE_DRINKS,null, null);
        DatabaseManager.getInstance().closeDrinkableDatabase();
    }


}
