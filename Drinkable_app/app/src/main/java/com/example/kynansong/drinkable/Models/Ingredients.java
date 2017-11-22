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


    public void setingredientID(String id) {
        this.ingredientID = id;
    }
}
