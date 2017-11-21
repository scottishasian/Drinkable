package com.example.kynansong.drinkable.Controllers;

import android.content.Context;
import android.content.Intent;
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

    Spinner spinner;

    Button submitButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);

        this.submitButton = (Button) findViewById(R.id.submit_button);
        DrinkableDatabase db = new DrinkableDatabase(this);

//        ArrayList<String> ingredientschoices = db.getAllIngredients();
//        Spinner choices = (Spinner)findViewById(R.id.ingredient_choice);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>
//                (this, R.layout.activity_choices,  ingredientschoices);
//        choices.setAdapter(adapter);
    }



    public void onButtonClickChoices(View button) {
        Intent intent = new Intent(this, Cocktail_ListActivity.class);

        startActivity(intent);
    }


}
