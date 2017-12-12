package com.example.kynansong.drinkable.Repo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.kynansong.drinkable.Models.CocktailToBar;

/**
 * Created by kynansong on 29/11/2017.
 */

public class CocktailToBarSeeds {

    CocktailToBarRepo cocktailToBarRepo;
    Context context;

    public CocktailToBarSeeds(Context context) {
        this.cocktailToBarRepo = new CocktailToBarRepo(context);
        this.context = context;
    }

    public void recommendedBarSeeds(SQLiteDatabase db) {

        cocktailToBarRepo.insertRecommendedBar(db, 12, 1);
        cocktailToBarRepo.insertRecommendedBar(db, 7, 2);
        cocktailToBarRepo.insertRecommendedBar(db, 6, 3);
        cocktailToBarRepo.insertRecommendedBar(db, 15, 1);
        cocktailToBarRepo.insertRecommendedBar(db, 3, 4);
    }
}
