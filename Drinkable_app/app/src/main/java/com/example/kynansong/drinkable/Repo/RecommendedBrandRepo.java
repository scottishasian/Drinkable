package com.example.kynansong.drinkable.Repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import com.example.kynansong.drinkable.Models.Drinks;
import com.example.kynansong.drinkable.Models.RecommendedBrand;

import static com.example.kynansong.drinkable.Repo.BrandRepo.BRAND_ID;
import static com.example.kynansong.drinkable.Repo.BrandRepo.TABLE_BRAND;
import static com.example.kynansong.drinkable.Repo.CocktailsRepo.KEY_COCKTAIL_ID;
import static com.example.kynansong.drinkable.Repo.CocktailsRepo.TABLE_COCKTAILS;

/**
 * Created by kynansong on 25/11/2017.
 */

public class RecommendedBrandRepo {

    //Joins cocktail and brand tables.

    public static final String TAG = Drinks.class.getSimpleName();
    public static final String TABLE_RECOMMENDED = "recommended_table";
    private static final String RECOMMENDED_ID = "Recommended_ID";
    public static final String COCKTAIL_R_ID = "cocktail_R_id";
    public static final String BRAND_R_ID = "brand_R_id";

    private RecommendedBrand recommendedBrand;
    private Context context;

    public RecommendedBrandRepo(Context context) {
        this.recommendedBrand = new RecommendedBrand();
        this.context = context;
    }

    public static String createTable() {

        return "CREATE TABLE " + TABLE_RECOMMENDED + " (" + RECOMMENDED_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "  //Seems to be working.
                + COCKTAIL_R_ID + " INTEGER,"
                + BRAND_R_ID + " INTEGER, "
                + "FOREIGN KEY(" + COCKTAIL_R_ID + ") REFERENCES " + TABLE_COCKTAILS + "(" + KEY_COCKTAIL_ID +"),"
                + "FOREIGN KEY(" + BRAND_R_ID + ") REFERENCES " + TABLE_BRAND + "(" + BRAND_ID +"))";
    }   // Must define items in table first then foreign keys.


    public boolean insertRecommendedBrand(SQLiteDatabase db, int cocktail_id, int brand_id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COCKTAIL_R_ID, cocktail_id);
        contentValues.put(BRAND_R_ID, brand_id);
        long result = db.insert(TABLE_RECOMMENDED, null, contentValues);
        return result != -1;
    }
}
