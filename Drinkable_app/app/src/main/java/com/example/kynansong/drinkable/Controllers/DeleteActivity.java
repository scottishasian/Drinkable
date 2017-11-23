package com.example.kynansong.drinkable.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.kynansong.drinkable.Database.DrinkableDatabase;
import com.example.kynansong.drinkable.Models.Cocktails;
import com.example.kynansong.drinkable.R;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;

import java.util.ArrayList;
import java.util.List;

public class DeleteActivity extends AppCompatActivity {

    private List<Cocktails> drinks;
    private DrinkableDatabase db;
    private Button delete_cocktail;
    private Spinner spinner_cocktails1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        db = new DrinkableDatabase(this);

        spinner_cocktails1 = (Spinner) findViewById(R.id.delete_cocktail_list);
        delete_cocktail = (Button) findViewById(R.id.delete_button);

        insertCocktails();
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
}
