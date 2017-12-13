package com.example.kynansong.drinkable.Controllers;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import java.util.Collections;
import java.util.List;

public class ChoicesActivity extends AppCompatActivity {
    Context context;
    IngredientsRepo ingredientsRepo;
    Spinner ingredients;

    List<Ingredients> items;
    Button submitButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);



        this.submitButton = (Button) findViewById(R.id.submit_button);

        ingredients = (Spinner) findViewById(R.id.ingredient_choice);

        insertData();



    }

    public void insertData() {

        IngredientsRepo ingredientsRepo = new IngredientsRepo(this);

        this.items = ingredientsRepo.getAllIngredients();


        ArrayList<String> ingred = new ArrayList<>();



        for(Ingredients ingredient : this.items) {
            ingred.add(ingredient.getIngredientName());
            Collections.sort(ingred);
        }



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, ingred);



        ingredients.setAdapter(adapter);



    }

    public void onButtonClickChoices(View button) {
        Intent intent = new Intent(this, Cocktail_ListActivity.class);

        int position = this.ingredients.getSelectedItemPosition();

        Integer id = this.items.get(position).getIngredientID();


        intent.putExtra("IngredientID", id);


        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_choices, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_add_cocktail) {
            Intent intent = new Intent(this, AddingActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.action_delete_cocktail) {
            Intent intent = new Intent(this, DeleteActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.action_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }
        return true;
    }


}
