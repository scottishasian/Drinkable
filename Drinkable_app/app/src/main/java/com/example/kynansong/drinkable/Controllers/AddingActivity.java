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

import com.example.kynansong.drinkable.Database.DrinkableDatabase;
import com.example.kynansong.drinkable.Models.Ingredients;
import com.example.kynansong.drinkable.R;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;

import java.util.ArrayList;
import java.util.List;

public class AddingActivity extends AppCompatActivity {

    Spinner ingredients1;
    Spinner ingredients2;
    Spinner ingredients3;
    CocktailsRepo cocktailsRepo;
    EditText name, measurements;
    Button save_cocktail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);

        ingredients1 = (Spinner) findViewById(R.id.ingredient1);
        ingredients2 = (Spinner) findViewById(R.id.ingredient2);
        ingredients3 = (Spinner) findViewById(R.id.ingredient3);
        cocktailsRepo = new CocktailsRepo(this);

        name = (EditText) findViewById(R.id.add_cocktail);
        measurements = (EditText) findViewById(R.id.add_measurements);
        save_cocktail = (Button) findViewById(R.id.save_button);

        insertIngredients();
    }

    public void insertIngredients() {
//
//        DrinkableDatabase db = new DrinkableDatabase(this);
//
//        List<Ingredients> items = db.getAllIngredients();
//
//        ArrayList<String> ingred = new ArrayList<>();
//
//        for(Ingredients ingredient : this.items) {
//            ingred.add(ingredient.getIngredientName());
//        }
//
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, items);
//
//        ingredients1.setAdapter(adapter);
//        ingredients2.setAdapter(adapter);
//        ingredients3.setAdapter(adapter);

    }
//
//    public void addCocktail() {
//        save_cocktail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean isInserted = cocktailsRepo.insertCocktails(SQLiteDatabase, name.getText().toString(),
//                        measurements.getText().toString());
//            }
//        }
//    }

}
