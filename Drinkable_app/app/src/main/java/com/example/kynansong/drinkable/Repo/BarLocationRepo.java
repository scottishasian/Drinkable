package com.example.kynansong.drinkable.Repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.kynansong.drinkable.Models.BarLocation;

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
}
