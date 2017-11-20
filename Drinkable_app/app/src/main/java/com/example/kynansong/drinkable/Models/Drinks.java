package com.example.kynansong.drinkable.Models;

/**
 * Created by kynansong on 20/11/2017.
 */

public class Drinks {

    //Drinks join table
    private static final String TAG = Drinks.class.getSimpleName();
    private static final String TABLE_DRINKS = "drinks_table";
    private static final String DRINK_ID = "Drink_ID";
    private static final String COCKTAIL_TABLE_ID = "cocktail_id";
    private static final String INGREDIENT_TABLE_ID = "ingredient_id";

    private String drinkID;
    private String cocktailID;
    private String ingredientID;

    public String getDrinkId() {
        return drinkID;
    }

    public String getCocktailID() {
        return cocktailID;
    }

    public String getIngredientID() {
        return ingredientID;
    }
}
