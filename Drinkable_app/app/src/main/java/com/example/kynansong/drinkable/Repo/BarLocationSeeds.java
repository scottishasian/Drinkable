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
    }
}
