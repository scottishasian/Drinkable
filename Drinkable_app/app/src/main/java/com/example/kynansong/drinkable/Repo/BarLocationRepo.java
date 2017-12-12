package com.example.kynansong.drinkable.Repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.kynansong.drinkable.Database.DrinkableDatabase;
import com.example.kynansong.drinkable.Models.BarLocation;

import java.util.ArrayList;

import static com.example.kynansong.drinkable.Repo.CocktailToBarRepo.BAR_ID;
import static com.example.kynansong.drinkable.Repo.CocktailToBarRepo.SELECTED_COCKTAIL_ID;
import static com.example.kynansong.drinkable.Repo.CocktailToBarRepo.TABLE_COCKTAIL_TO_BAR;
import static com.example.kynansong.drinkable.Repo.CocktailsRepo.KEY_COCKTAIL_ID;
import static com.example.kynansong.drinkable.Repo.CocktailsRepo.TABLE_COCKTAILS;

/**
 * Created by kynansong on 29/11/2017.
 */

public class BarLocationRepo {

    public static final String TAG = BarLocation.class.getSimpleName();
    public static final String TABLE_BAR_LOCATION = "bar_location";
    public static final String KEY_BAR_ID = "bar_id";
    public static final String BAR_NAME = "bar_name";
    public static final String LATITUDE = "bar_latitude";
    public static final String LONGITUDE = "bar_longitude";         //Need to change these around


    private Context context;
    private BarLocation barLocation;

    public BarLocationRepo(Context context) {
        this.context = context;
    }

    public static String createTable() {

        return "CREATE TABLE " + TABLE_BAR_LOCATION + " (" + KEY_BAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BAR_NAME + " TEXT,"
                + LATITUDE + " DOUBLE,"
                + LONGITUDE + " DOUBLE"
                + ")";
    }

    public boolean insertBarLocation(SQLiteDatabase db, String name, double latitude, double longitude) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BAR_NAME, name);
        contentValues.put(LATITUDE, latitude);
        contentValues.put(LONGITUDE, longitude);


        long result = db.insert(TABLE_BAR_LOCATION, null, contentValues);

        return result != -1;
    }

    public ArrayList<BarLocation> getListBars(int cocktailID) {
        String stringID = Integer.toString(cocktailID);
        DrinkableDatabase drinkableDatabase = new DrinkableDatabase(this.context);
        SQLiteDatabase db = drinkableDatabase.getReadableDatabase();
        ArrayList<BarLocation> bars = new ArrayList();


        String cocktailList = " SELECT * FROM " + TABLE_BAR_LOCATION
                + " INNER JOIN " + TABLE_COCKTAIL_TO_BAR + " ON " + BAR_ID +
                " = " + KEY_BAR_ID
                + " INNER JOIN " + TABLE_COCKTAILS + " ON " + KEY_COCKTAIL_ID +
                " = " + SELECTED_COCKTAIL_ID
                + " WHERE " + KEY_COCKTAIL_ID + " = " + stringID;



        Cursor cursor = db.rawQuery(cocktailList, null); // Class to represent mouse cursor.

        if(cursor.moveToFirst()) {
            do {
                double longitude = cursor.getDouble(3);
                double latitude = cursor.getDouble(2);
                String name = cursor.getString(1);
                Integer id = cursor.getInt(0);       //Had to change to int here.
                BarLocation barLocation = new BarLocation(id, name, latitude, longitude);
                bars.add(barLocation);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return bars;

    }

    //May rewrite as 2 functions to draw out long and lat.

    public double getLatitude(int cocktailID) {    //Not DRY, could put into array with above and then use adaptor.
        String stringID = Integer.toString(cocktailID);
        String selectQuery = " SELECT * FROM " + TABLE_BAR_LOCATION
                + " INNER JOIN " + TABLE_COCKTAIL_TO_BAR + " ON " + BAR_ID +
                " = " + KEY_BAR_ID
                + " INNER JOIN " + TABLE_COCKTAILS + " ON " + KEY_COCKTAIL_ID +
                " = " + SELECTED_COCKTAIL_ID
                + " WHERE " + KEY_COCKTAIL_ID + " = " + stringID;
        DrinkableDatabase drinkableDatabase = new DrinkableDatabase(this.context);
        SQLiteDatabase db = drinkableDatabase.getReadableDatabase();

        double latitude = 0.0;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor != null) {
            cursor.moveToFirst();
            latitude = cursor.getDouble(cursor.getColumnIndex("bar_latitude"));
        }
        cursor.close();
        db.close();

        return latitude;
    }
}
