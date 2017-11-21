package com.example.kynansong.drinkable.Repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.kynansong.drinkable.Database.DrinkableDatabase;
import com.example.kynansong.drinkable.Models.Drinks;

import static com.example.kynansong.drinkable.Repo.CocktailsRepo.KEY_COCKTAIL_ID;
import static com.example.kynansong.drinkable.Repo.CocktailsRepo.TABLE_COCKTAILS;
import static com.example.kynansong.drinkable.Repo.IngredientsRepo.KEY_INGREDIENT_ID;
import static com.example.kynansong.drinkable.Repo.IngredientsRepo.TABLE_INGREDIENTS;

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



        return "CREATE TABLE " + TABLE_DRINKS + " (" + DRINK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "  //Seems to be working.
                + COCKTAIL_ID + " INTEGER,"
                + INGREDIENT_ID + " INTEGER, "
                + "FOREIGN KEY(" + COCKTAIL_ID + ") REFERENCES " + TABLE_COCKTAILS + "(" + KEY_COCKTAIL_ID +"),"
                + "FOREIGN KEY(" + INGREDIENT_ID + ") REFERENCES " + TABLE_INGREDIENTS + "(" + KEY_INGREDIENT_ID +"))";
    }   // Must define items in table first then foreign keys.


    public boolean insertDrink(SQLiteDatabase db, int cocktail_id, int ingredient_id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COCKTAIL_ID, cocktail_id);
        contentValues.put(INGREDIENT_ID, ingredient_id);
        long result = db.insert(TABLE_DRINKS, null, contentValues);
        return result != -1;
    }

    public void drinksSeeds(SQLiteDatabase db) {
        insertDrink(db,1,1);
        insertDrink(db,1,5);
        insertDrink(db,1,6);
        insertDrink(db,1,7);
        insertDrink(db,2,2);
        insertDrink(db,2,6);
        insertDrink(db,2,8);
    }


}
