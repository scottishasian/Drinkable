package com.example.kynansong.drinkable.Repo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by kynansong on 25/11/2017.
 */

public class RecommendedBrandSeeds {

    RecommendedBrandRepo recommendedBrandRepo;
    Context context;

    public RecommendedBrandSeeds(Context context) {
        this.context = context;
        this.recommendedBrandRepo = new RecommendedBrandRepo(context);
    }

    public void recommendedBrandsSeeds(SQLiteDatabase db) {
        recommendedBrandRepo.insertRecommendedBrand(db, 6,1);
        recommendedBrandRepo.insertRecommendedBrand(db, 7,2);
        recommendedBrandRepo.insertRecommendedBrand(db, 3,3);
    }
}
