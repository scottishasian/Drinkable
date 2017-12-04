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
    public static final String LONGITUDE = "bar_longitude";
    public static final String LATITUDE = "bar_latitude";

    private Context context;
    private BarLocation barLocation;

    public BarLocationRepo(Context context) {
        this.context = context;
    }

    public static String createTable() {

        return "CREATE TABLE " + TABLE_BAR_LOCATION + " (" + KEY_BAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BAR_NAME + " TEXT,"
                + LONGITUDE + " DOUBLE,"
                + LATITUDE + " DOUBLE"
                + ")";
    }

    public boolean insertBarLocation(SQLiteDatabase db, String name, double longitude, double latitude) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BAR_NAME, name);
        contentValues.put(LONGITUDE, longitude);
        contentValues.put(LATITUDE, latitude);

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
                double latitude = cursor.getDouble(3);
                double longitude = cursor.getDouble(2);
                String name = cursor.getString(1);
                Integer id = cursor.getInt(0);       //Had to change to int here.
                BarLocation barLocation = new BarLocation(id, name, longitude, latitude);
                bars.add(barLocation);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return bars;

    }
}
