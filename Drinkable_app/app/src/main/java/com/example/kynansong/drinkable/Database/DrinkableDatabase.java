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

/**
 * Created by kynansong on 19/11/2017.
 */

public class DrinkableDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "drinkable.db";
    private static final String TAG = DrinkableDatabase.class.getSimpleName().toString();
    private static final int VERSION = 5023;
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
        db.execSQL("DROP TABLE IF EXISTS " + CocktailsRepo.TABLE_COCKTAILS);
        db.execSQL("DROP TABLE IF EXISTS " + IngredientsRepo.TABLE_INGREDIENTS);
        db.execSQL("DROP TABLE IF EXISTS " + DrinksRepo.TABLE_DRINKS);

        onCreate(db);

    }

    public List<String> getAllIngredients() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT INGREDIENT_NAME FROM TABLE_INGREDIENTS", null); // Class to represent mouse cursor.
        List<String> ingredients = new ArrayList();
        if(cursor.getCount() > 0) {      //loops through rows and adds to the arraylist.
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                String INGREDIENT_NAME =  cursor.getString(1);
            }
        }
        cursor.close();
        db.close();

        return ingredients;
    }





    //Inserting data needs an inner-join and access to the drinks table.
}
