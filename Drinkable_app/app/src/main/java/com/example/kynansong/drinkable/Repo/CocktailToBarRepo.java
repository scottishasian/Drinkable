package com.example.kynansong.drinkable.Repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.kynansong.drinkable.Models.CocktailToBar;

import static com.example.kynansong.drinkable.Repo.BarLocationRepo.KEY_BAR_ID;
import static com.example.kynansong.drinkable.Repo.BarLocationRepo.TABLE_BAR_LOCATION;
import static com.example.kynansong.drinkable.Repo.CocktailsRepo.KEY_COCKTAIL_ID;
import static com.example.kynansong.drinkable.Repo.CocktailsRepo.TABLE_COCKTAILS;

/**
 * Created by kynansong on 29/11/2017.
 */

public class CocktailToBarRepo {

    private static final String TAG = CocktailToBar.class.getSimpleName();
    public static final String TABLE_COCKTAIL_TO_BAR = "cocktail_bar_table";
    public static final String KEY_COCKTAIL_TO_BAR_ID = "key_CocktailToBar_ID";
    public static final String  SELECTED_COCKTAIL_ID = "selected_cocktail_ID";
    private static final String BAR_ID = "bar_ID";

    CocktailToBar cocktailToBar;
    Context context;

    public CocktailToBarRepo(Context context) {
        this.context = context;
        this.cocktailToBar = new CocktailToBar();
    }

    public static String createTable() {

        return "CREATE TABLE " + TABLE_COCKTAIL_TO_BAR + " (" + KEY_COCKTAIL_TO_BAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SELECTED_COCKTAIL_ID + " INTEGER,"
                + BAR_ID + " INTEGER, "
                + "FOREIGN KEY(" + SELECTED_COCKTAIL_ID + ") REFERENCES " + TABLE_COCKTAILS + "(" + KEY_COCKTAIL_ID + "),"
                + "FOREIGN KEY(" + BAR_ID + ") REFERENCES " + TABLE_BAR_LOCATION + "(" + KEY_BAR_ID + "))";
    }

    public boolean insertRecommendedBar(SQLiteDatabase db, int selected_cocktail_id, int bar_id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SELECTED_COCKTAIL_ID, selected_cocktail_id);
        contentValues.put(BAR_ID, bar_id);
        long result = db.insert(TABLE_COCKTAIL_TO_BAR, null, contentValues);
        return result != -1;
    }
}
