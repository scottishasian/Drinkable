package com.example.kynansong.drinkable.Repo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by kynansong on 29/11/2017.
 */

public class BarLocationSeeds {

    BarLocationRepo barLocationRepo;
    Context context;

    public BarLocationSeeds(Context context) {
        this.context = context;
        this.barLocationRepo = new BarLocationRepo(context);
    }

    public void barSeeds(SQLiteDatabase db) {
        barLocationRepo.insertBarLocation(db, "The Voodoo Rooms", 55.953956, -3.190682);
        barLocationRepo.insertBarLocation(db, "Lebowskis", 55.946117, -3.206457);
        barLocationRepo.insertBarLocation(db, "The Voyage of Buck", 55.949632, -3.212400);
        barLocationRepo.insertBarLocation(db, "Hoot the Redeemer", 55.952651, -3.196364);
        barLocationRepo.insertBarLocation(db, "The Last Word Saloon", 55.957830, -3.206537); //5
        barLocationRepo.insertBarLocation(db, "Bramble", 55.954968, -3.197573); //6
        barLocationRepo.insertBarLocation(db, "Panda & Sons", 55.953314, -3.207015); //7
        barLocationRepo.insertBarLocation(db, "Paradise Palms", 55.946402, -3.189096); //8
        barLocationRepo.insertBarLocation(db, "Bryant & Mack", 55.951869, -3.204194); //9
        barLocationRepo.insertBarLocation(db, "Treacle", 55.957545, -3.188171); //10
        barLocationRepo.insertBarLocation(db, "Lucky Liquor", 55.954385, -3.201566); //11
        barLocationRepo.insertBarLocation(db, "Checkpoint", 55.946416, -3.189982); //12
        barLocationRepo.insertBarLocation(db, "KIN", 55.958252, -3.189916); //13
        barLocationRepo.insertBarLocation(db, "Juniper", 55.953283, -3.190782); //14
        barLocationRepo.insertBarLocation(db, "Dragonfly", 55.946571, -3.199501); //15
        barLocationRepo.insertBarLocation(db, "Roseleaf", 55.9760162, -3.173474); //16
        barLocationRepo.insertBarLocation(db, "The Bon Vivant", 55.954041, -3.199697); //17

        //Juniper -
        //Dragonfly - Daquris
        //Rose Leaf - bloody mary
        //99 hanover
    }
}
