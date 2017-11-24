package com.example.kynansong.drinkable.Repo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by kynansong on 24/11/2017.
 */

public class BrandSeeds {

    BrandRepo brandRepo;
    Context context;

    public BrandSeeds(Context context) {
        this.context = context;
        this.brandRepo = new BrandRepo(context);
    }

    public void brandSeeds(SQLiteDatabase db){
        brandRepo.insertBrand(db, "Arbikie", "https://www.arbikie.com", 6);
        brandRepo.insertBrand(db, "Kettle One", "https://www.ketelone.com/en-gb/", 6);
        brandRepo.insertBrand(db, "Tapitio", "http://specialitybrands.com/our-range/tapatio/", 3);

    }
}
