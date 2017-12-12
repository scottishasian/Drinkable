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
    }
}
