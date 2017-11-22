package com.example.kynansong.drinkable.Controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.kynansong.drinkable.Models.CocktailAdaptor;
import com.example.kynansong.drinkable.Models.Cocktails;
import com.example.kynansong.drinkable.R;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;

import java.util.ArrayList;
import java.util.List;

public class Cocktail_ListActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail__list);

        CocktailsRepo cocktailsRepo = new CocktailsRepo(context);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        Integer cocktailName = extras.getInt("cocktailName");

        ArrayList<Cocktails> cocktailResult = cocktailsRepo.getListOfCocktails(cocktailName);

        CocktailAdaptor cocktailAdaptor = new CocktailAdaptor(this, cocktailResult);





        ListView cocktailListView = findViewById(R.id.cocktailList);




        cocktailListView.setAdapter(cocktailAdaptor);




    }
}
