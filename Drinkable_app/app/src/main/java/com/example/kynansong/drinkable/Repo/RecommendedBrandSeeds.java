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
        recommendedBrandRepo.insertRecommendedBrand(db, 8,1);
        recommendedBrandRepo.insertRecommendedBrand(db, 8,2);
        recommendedBrandRepo.insertRecommendedBrand(db, 8,5);
        recommendedBrandRepo.insertRecommendedBrand(db, 8,6);
        recommendedBrandRepo.insertRecommendedBrand(db, 8,7);
        recommendedBrandRepo.insertRecommendedBrand(db, 3,4);
        recommendedBrandRepo.insertRecommendedBrand(db, 11,3);
        recommendedBrandRepo.insertRecommendedBrand(db, 11,4);
        recommendedBrandRepo.insertRecommendedBrand(db, 12,3);
        recommendedBrandRepo.insertRecommendedBrand(db, 12,4);
        recommendedBrandRepo.insertRecommendedBrand(db, 2,9);
        recommendedBrandRepo.insertRecommendedBrand(db, 10,9);
        recommendedBrandRepo.insertRecommendedBrand(db, 9,1);
        recommendedBrandRepo.insertRecommendedBrand(db, 9,8);
        recommendedBrandRepo.insertRecommendedBrand(db, 8,11);
        recommendedBrandRepo.insertRecommendedBrand(db, 4,10);

    }
}
