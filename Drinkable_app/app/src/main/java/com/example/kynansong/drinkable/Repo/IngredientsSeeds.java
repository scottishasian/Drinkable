package com.example.kynansong.drinkable.Repo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.kynansong.drinkable.Models.Ingredients;

/**
 * Created by kynansong on 04/12/2017.
 */

public class IngredientsSeeds {
    IngredientsRepo ingredientsRepo;
    Context context;

    public IngredientsSeeds(Context context) {
        this.context = context;
        this.ingredientsRepo = new IngredientsRepo(context);

    }

    public void ingredientSeeds(SQLiteDatabase db) {   //Need to create a repo class.
        ingredientsRepo.insertIngredients(db,"Bourbon");
        ingredientsRepo.insertIngredients(db,"Gin");
        ingredientsRepo.insertIngredients(db,"Ginger Wine");
        ingredientsRepo.insertIngredients(db,"Rum");
        ingredientsRepo.insertIngredients(db,"Tequila");
        ingredientsRepo.insertIngredients(db,"Vodka");
        ingredientsRepo.insertIngredients(db,"Whisky"); //7
        ingredientsRepo.insertIngredients(db,"Apple");
        ingredientsRepo.insertIngredients(db,"Agave"); //9
        ingredientsRepo.insertIngredients(db,"Bitters");
        ingredientsRepo.insertIngredients(db,"Grapefruit");
        ingredientsRepo.insertIngredients(db,"Mint");
        ingredientsRepo.insertIngredients(db,"Lemon"); //13
        ingredientsRepo.insertIngredients(db,"Lime");
        ingredientsRepo.insertIngredients(db,"Salt"); //15
        ingredientsRepo.insertIngredients(db,"Sugar");
        ingredientsRepo.insertIngredients(db,"Coffee");
        ingredientsRepo.insertIngredients(db,"Kahlua");
        ingredientsRepo.insertIngredients(db,"Cointreau"); //19
        ingredientsRepo.insertIngredients(db,"Milk");
        ingredientsRepo.insertIngredients(db,"Sweet Vermouth");
        ingredientsRepo.insertIngredients(db,"Dry Vermouth"); //22
        ingredientsRepo.insertIngredients(db,"Cachaca"); //23
        ingredientsRepo.insertIngredients(db, "Mezcal");
        ingredientsRepo.insertIngredients(db, "Campari");
        ingredientsRepo.insertIngredients(db, "Green Chartreuse"); //26
        ingredientsRepo.insertIngredients(db, "Chambord"); //27
        ingredientsRepo.insertIngredients(db, "Buckfast"); //28
        ingredientsRepo.insertIngredients(db, "Tomato Juice"); //29
        ingredientsRepo.insertIngredients(db, "Cognac"); //30

    }
}
