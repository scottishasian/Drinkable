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
        brandRepo.insertBrand(db, "Arbikie", "https://www.arbikie.com", "Gin and Vodka");
        brandRepo.insertBrand(db, "Kettle One", "https://www.ketelone.com/en-gb/", "Vodka");
        brandRepo.insertBrand(db, "Tapitio", "http://specialitybrands.com/our-range/tapatio/", "Tequila");
        brandRepo.insertBrand(db, "Herradura", "https://www.herradura.com/#!/age-gate/", "Tequila");
        brandRepo.insertBrand(db, "Caorunn", "https://www.caorunngin.com//", "Gin");
        brandRepo.insertBrand(db, "Pickerings", "https://www.pickeringsgin.com/", "Gin");
        brandRepo.insertBrand(db, "Rock Rose", "https://www.dunnetbaydistillers.co.uk/rock-rose-gin/", "Gin");
        brandRepo.insertBrand(db, "Tanqueray", "http://www.tanqueray.com/en-gb/", "Gin");
        brandRepo.insertBrand(db, "Makers Mark", "https://www.makersmark.com/", "Bourbon");
        brandRepo.insertBrand(db, "Balvenie", "https://www.thebalvenie.com/", "Whisky");
        brandRepo.insertBrand(db, "Hendricks", "https://uk.hendricksgin.com/", "Gin");

    }
}
