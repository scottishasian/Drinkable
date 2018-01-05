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
        brandRepo.insertBrand(db, "Vida", "http://delmaguey.com/vida/", "Mezcal"); //12
        brandRepo.insertBrand(db, "Chartreuse", "https://www.chartreuse.fr/en/produits/green-chartreuse/", "Chartreuse"); //13
        brandRepo.insertBrand(db, "Chambord", "http://www.chambordchannel.com/", "Liqueur"); //14
        brandRepo.insertBrand(db, "Buckfast", "https://www.buckfast.org.uk/tonic-wine", "Tonic Wine"); //15
        brandRepo.insertBrand(db, "Woodford Reserve", "https://www.woodfordreserve.com/age", "Bourbon"); //16
        brandRepo.insertBrand(db, "Seawolf Rum", "https://twitter.com/seawolfrum?lang=en", "Rum"); //17
        brandRepo.insertBrand(db, "Doorlys Rum", "https://www.marussiabeverages.co.uk/rl-seale#", "Rum"); //18
        brandRepo.insertBrand(db, "Monkey Shoulder", "https://www.monkeyshoulder.com/", "Whisky"); //19
        brandRepo.insertBrand(db, "Mathusalem", "http://www.matusalem.com/", "Rum"); //20
        brandRepo.insertBrand(db, "Eldorado", "https://www.theeldoradorum.com/", "Rum"); //21
        brandRepo.insertBrand(db, "Courvoisier", "http://www.courvoisier.com/global/", "Cognac"); //22
        brandRepo.insertBrand(db, "Martell", "https://www.martell.com/en-uk/", "Cognac"); //23
        brandRepo.insertBrand(db, "Disaronno", "http://www.disaronno.com/", "Liqueur"); //24


    }
}
