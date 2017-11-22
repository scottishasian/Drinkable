package com.example.kynansong.drinkable.Controllers;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.kynansong.drinkable.Models.Cocktails;
import com.example.kynansong.drinkable.R;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;

import java.util.ArrayList;

public class Cocktail_ListActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail__list);

//        CocktailsRepo cocktailsRepo = new CocktailsRepo(context);
//
//        ArrayList<Cocktails> cocktailList = cocktailsRepo.getListOfCocktails(ingredientId);
//
//        ListView listView = findViewById(R.id.cocktailList);
//
//        listView.setAdapter(cocktailAdaptor);
    }
}
