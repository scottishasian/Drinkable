package com.example.kynansong.drinkable.Repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kynansong.drinkable.Database.DrinkableDatabase;
import com.example.kynansong.drinkable.Models.Cocktails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kynansong on 20/11/2017.
 */

public class CocktailsRepo {

    //Cocktail table
    private static final String TAG = Cocktails.class.getSimpleName();
    public static final String TABLE_COCKTAILS = "cocktails_table";
    public static final String KEY_COCKTAIL_ID = "Cocktail_ID";
    private static final String COCKTAIL_NAME = "COCKTAIL_NAME";
    private static final String COCKTAIL_MEASUREMENTS = "COCKTAIL_MEASUREMENTS";


    private Cocktails cocktail;
    private Context context;

    public CocktailsRepo(Context context) {
        this.context = context;
        this.cocktail = new Cocktails();
    }

    public static String createTable() {
        return "CREATE TABLE " + TABLE_COCKTAILS + "(" + KEY_COCKTAIL_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COCKTAIL_NAME + " TEXT ,"
                + COCKTAIL_MEASUREMENTS + " TEXT " + ")";
    }

    public boolean insertCocktails(SQLiteDatabase db, String name, String measurements) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COCKTAIL_NAME, name);
        contentValues.put(COCKTAIL_MEASUREMENTS, measurements);
;        long result = db.insert(TABLE_COCKTAILS, null, contentValues);

        return result != -1;
    }

    public void CocktailSeeds(SQLiteDatabase db) {
        insertCocktails(db,"Mojito", "50ml Rum, 8 Mint leaves, 15ml Gomme, 25ml Lime");

        insertCocktails(db,"Old Fashioned", "50ml Bourbon, 1 sugar cube, 3 dashes Orange bitters, 3 dashes Angostura bitters");


    }




    public List<Cocktails> getListOfCocktails(int ingredientId) {
        List<Cocktails> cocktails = new ArrayList();
        String cocktailList = " SELECT KEY_COCKTAIL_ID " + KEY_COCKTAIL_ID +
                             "," + COCKTAIL_NAME + " FROM " + IngredientsRepo.TABLE_INGREDIENTS
                             + "INNER JOIN " + TABLE_COCKTAILS + " ON " + KEY_COCKTAIL_ID +
                             "= DrinksRepo." + DrinksRepo.COCKTAIL_ID
                             + "INNER JOIN " + "DrinksRepo." + DrinksRepo.INGREDIENT_ID +
                             "= " + ingredientId;



        return cocktails;


    }


}
