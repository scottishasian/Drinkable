package com.example.kynansong.drinkable.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.kynansong.drinkable.Models.Ingredients;
import com.example.kynansong.drinkable.Repo.BarLocationRepo;
import com.example.kynansong.drinkable.Repo.BarLocationSeeds;
import com.example.kynansong.drinkable.Repo.BrandRepo;
import com.example.kynansong.drinkable.Repo.BrandSeeds;
import com.example.kynansong.drinkable.Repo.CocktailToBarRepo;
import com.example.kynansong.drinkable.Repo.CocktailToBarSeeds;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;
import com.example.kynansong.drinkable.Repo.CocktailsSeeds;
import com.example.kynansong.drinkable.Repo.DrinksRepo;
import com.example.kynansong.drinkable.Repo.DrinksSeeds;
import com.example.kynansong.drinkable.Repo.IngredientsRepo;
import com.example.kynansong.drinkable.Repo.IngredientsSeeds;
import com.example.kynansong.drinkable.Repo.RecommendedBrandRepo;
import com.example.kynansong.drinkable.Repo.RecommendedBrandSeeds;

import java.util.ArrayList;
import java.util.List;


import static com.example.kynansong.drinkable.Repo.BarLocationRepo.TABLE_BAR_LOCATION;
import static com.example.kynansong.drinkable.Repo.BrandRepo.TABLE_BRAND;
import static com.example.kynansong.drinkable.Repo.CocktailToBarRepo.TABLE_COCKTAIL_TO_BAR;
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
    private static final int VERSION = 5086;
    CocktailsRepo cocktails;
    CocktailsSeeds cocktailsSeeds;
    IngredientsRepo ingredients;
    IngredientsSeeds ingredientsSeeds;
    BarLocationRepo barLocation;
    BarLocationSeeds barSeeds;
    DrinksRepo drinks;
    DrinksSeeds drinksSeeds;
    BrandRepo brand;
    BrandSeeds brandSeeds;
    RecommendedBrandRepo recommendedBrandRepo;
    RecommendedBrandSeeds recommendedBrandSeeds;
    CocktailToBarRepo recommendedBar;
    CocktailToBarSeeds cocktailToBarSeeds;
    Context context;

    public DrinkableDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);

        cocktails = new CocktailsRepo(context);
        ingredients = new IngredientsRepo(context);
        drinks = new DrinksRepo(context);
        brand = new BrandRepo(context);
        barLocation = new BarLocationRepo(context);
        recommendedBar = new CocktailToBarRepo(context);
        recommendedBrandRepo = new RecommendedBrandRepo(context);
        this.recommendedBrandSeeds = new RecommendedBrandSeeds(context);
        this.brandSeeds = new BrandSeeds(context);
        this.drinksSeeds = new DrinksSeeds(context);
        this.barSeeds = new BarLocationSeeds(context);
        this.cocktailToBarSeeds = new CocktailToBarSeeds(context);
        this.ingredientsSeeds = new IngredientsSeeds(context);
        this.cocktailsSeeds = new CocktailsSeeds(context);


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
        db.execSQL(BarLocationRepo.createTable());
        db.execSQL(CocktailToBarRepo.createTable());

        cocktailsSeeds.CocktailSeeds(db);
        drinksSeeds.drinksSeeds(db);
        brandSeeds.brandSeeds(db);
        recommendedBrandSeeds.recommendedBrandsSeeds(db);
        barSeeds.barSeeds(db);
        cocktailToBarSeeds.recommendedBarSeeds(db);
        ingredientsSeeds.ingredientSeeds(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COCKTAILS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INGREDIENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DRINKS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BRAND);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECOMMENDED);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BAR_LOCATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COCKTAIL_TO_BAR);


        onCreate(db);

    }



}
