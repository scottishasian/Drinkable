package com.example.kynansong.drinkable.Controllers;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.kynansong.drinkable.Database.DrinkableDatabase;
import com.example.kynansong.drinkable.Models.Ingredients;
import com.example.kynansong.drinkable.R;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;
import com.example.kynansong.drinkable.Repo.DrinksRepo;
import com.example.kynansong.drinkable.Repo.IngredientsRepo;

import java.util.ArrayList;
import java.util.List;

public class ChoicesActivity extends AppCompatActivity {
    Context context;
    IngredientsRepo ingredientsRepo;


    Button submitButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);
        DrinkableDatabase db = new DrinkableDatabase(this);
//        List<String> items = db.getAllIngredients();
//
//        this.submitButton = (Button) findViewById(R.id.submit_button);
//
//        Spinner ingredients = (Spinner) findViewById(R.id.ingredient_choice);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, items);
//
//        ingredients.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String name = (String)parent.getSelectedItem();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });



    }



    public void onButtonClickChoices(View button) {
        Intent intent = new Intent(this, Cocktail_ListActivity.class);

        startActivity(intent);
    }


}
