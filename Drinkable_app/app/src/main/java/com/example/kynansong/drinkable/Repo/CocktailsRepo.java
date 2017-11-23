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
    private static final String COCKTAIL_DESCRIPTION = "COCKTAIL_DESCRIPTION";


    private Cocktails cocktail;
    private Context context;

    public CocktailsRepo(Context context) {
        this.context = context;
    }

    public static String createTable() {
        return "CREATE TABLE " + TABLE_COCKTAILS + "(" + KEY_COCKTAIL_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COCKTAIL_NAME + " TEXT ,"
                + COCKTAIL_MEASUREMENTS + " TEXT, " + COCKTAIL_DESCRIPTION + " TEXT " + ")";
    }

    public boolean insertCocktails(SQLiteDatabase db, String name, String measurements, String description) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COCKTAIL_NAME, name);
        contentValues.put(COCKTAIL_MEASUREMENTS, measurements);
        contentValues.put(COCKTAIL_DESCRIPTION, description);

        long result = db.insert(TABLE_COCKTAILS, null, contentValues);

        return result != -1;
    }

    public void CocktailSeeds(SQLiteDatabase db) {
        insertCocktails(db,"Mojito", "50ml Rum, 8 Mint leaves, 15ml Gomme, 25ml Lime"
        , "Muddle the lime, sugar and mint, then stir in the rum over crushed ice. Finish with Soda.");

        insertCocktails(db,"Old Fashioned", "50ml Bourbon, 1 sugar cube, 3 dashes Orange bitters, 3 dashes Angostura bitters"
        ,"Muddle the sugar and bitters into a treacle, then stir in the bourbon over ice.");

        insertCocktails(db,"Paloma", "50ml Tequila, 12.5ml Lime Juice, 75ml Grapefruit Juice/Soda, 12.5ml Agave, salt rim"
        , "Build and stir in glass over ice.");

        insertCocktails(db,"Whisky Mac", "50ml Whisky, 25ml Ginger Wine"
        ,"Build and stir in glass over ice.");


    }


    public ArrayList<Cocktails> getListOfCocktails(int ingredientId) {
        String stringID = Integer.toString(ingredientId);
        DrinkableDatabase drinkableDatabase = new DrinkableDatabase(this.context);
        SQLiteDatabase db = drinkableDatabase.getReadableDatabase();
        ArrayList<Cocktails> cocktails = new ArrayList();


        String cocktailList = " SELECT * FROM " + TABLE_COCKTAILS
                + " INNER JOIN " + TABLE_DRINKS + " ON " + COCKTAIL_ID +
                " = " + KEY_COCKTAIL_ID
                + " INNER JOIN " + TABLE_INGREDIENTS + " ON " + KEY_INGREDIENT_ID +
                " = " + INGREDIENT_ID
                + " WHERE " + KEY_INGREDIENT_ID + " = " + stringID;



        Cursor cursor = db.rawQuery(cocktailList, null); // Class to represent mouse cursor.

        if(cursor.moveToFirst()) {
            do {
                String description = cursor.getString(3);
                String measurement = cursor.getString(2);
                String name = cursor.getString(1);
                Integer id = cursor.getInt(0);       //Had to change to int here.
                Cocktails cocktail = new Cocktails(id, name, measurement, description);
                cocktails.add(cocktail);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return cocktails;

    }

    public String getCocktailInfo(int cocktailID) {
        String stringID = Integer.toString(cocktailID);
        String selectQuery = "SELECT * FROM " + TABLE_COCKTAILS
                                + " WHERE " + KEY_COCKTAIL_ID + " = " + stringID;;
        DrinkableDatabase drinkableDatabase = new DrinkableDatabase(this.context);
        SQLiteDatabase db = drinkableDatabase.getReadableDatabase();

        String description = "";

        Cursor cursor = db.rawQuery(selectQuery, null); // Class to represent mouse cursor.

        if(cursor != null) {      //loops through rows and adds to the arraylist.
                cursor.moveToFirst();
                description = cursor.getString(cursor.getColumnIndex("COCKTAIL_DESCRIPTION"));
            }
        cursor.close();
        db.close();

        return description;
    }

    public String getCocktailMeasurements(int cocktailID) {    //Not DRY, could put into array with above and then use adaptor.
        String stringID = Integer.toString(cocktailID);
        String selectQuery = "SELECT * FROM " + TABLE_COCKTAILS
                + " WHERE " + KEY_COCKTAIL_ID + " = " + stringID;;
        DrinkableDatabase drinkableDatabase = new DrinkableDatabase(this.context);
        SQLiteDatabase db = drinkableDatabase.getReadableDatabase();

        String measurements = "";

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor != null) {
            cursor.moveToFirst();
            measurements = cursor.getString(cursor.getColumnIndex("COCKTAIL_MEASUREMENTS"));
        }
        cursor.close();
        db.close();

        return measurements;
    }

    public String getCocktailName(int cocktailID) {    //Not DRY, could put into array with above and then use adaptor.
        String stringID = Integer.toString(cocktailID);
        String selectQuery = "SELECT * FROM " + TABLE_COCKTAILS
                + " WHERE " + KEY_COCKTAIL_ID + " = " + stringID;;
        DrinkableDatabase drinkableDatabase = new DrinkableDatabase(this.context);
        SQLiteDatabase db = drinkableDatabase.getReadableDatabase();

        String name = "";

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor != null) {
            cursor.moveToFirst();
            name = cursor.getString(cursor.getColumnIndex("COCKTAIL_NAME"));
        }
        cursor.close();
        db.close();

        return name;
    }

