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

public class AddIngredientsToCocktailActivity extends AppCompatActivity {

    private List<Ingredients> items;
    private List<Cocktails> drinks;
    private Spinner ingredients1, cocktails1;
    private DrinkableDatabase db;
    private Button add_to_drinks_table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredients_to_cocktail);

        db = new DrinkableDatabase(this);

        ingredients1 = (Spinner) findViewById(R.id.ingredient1);
        cocktails1 = (Spinner) findViewById(R.id.cocktail1);
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

        ingredients1.setAdapter(adapter);
    }

    public void insertCocktails() {

        CocktailsRepo cocktailsRepo = new CocktailsRepo(this);

        this.drinks = cocktailsRepo.getAllCocktails();

        ArrayList<String> bevvys = new ArrayList<>();

        for(Cocktails cocktails : this.drinks) {
            bevvys.add(cocktails.getCocktailName());
        }


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, bevvys);

        cocktails1.setAdapter(adapter1);
    }

    public void onClickAddCocktail() {

        int positionIngred = this.ingredients1.getSelectedItemPosition();
        final Integer idIngred = this.items.get(positionIngred).getIngredientID();

        int positionDrink = this.cocktails1.getSelectedItemPosition();
        final Integer idDrink = this.drinks.get(positionDrink).getCocktailID();


        final DrinksRepo drinksRepo = new DrinksRepo(this);
        add_to_drinks_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = drinksRepo.insertDrink(db.getWritableDatabase(),idDrink, idIngred);
                if(isInserted = true) {
                    Toast.makeText(AddIngredientsToCocktailActivity.this, "Ingredient Added", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AddIngredientsToCocktailActivity.this, "Ingredient Not Added", Toast.LENGTH_LONG).show();
                }
            }
        }
        );
    }
}
