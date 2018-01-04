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
        cocktailToBarRepo.insertRecommendedBar(db, 6, 1);
        cocktailToBarRepo.insertRecommendedBar(db, 6, 11);
        cocktailToBarRepo.insertRecommendedBar(db, 15, 1);
        cocktailToBarRepo.insertRecommendedBar(db, 3, 4);
        cocktailToBarRepo.insertRecommendedBar(db, 17, 5);
        cocktailToBarRepo.insertRecommendedBar(db, 18, 6);
        cocktailToBarRepo.insertRecommendedBar(db, 19, 8);
        cocktailToBarRepo.insertRecommendedBar(db, 2, 12);
        cocktailToBarRepo.insertRecommendedBar(db, 20, 12);
        cocktailToBarRepo.insertRecommendedBar(db, 20, 1);
        cocktailToBarRepo.insertRecommendedBar(db, 21, 12);
        cocktailToBarRepo.insertRecommendedBar(db, 11, 7);
        cocktailToBarRepo.insertRecommendedBar(db, 10, 11);
        cocktailToBarRepo.insertRecommendedBar(db, 1, 1);
        cocktailToBarRepo.insertRecommendedBar(db, 1, 4);
        cocktailToBarRepo.insertRecommendedBar(db, 1, 7);
        cocktailToBarRepo.insertRecommendedBar(db, 16, 13);
        cocktailToBarRepo.insertRecommendedBar(db, 16, 1);
        cocktailToBarRepo.insertRecommendedBar(db, 22, 5);
        cocktailToBarRepo.insertRecommendedBar(db, 22, 13);


    }
}
