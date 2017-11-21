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
    private static final int VERSION = 5006;
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
        db.execSQL(CocktailsRepo.createTable());
        db.execSQL(IngredientsRepo.createTable());
        db.execSQL(DrinksRepo.createTable());

        cocktails.CocktailSeeds(db);
        ingredients.IngredientSeeds(db);
        drinks.drinksSeeds(db);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CocktailsRepo.TABLE_COCKTAILS);
        db.execSQL("DROP TABLE IF EXISTS " + IngredientsRepo.TABLE_INGREDIENTS);
        db.execSQL("DROP TABLE IF EXISTS " + DrinksRepo.TABLE_DRINKS);
//        if(newVersion > oldVersion) {
//            db.execSQL("ALTER TABLE TABLE_COCKTAIL ADD COLUMN COCKTAIL_DESCRIPTION TEXT DEFAULT 0");
//        }
        onCreate(db);

    }

    //Inserting data needs an inner-join and access to the drinks table.
}
