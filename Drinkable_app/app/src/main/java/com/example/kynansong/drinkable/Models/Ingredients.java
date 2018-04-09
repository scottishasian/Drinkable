package com.example.kynansong.drinkable.Models;

/**
 * Created by kynansong on 19/11/2017.
 */

public class Ingredients {


    private Integer ingredientID;
    private String ingredientNAME;

    public Ingredients(Integer ingredientID, String ingredientNAME) {
        this.ingredientID = ingredientID;
        this.ingredientNAME = ingredientNAME;
    }

    public Integer getIngredientID() {
        return ingredientID;
    }

    public String getIngredientName(){
        return ingredientNAME;
    }

    public void setIngredientName(String ingredient){
        this.ingredientNAME = ingredient;
    }


    public void setingredientID(Integer id) {
        this.ingredientID = id;
    }

}
