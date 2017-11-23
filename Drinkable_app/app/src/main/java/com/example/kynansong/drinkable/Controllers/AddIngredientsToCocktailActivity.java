package com.example.kynansong.drinkable.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kynansong.drinkable.Database.DrinkableDatabase;
import com.example.kynansong.drinkable.Models.Cocktails;
import com.example.kynansong.drinkable.Models.Ingredients;
import com.example.kynansong.drinkable.R;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;
import com.example.kynansong.drinkable.Repo.DrinksRepo;

import java.util.ArrayList;
import java.util.List;

public class AddIngredientsToCocktailActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Ingredients> items;
    private List<Cocktails> drinks;
    private Spinner spinner_ingredients1, spinner_cocktails1;
    private DrinkableDatabase db;
    private Button add_to_drinks_table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredients_to_cocktail);

        db = new DrinkableDatabase(this);

        spinner_ingredients1 = (Spinner) findViewById(R.id.ingredient1);
        spinner_cocktails1 = (Spinner) findViewById(R.id.cocktail1);
        add_to_drinks_table = (Button) findViewById(R.id.add_to_drinks_table);

        insertIngredients();
        insertCocktails();
        onClickAddCocktail();
    }


    // This activity is used to add cocktail and ingredient ids to Drinks table which is a joining table.

    public void insertIngredients() {

        this.items = db.getAllIngredients();

        ArrayList<String> ingred = new ArrayList<>();

        for(Ingredients ingredient : this.items) {
            ingred.add(ingredient.getIngredientName());
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, ingred);

        spinner_ingredients1.setAdapter(adapter);
    }

    public void insertCocktails() {

        CocktailsRepo cocktailsRepo = new CocktailsRepo(this);

        this.drinks = cocktailsRepo.getAllCocktails();

        ArrayList<String> drink_item = new ArrayList<>();

        for(Cocktails cocktails : this.drinks) {
            drink_item.add(cocktails.getCocktailName());
        }


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, drink_item);

        spinner_cocktails1.setAdapter(adapter1);
    }

    public void onClickAddCocktail() {
        add_to_drinks_table.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final DrinksRepo drinksRepo = new DrinksRepo(this);

        int positionIngred = this.spinner_ingredients1.getSelectedItemPosition(); //returns 0 position
        final Integer idIngred = this.items.get(positionIngred).getIngredientID();

        int positionDrink = this.spinner_cocktails1.getSelectedItemPosition();
        final Integer idDrink = this.drinks.get(positionDrink).getCocktailID();

        boolean isInserted = drinksRepo.insertDrink(db.getWritableDatabase(),idDrink, idIngred);
        if(isInserted == true) {
            Toast.makeText(AddIngredientsToCocktailActivity.this, "Ingredient Added", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(AddIngredientsToCocktailActivity.this, "Ingredient Not Added", Toast.LENGTH_LONG).show();
        }
    }
}
