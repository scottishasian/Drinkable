package com.example.kynansong.drinkable.Repo;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.kynansong.drinkable.Database.DrinkableDatabase;
import com.example.kynansong.drinkable.Models.Brand;

import java.util.ArrayList;

import static com.example.kynansong.drinkable.Repo.CocktailsRepo.KEY_COCKTAIL_ID;
import static com.example.kynansong.drinkable.Repo.CocktailsRepo.TABLE_COCKTAILS;
import static com.example.kynansong.drinkable.Repo.RecommendedBrandRepo.BRAND_R_ID;
import static com.example.kynansong.drinkable.Repo.RecommendedBrandRepo.COCKTAIL_R_ID;
import static com.example.kynansong.drinkable.Repo.RecommendedBrandRepo.TABLE_RECOMMENDED;


/**
 * Created by kynansong on 24/11/2017.
 */

public class BrandRepo {

    //plan to create a table of drinks brands than can be associated with cocktails.
    public static final String TAG = Brand.class.getSimpleName();
    public static final String TABLE_BRAND = "brand_table";
    public static final String KEY_BRAND_ID = "brand_ID";
    public static final String BRAND_NAME = "Brand_Name";
    public static final String BRAND_LINK = "website";
    public static final String TYPE = "Type_spirit";
    

    private Brand brand;
    private Context context;

    public BrandRepo(Context context) {
        this.context = context;


    }

    public static String createTable() {

        return "CREATE TABLE " + TABLE_BRAND + " (" + KEY_BRAND_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BRAND_NAME + " TEXT,"
                + BRAND_LINK + " TEXT,"
                + TYPE + " TEXT " + ")";

    }

    public boolean insertBrand(SQLiteDatabase db, String name, String website, String type) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BRAND_NAME, name);
        contentValues.put(BRAND_LINK, website);
        contentValues.put(TYPE, type);

        long result = db.insert(TABLE_BRAND, null, contentValues);

        return result != -1;
    }

    //Returns a list of brands based on cocktail id.

    public ArrayList<Brand> getAllBrands(int cocktail_id) {
        String stringID = Integer.toString(cocktail_id);
        DrinkableDatabase drinkableDatabase = new DrinkableDatabase(this.context);
        SQLiteDatabase db = drinkableDatabase.getReadableDatabase();
        ArrayList<Brand> brands = new ArrayList();

        String brandList = " SELECT * FROM " + TABLE_BRAND
                + " INNER JOIN " + TABLE_RECOMMENDED + " ON " + BRAND_R_ID +
                " = " + KEY_BRAND_ID
                + " INNER JOIN " + TABLE_COCKTAILS + " ON " + KEY_COCKTAIL_ID +
                " = " + COCKTAIL_R_ID
                + " WHERE " + KEY_COCKTAIL_ID + " = " + stringID;

        Cursor cursor = db.rawQuery(brandList, null);

        if(cursor.moveToFirst()) {
            do {
                String type = cursor.getString(3);
                String website = cursor.getString(2);
                String name = cursor.getString(1);
                Integer id = cursor.getInt(0);
                Brand brand = new Brand(id, name, website, type);
                brands.add(brand);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return brands;
    }




}
