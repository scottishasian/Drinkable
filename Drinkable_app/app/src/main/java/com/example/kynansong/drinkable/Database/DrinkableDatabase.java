package com.example.kynansong.drinkable.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.kynansong.drinkable.Models.Ingredients;
import com.example.kynansong.drinkable.Repo.BrandRepo;
import com.example.kynansong.drinkable.Repo.BrandSeeds;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;
import com.example.kynansong.drinkable.Repo.DrinksRepo;
import com.example.kynansong.drinkable.Repo.IngredientsRepo;
import com.example.kynansong.drinkable.Repo.RecommendedBrandRepo;
import com.example.kynansong.drinkable.Repo.RecommendedBrandSeeds;

import java.util.ArrayList;
import java.util.List;


import static com.example.kynansong.drinkable.Repo.BrandRepo.TABLE_BRAND;
import static com.example.kynansong.drinkable.Repo.CocktailsRepo.TABLE_COCKTAILS;

import static com.example.kynansong.drinkable.Repo.DrinksRepo.TABLE_DRINKS;
import static com.example.kynansong.drinkable.Repo.IngredientsRepo.TABLE_INGREDIENTS;
import static com.example.kynansong.drinkable.Repo.RecommendedBrandRepo.TABLE_RECOMMENDED;

/**
 * Created by kynansong on 19/11/2017.
 */

public class DrinkableDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "drinkable.db";
    private static final String TAG = DrinkableDatabase.class.getSimpleName().toString();
    private static final int VERSION = 5053;
    CocktailsRepo cocktails;
    IngredientsRepo ingredients;
    DrinksRepo drinks;
    BrandRepo brand;
    BrandSeeds brandSeeds;
    RecommendedBrandRepo recommendedBrandRepo;
    RecommendedBrandSeeds recommendedBrandSeeds;
    Context context;

    public DrinkableDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);

        cocktails = new CocktailsRepo(context);
        ingredients = new IngredientsRepo(context);
        drinks = new DrinksRepo(context);
        brand = new BrandRepo(context);
        recommendedBrandRepo = new RecommendedBrandRepo(context);
        this.recommendedBrandSeeds = new RecommendedBrandSeeds(context);
        this.brandSeeds = new BrandSeeds(context);


        SQLiteDatabase db = this.getWritableDatabase();

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys = 1");
        db.execSQL(CocktailsRepo.createTable());
        db.execSQL(IngredientsRepo.createTable());
        db.execSQL(DrinksRepo.createTable());
        db.execSQL(BrandRepo.createTable());
        db.execSQL(RecommendedBrandRepo.createTable());

        cocktails.CocktailSeeds(db);
        ingredients.IngredientSeeds(db);
        drinks.drinksSeeds(db);
        brandSeeds.brandSeeds(db);
        recommendedBrandSeeds.recommendedBrandsSeeds(db);



    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COCKTAILS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INGREDIENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DRINKS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BRAND);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECOMMENDED);


        onCreate(db);

    }

    public List<Ingredients> getAllIngredients() {
        List<Ingredients> ingredients = new ArrayList();
        String selectQuery = "SELECT * FROM " + TABLE_INGREDIENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null); // Class to represent mouse cursor.

        if(cursor.moveToFirst()) {      //loops through rows and adds to the arraylist.
            do {
                String name = cursor.getString(1);
                Integer id = cursor.getInt(0);       //Had to change to int here.
                Ingredients ingredient = new Ingredients(id, name);
//                ingredient.setIngredientName(name);
//                ingredient.setingredientID(id);

                ingredients.add(ingredient);

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return ingredients;
    }




}
