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
    private static final int VERSION = 8;
    CocktailsRepo cocktails;
    Context context;

    public DrinkableDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
        this.cocktails = new CocktailsRepo(context);

        }

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CocktailsRepo.createTable());
        db.execSQL(IngredientsRepo.createTable());
        db.execSQL(DrinksRepo.createTable());

        cocktails.CocktailSeeds();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CocktailsRepo.TABLE_COCKTAILS);
        db.execSQL("DROP TABLE IF EXISTS " + IngredientsRepo.TABLE_INGREDIENTS);
        db.execSQL("DROP TABLE IF EXISTS " + DrinksRepo.TABLE_DRINKS);
        onCreate(db);

    }

    //Inserting data needs an inner-join and access to the drinks table.
}
