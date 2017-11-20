package com.example.kynansong.drinkable.Database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kynansong on 20/11/2017.
 */

public class DatabaseManager {          //handles database connection. Like SQL Runner. From Tutorial.
    private Integer mOpenCounter = 0;

    private static DatabaseManager instance;
    private static SQLiteOpenHelper mDatabaseHelper;
    private SQLiteDatabase mDrinkableDatabase;

    public static synchronized void intialiseInstance(SQLiteOpenHelper helper) {
        if (instance == null) {
            instance = new DatabaseManager();
            mDatabaseHelper = helper;
        }
    }

    public static synchronized DatabaseManager getInstance(){
        if(instance == null) {
            throw new IllegalStateException(DatabaseManager.class.getSimpleName() +
                "not initialised, call intialiseInstance(..) method.");
        }
        return instance;
    }

    public synchronized SQLiteDatabase openDrinkableDatabase(){
        mOpenCounter++;
        if(mOpenCounter == 1) {
            mDrinkableDatabase = mDatabaseHelper.getWritableDatabase();
        }
        return mDrinkableDatabase;
    }

    public synchronized void closeDrinkableDatabase() {
        mOpenCounter--;
        if(mOpenCounter == 0){
            mDrinkableDatabase.close();
        }
    }
}