//    public ArrayList<Cocktails> getCocktailInfoDescriptionsPage(int cocktailID) {     //To make dryer code.
//        String stringID = Integer.toString(cocktailID);
//        String selectQuery = "SELECT * FROM " + TABLE_COCKTAILS
//                + " WHERE " + KEY_COCKTAIL_ID + " = " + stringID;;
//        DrinkableDatabase drinkableDatabase = new DrinkableDatabase(this.context);
//        SQLiteDatabase db = drinkableDatabase.getReadableDatabase();
//        ArrayList<Cocktails> cocktails = new ArrayList();
//
//        String measurements = "";
//
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if(cursor.moveToFirst()) {
//            do {
//                String description = cursor.getString(3);
//                String measurement = cursor.getString(2);
//                String name = cursor.getString(1);
//                Integer id = cursor.getInt(0);       //Had to change to int here.
//                Cocktails cocktail = new Cocktails();
//                cocktail.setCocktailDescription(description);
//                cocktail.setCocktailMeasurements(measurement);
//                cocktail.setCocktailName(name);
//                cocktail.setCocktailID(id);
//                cocktails.add(cocktail);
//            }while(cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//
//        return cocktails;
//    }

        public List<Cocktails> getAllCocktails() {
        List<Cocktails> cocktails = new ArrayList();
        String selectQuery = "SELECT * FROM " + TABLE_COCKTAILS;
        DrinkableDatabase drinkableDatabase = new DrinkableDatabase(this.context);
        SQLiteDatabase db = drinkableDatabase.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                String description = cursor.getString(3);
                String measurement = cursor.getString(2);
                String name = cursor.getString(1);
                Integer id = cursor.getInt(0);       //Had to change to int here.
                Cocktails cocktail = new Cocktails(id, name, measurement, description);
                cocktails.add(cocktail);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return cocktails;
    }

    public void deleteCocktail(int cocktailID) {
        String stringID = Integer.toString(cocktailID);

        DrinkableDatabase drinkableDatabase = new DrinkableDatabase(this.context);
        SQLiteDatabase db = drinkableDatabase.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_COCKTAILS
                + " WHERE " + KEY_COCKTAIL_ID + " = " + stringID);

        db.close();


    }





}

