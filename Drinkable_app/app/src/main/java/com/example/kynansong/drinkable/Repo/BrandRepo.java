package com.example.kynansong.drinkable.Repo;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.kynansong.drinkable.Models.Brand;

import static com.example.kynansong.drinkable.Repo.CocktailsRepo.KEY_COCKTAIL_ID;
import static com.example.kynansong.drinkable.Repo.CocktailsRepo.TABLE_COCKTAILS;
import static com.example.kynansong.drinkable.Repo.IngredientsRepo.KEY_INGREDIENT_ID;
import static com.example.kynansong.drinkable.Repo.IngredientsRepo.TABLE_INGREDIENTS;

/**
 * Created by kynansong on 24/11/2017.
 */

public class BrandRepo {

    //plan to create a table of drinks brands than can be associated with cocktails.
    public static final String TAG = Brand.class.getSimpleName();
    public static final String TABLE_BRAND = "brand_table";
    private static final String BRAND_ID = "brand_ID";
    public static final String BRAND_NAME = "Brand_Name";
    public static final String BRAND_LINK = "website";
    public static final String GOESWITH_ID = "Goes_with_id";


    private Brand brand;
    private Context context;

    public BrandRepo(Context context) {
        this.context = context;


    }

    public static String createTable() {

        return "CREATE TABLE " + TABLE_BRAND + " (" + BRAND_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BRAND_NAME + " TEXT,"
                + BRAND_LINK + " TEXT,"
                + GOESWITH_ID + " INTEGER, "
                + "FOREIGN KEY(" + GOESWITH_ID + ") REFERENCES " + TABLE_COCKTAILS + "(" + KEY_COCKTAIL_ID +"))";

    }

    public boolean insertBrand(SQLiteDatabase db, String name, String website, int cocktail_id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BRAND_NAME, name);
        contentValues.put(BRAND_LINK, website);
        contentValues.put(GOESWITH_ID, cocktail_id);

        long result = db.insert(TABLE_BRAND, null, contentValues);

        return result != -1;
    }



}
