package com.example.kynansong.drinkable.Repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.kynansong.drinkable.Database.DatabaseManager;
import com.example.kynansong.drinkable.Models.Cocktails;

/**
 * Created by kynansong on 20/11/2017.
 */

public class CocktailsRepo {

    //Cocktail table
    private static final String TAG = Cocktails.class.getSimpleName();
    public static final String TABLE_COCKTAILS = "cocktails_table";
    private static final String KEY_COCKTAIL_ID = "Cocktail_ID";
    private static final String COCKTAIL_NAME = "COCKTAIL_NAME";
    private static final String COCKTAIL_DESCRIPTION = "COCKTAIL_DESCRIPTION";

    private Cocktails cocktail;

    public CocktailsRepo() {
        this.cocktail = new Cocktails();
    }

    public static String createTable() {
        return "CREATE TABLE " + TABLE_COCKTAILS + "(" + KEY_COCKTAIL_ID +
                "  PRIMARY KEY  ," + COCKTAIL_NAME + " TEXT ," + COCKTAIL_DESCRIPTION
                + " TEXT " + ")";
    }

    public int insertCocktail(Cocktails cocktail) { //Save method
        int cocktailID;
        SQLiteDatabase db = DatabaseManager.getInstance().openDrinkableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_COCKTAIL_ID, cocktail.getCocktailID());
        values.put(COCKTAIL_NAME, cocktail.getCocktailName());
        values.put(COCKTAIL_DESCRIPTION, cocktail.getCocktailDescription());

        cocktailID=(int)db.insert(CocktailsRepo.TABLE_COCKTAILS, null, values);
        DatabaseManager.getInstance().closeDrinkableDatabase();

        return cocktailID;
    }

    public void deleteCocktail() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDrinkableDatabase();
        db.delete(CocktailsRepo.TABLE_COCKTAILS,null, null);
        DatabaseManager.getInstance().closeDrinkableDatabase();
    }


}
