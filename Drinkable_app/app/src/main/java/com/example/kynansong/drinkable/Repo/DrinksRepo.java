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
        insertDrink(db,1,4);
        insertDrink(db,1,12);
        insertDrink(db,1,14);
        insertDrink(db,1,16);
        insertDrink(db,2,1);
        insertDrink(db,2,10);
        insertDrink(db,2,16);
        insertDrink(db,2,4);
        insertDrink(db,3, 5);
        insertDrink(db,3, 9);
        insertDrink(db,3, 11);
        insertDrink(db,3, 14);
        insertDrink(db,3, 15);
        insertDrink(db,4, 3);
        insertDrink(db,4, 7);
        insertDrink(db,5, 4);
        insertDrink(db,5, 14);
        insertDrink(db,5, 19);
        insertDrink(db,6, 6);
        insertDrink(db,6, 18);
        insertDrink(db,6, 17);
        insertDrink(db,7, 20);
        insertDrink(db,7, 6);
        insertDrink(db,7, 18);
        insertDrink(db,8, 2);
        insertDrink(db,8, 6);
        insertDrink(db,8, 22);
        insertDrink(db,9, 2);
        insertDrink(db,9, 14);
        insertDrink(db,9, 16);
        insertDrink(db,9, 12);
        insertDrink(db,10, 1);
        insertDrink(db,10, 22);
        insertDrink(db,10, 21);
        insertDrink(db,10, 10);
        insertDrink(db,11, 5);
        insertDrink(db,11, 15);
        insertDrink(db,11, 14);
        insertDrink(db,11, 16);
        insertDrink(db,11, 19);
        insertDrink(db,12, 14);
        insertDrink(db,12, 15);
        insertDrink(db,12, 5);
        insertDrink(db,12, 9);
        insertDrink(db,13, 14);
        insertDrink(db,13, 16);
        insertDrink(db,13, 23);
        insertDrink(db,14, 14);
        insertDrink(db,14, 16);
        insertDrink(db,14, 6);





    }


}
