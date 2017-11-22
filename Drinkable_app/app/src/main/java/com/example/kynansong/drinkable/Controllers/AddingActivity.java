package com.example.kynansong.drinkable.Controllers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kynansong.drinkable.Database.DrinkableDatabase;
import com.example.kynansong.drinkable.Models.Ingredients;
import com.example.kynansong.drinkable.R;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;
import com.example.kynansong.drinkable.Repo.DrinksRepo;

import java.util.ArrayList;
import java.util.List;

public class AddingActivity extends AppCompatActivity {

    Spinner ingredients1;
    CocktailsRepo cocktailsRepo;
    DrinksRepo drinksRepo;
    EditText name, measurements;
    Button save_cocktail;
    List<Ingredients> items;
    DrinkableDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);

        ingredients1 = (Spinner) findViewById(R.id.ingredient1);

        cocktailsRepo = new CocktailsRepo(this);
        drinksRepo = new DrinksRepo(this);
        db = new DrinkableDatabase(this);

        name = (EditText) findViewById(R.id.add_cocktail);
        measurements = (EditText) findViewById(R.id.add_measurements);
        save_cocktail = (Button) findViewById(R.id.save_button);

        insertIngredients();
    }

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

    //Write a function to create a list of ingredients that are then saved when saving the new cocktail info.

//    public ArrayList<Ingredients> addIngredientsList(){
//
//    }

    public void addCocktail() {
        save_cocktail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = cocktailsRepo.insertCocktails(db.getWritableDatabase(), name.getText().toString(),
                        measurements.getText().toString());
                if(isInserted = true) {
                    Toast.makeText(AddingActivity.this, "Cocktail Added", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AddingActivity.this, "Cocktail Not Added", Toast.LENGTH_LONG).show();
                }
            }
        }
        );
    }

}
