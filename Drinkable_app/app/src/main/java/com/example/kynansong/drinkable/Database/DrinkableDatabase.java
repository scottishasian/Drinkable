package com.example.kynansong.drinkable.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kynansong.drinkable.Models.Cocktails;
import com.example.kynansong.drinkable.Models.Drinks;
import com.example.kynansong.drinkable.Models.Ingredients;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;
import com.example.kynansong.drinkable.Repo.DrinksRepo;
import com.example.kynansong.drinkable.Repo.IngredientsRepo;

/**
 * Created by kynansong on 19/11/2017.
 */

public class DrinkableDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "drinkable.db";
    private static final String TAG = DrinkableDatabase.class.getSimpleName().toString();

    public DrinkableDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CocktailsRepo.createTable());
        db.execSQL(IngredientsRepo.createTable());
        db.execSQL(DrinksRepo.createTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Cocktails.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Ingredients.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Drinks.TABLE);
        onCreate(db);

    }

    //Inserting data needs an inner-join and access to the drinks table.
}
