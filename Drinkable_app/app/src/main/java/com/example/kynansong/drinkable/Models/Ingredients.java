package com.example.kynansong.drinkable.Models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

import com.example.kynansong.drinkable.Repo.IngredientsRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kynansong on 19/11/2017.
 */

public class Ingredients {

    IngredientsRepo ingredient;
    SQLiteOpenHelper openHelper;
    private String ingredientID;
    private String ingredientNAME;

    public Ingredients() {
        this.ingredientID = ingredientID;
        this.ingredientNAME = ingredientNAME;
    }

    public String getIngredientID() {
        return ingredientID;
    }

    public String getIngredientName(){
        return ingredientNAME;
    }

    public void setIngredientName(String ingredient){
        this.ingredientNAME = ingredient;
    }

    public List<String> getAllIngredients() {
        List<String> ingredients = new ArrayList<String>();

        String selectQuery = "SELECT * FROM " + ingredient.TABLE_INGREDIENTS;

        SQLiteDatabase db = this.openHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null); // Class to represent mouse cursor.

        if(cursor.moveToFirst()) {      //loops through rows and adds to the arraylist.
            do {
                ingredients.add(cursor.getString(1)); //Gets ingredient names.
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return ingredients;
    }


}
