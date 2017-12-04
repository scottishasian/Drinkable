package com.example.kynansong.drinkable.Repo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.kynansong.drinkable.Database.DrinkableDatabase;

/**
 * Created by kynansong on 24/11/2017.
 */

public class DrinksSeeds {
    DrinksRepo drinksRepo;
    Context context;

    public DrinksSeeds(Context context) {
        this.context = context;
        this.drinksRepo = new DrinksRepo(context);
    }

    public void drinksSeeds(SQLiteDatabase db){

        drinksRepo.insertDrink(db,1,4);
        drinksRepo.insertDrink(db,1,12);
        drinksRepo.insertDrink(db,1,14);
        drinksRepo.insertDrink(db,1,16);
        drinksRepo.insertDrink(db,2,1);
        drinksRepo.insertDrink(db,2,10);
        drinksRepo.insertDrink(db,2,16);
        drinksRepo.insertDrink(db,2,4);
        drinksRepo.insertDrink(db,3, 5);
        drinksRepo.insertDrink(db,3, 9);
        drinksRepo.insertDrink(db,3, 11);
        drinksRepo.insertDrink(db,3, 14);
        drinksRepo.insertDrink(db,3, 15);
        drinksRepo.insertDrink(db,4, 3);
        drinksRepo.insertDrink(db,4, 7);
        drinksRepo.insertDrink(db,5, 4);
        drinksRepo.insertDrink(db,5, 14);
        drinksRepo.insertDrink(db,5, 19);
        drinksRepo.insertDrink(db,6, 6);
        drinksRepo.insertDrink(db,6, 18);
        drinksRepo.insertDrink(db,6, 17);
        drinksRepo.insertDrink(db,7, 20);
        drinksRepo.insertDrink(db,7, 6);
        drinksRepo.insertDrink(db,7, 18);
        drinksRepo.insertDrink(db,8, 2);
        drinksRepo.insertDrink(db,8, 6);
        drinksRepo.insertDrink(db,8, 22);
        drinksRepo.insertDrink(db,9, 2);
        drinksRepo.insertDrink(db,9, 14);
        drinksRepo.insertDrink(db,9, 16);
        drinksRepo.insertDrink(db,9, 12);
        drinksRepo.insertDrink(db,10, 1);
        drinksRepo.insertDrink(db,10, 22);
        drinksRepo.insertDrink(db,10, 21);
        drinksRepo.insertDrink(db,10, 10);
        drinksRepo.insertDrink(db,11, 5);
        drinksRepo.insertDrink(db,11, 15);
        drinksRepo.insertDrink(db,11, 14);
        drinksRepo.insertDrink(db,11, 16);
        drinksRepo.insertDrink(db,11, 19);
        drinksRepo.insertDrink(db,12, 14);
        drinksRepo.insertDrink(db,12, 15);
        drinksRepo.insertDrink(db,12, 5);
        drinksRepo.insertDrink(db,12, 9);
        drinksRepo.insertDrink(db,13, 14);
        drinksRepo.insertDrink(db,13, 16);
        drinksRepo.insertDrink(db,13, 23);
        drinksRepo.insertDrink(db,14, 14);
        drinksRepo.insertDrink(db,14, 16);
        drinksRepo.insertDrink(db,14, 6);
        drinksRepo.insertDrink(db,15, 24);
        drinksRepo.insertDrink(db,15, 25);
        drinksRepo.insertDrink(db,15, 21);
        drinksRepo.insertDrink(db,16, 2);
        drinksRepo.insertDrink(db,16, 21);
        drinksRepo.insertDrink(db,16, 25);

    }


}
