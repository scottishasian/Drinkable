package com.example.kynansong.drinkable.Repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kynansong.drinkable.Database.DrinkableDatabase;
import com.example.kynansong.drinkable.Models.Cocktails;
import com.example.kynansong.drinkable.Models.Ingredients;

import java.util.ArrayList;
import java.util.List;

import static com.example.kynansong.drinkable.Repo.DrinksRepo.COCKTAIL_ID;
import static com.example.kynansong.drinkable.Repo.DrinksRepo.INGREDIENT_ID;
import static com.example.kynansong.drinkable.Repo.DrinksRepo.TABLE_DRINKS;
import static com.example.kynansong.drinkable.Repo.IngredientsRepo.KEY_INGREDIENT_ID;
import static com.example.kynansong.drinkable.Repo.IngredientsRepo.TABLE_INGREDIENTS;

/**
 * Created by kynansong on 20/11/2017.
 */

public class CocktailsRepo {

    //Cocktail table
    private static final String TAG = Cocktails.class.getSimpleName();
    public static final String TABLE_COCKTAILS = "cocktails_table";
    public static final String KEY_COCKTAIL_ID = "key_Cocktail_ID";
    public static final String COCKTAIL_NAME = "COCKTAIL_NAME";
    private static final String COCKTAIL_MEASUREMENTS = "COCKTAIL_MEASUREMENTS";


    private Cocktails cocktail;
    private Context context;

    public CocktailsRepo(Context context) {
        this.context = context;
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

        insertCocktails(db,"Paloma", "50ml Tequila, 12.5ml Lime Juice, 75ml Grapefruit Juice/Soda, 12.5ml Agave, salt rim");

        insertCocktails(db,"Whisky Mac", "50ml Whisky, 25ml Ginger Wine");


    }




    public ArrayList<Cocktails> getListOfCocktails(int ingredientId) {
        String stringID = Integer.toString(ingredientId);
        DrinkableDatabase drinkableDatabase = new DrinkableDatabase(this.context);
        SQLiteDatabase db = drinkableDatabase.getReadableDatabase();
        ArrayList<Cocktails> cocktails = new ArrayList();
//        String cocktailList = "SELECT * FROM cocktails_table"
//                                + "INNER JOIN drinks_table ON drinks_table.cocktail_id = cocktails_table.Cocktail_ID"
//                                + "INNER JOIN ingredients_table ON ingredients_table.ingredient_ID = drinks_table.ingredient_id"
//                                + "WHERE ingredients_table.ingredient_ID LIKE " + stringID;

        String cocktailList = " SELECT * FROM " + TABLE_COCKTAILS
                + " INNER JOIN " + TABLE_DRINKS + " ON " + COCKTAIL_ID +
                " = " + KEY_COCKTAIL_ID
                + " INNER JOIN " + TABLE_INGREDIENTS + " ON " + KEY_INGREDIENT_ID +
                " = " + INGREDIENT_ID
                + " WHERE " + KEY_INGREDIENT_ID + " LIKE " + stringID;



        Cursor cursor = db.rawQuery(cocktailList, null); // Class to represent mouse cursor.

        if(cursor.moveToFirst()) {
            do {
                String measurments = cursor.getString(2);
                String name = cursor.getString(1);
                Integer id = cursor.getInt(0);       //Had to change to int here.
                Cocktails cocktail = new Cocktails();
                cocktail.setCocktailMeasurements(measurments);
                cocktail.setCocktailName(name);
                cocktail.setCocktailID(id);
                cocktails.add(cocktail);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return cocktails;

    }


}

//    String cocktailList = " SELECT KEY_COCKTAIL_ID " + KEY_COCKTAIL_ID +
//            "," + COCKTAIL_NAME + " FROM " + TABLE_INGREDIENTS
//            + "INNER JOIN " + TABLE_COCKTAILS + " ON " + KEY_COCKTAIL_ID +
//            "= DrinksRepo." + COCKTAIL_ID
//            + "INNER JOIN " + "DrinksRepo." + INGREDIENT_ID +
//            "= " + stringID;