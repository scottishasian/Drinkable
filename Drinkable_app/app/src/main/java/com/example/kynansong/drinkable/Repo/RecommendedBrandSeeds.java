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
        recommendedBrandRepo.insertRecommendedBrand(db, 2,16);
        recommendedBrandRepo.insertRecommendedBrand(db, 10,9);
        recommendedBrandRepo.insertRecommendedBrand(db, 9,1);
        recommendedBrandRepo.insertRecommendedBrand(db, 9,8);
        recommendedBrandRepo.insertRecommendedBrand(db, 8,11);
        recommendedBrandRepo.insertRecommendedBrand(db, 4,10);
        recommendedBrandRepo.insertRecommendedBrand(db, 16,5);
        recommendedBrandRepo.insertRecommendedBrand(db, 16,6);
        recommendedBrandRepo.insertRecommendedBrand(db, 16,7);
        recommendedBrandRepo.insertRecommendedBrand(db, 15,12);
        recommendedBrandRepo.insertRecommendedBrand(db, 17,13);
        recommendedBrandRepo.insertRecommendedBrand(db, 17,7);
        recommendedBrandRepo.insertRecommendedBrand(db, 17,1);
        recommendedBrandRepo.insertRecommendedBrand(db, 17,15);
        recommendedBrandRepo.insertRecommendedBrand(db, 17,16);
        recommendedBrandRepo.insertRecommendedBrand(db, 18,1);
        recommendedBrandRepo.insertRecommendedBrand(db, 18,14);
        recommendedBrandRepo.insertRecommendedBrand(db, 19,15);
        recommendedBrandRepo.insertRecommendedBrand(db, 20,1);
        recommendedBrandRepo.insertRecommendedBrand(db, 20,2);
        recommendedBrandRepo.insertRecommendedBrand(db, 5,17);
        recommendedBrandRepo.insertRecommendedBrand(db, 21,17);
        recommendedBrandRepo.insertRecommendedBrand(db, 5,18);
        recommendedBrandRepo.insertRecommendedBrand(db, 21,18);
        recommendedBrandRepo.insertRecommendedBrand(db, 22,16);
        recommendedBrandRepo.insertRecommendedBrand(db, 22,19);
        recommendedBrandRepo.insertRecommendedBrand(db, 23,20);
        recommendedBrandRepo.insertRecommendedBrand(db, 23,21);
        recommendedBrandRepo.insertRecommendedBrand(db, 24,22);
        recommendedBrandRepo.insertRecommendedBrand(db, 24,23);

    }
}
