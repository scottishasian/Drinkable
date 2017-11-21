package com.example.kynansong.drinkable.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kynansong.drinkable.Models.Cocktails;
import com.example.kynansong.drinkable.Models.Drinks;
import com.example.kynansong.drinkable.Models.Ingredients;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;
import com.example.kynansong.drinkable.Repo.DrinksRepo;
import com.example.kynansong.drinkable.Repo.IngredientsRepo;

import java.util.ArrayList;
import java.util.List;

import static com.example.kynansong.drinkable.Repo.CocktailsRepo.TABLE_COCKTAILS;
import static com.example.kynansong.drinkable.Repo.IngredientsRepo.TABLE_INGREDIENTS;

/**
 * Created by kynansong on 19/11/2017.
 */

public class DrinkableDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "drinkable.db";
    private static final String TAG = DrinkableDatabase.class.getSimpleName().toString();
    private static final int VERSION = 5024;
    CocktailsRepo cocktails;
    IngredientsRepo ingredients;
    DrinksRepo drinks;
    Context context;

    public DrinkableDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);

        cocktails = new CocktailsRepo(context);
        ingredients = new IngredientsRepo(context);
        drinks = new DrinksRepo(context);


        SQLiteDatabase db = this.getWritableDatabase();

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys = 1");
        db.execSQL(CocktailsRepo.createTable());
        db.execSQL(IngredientsRepo.createTable());
        db.execSQL(DrinksRepo.createTable());

        cocktails.CocktailSeeds(db);
        ingredients.IngredientSeeds(db);
        drinks.drinksSeeds(db);



    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COCKTAILS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INGREDIENTS);
        db.execSQL("DROP TABLE IF EXISTS " + DrinksRepo.TABLE_DRINKS);

        onCreate(db);

    }

    public List<String> getAllIngredients() {
        List<String> ingredients = new ArrayList();
        String selectQuery = "SELECT * FROM " + TABLE_INGREDIENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null); // Class to represent mouse cursor.

        if(cursor.moveToFirst()) {      //loops through rows and adds to the arraylist.
            do {
                ingredients.add(cursor.getString(1));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return ingredients;
    }

    public List<String> getAllCocktails() {
        List<String> cocktails = new ArrayList();
        String selectQuery = "SELECT * FROM " + TABLE_COCKTAILS; // need to select all for cursor to run through indexes.
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null); // Class to represent mouse cursor.

        if(cursor.moveToFirst()) {      //loops through rows and adds to the arraylist.
            do {
                cocktails.add(cursor.getString(1));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return cocktails;
    }





    //Inserting data needs an inner-join and access to the drinks table.
}
