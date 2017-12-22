package com.example.kynansong.drinkable.Controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kynansong.drinkable.Models.CocktailAdaptor;
import com.example.kynansong.drinkable.Models.Cocktails;
import com.example.kynansong.drinkable.R;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;

import java.util.ArrayList;
import java.util.List;

public class Cocktail_ListActivity extends AppCompatActivity {

    CocktailsRepo cocktailsRepo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail__list);

        cocktailsRepo = new CocktailsRepo(this);

        ListView cocktailListView = findViewById(R.id.cocktailList);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        Integer cocktailID = extras.getInt("IngredientID");

        ArrayList<Cocktails> cocktailResult = cocktailsRepo.getListOfCocktails(cocktailID);

        CocktailAdaptor cocktailAdaptor = new CocktailAdaptor(this, cocktailResult);

        cocktailListView.setAdapter(cocktailAdaptor);

        //possible link to see all cocktails available.


    }

    public void getSelectedCocktailID(View listItemSelected) {

        Cocktails selectedCocktail = (Cocktails) listItemSelected.getTag();

        Intent goToInfo = new Intent(Cocktail_ListActivity.this, CocktailInfoActivity.class);

        String info = cocktailsRepo.getCocktailInfo(selectedCocktail.getCocktailID());
        String measurements = cocktailsRepo.getCocktailMeasurements(selectedCocktail.getCocktailID());
        String name = cocktailsRepo.getCocktailName(selectedCocktail.getCocktailID());
        Integer cocktailId = selectedCocktail.getCocktailID();

        goToInfo.putExtra("info", info);
        goToInfo.putExtra("measurements", measurements);
        goToInfo.putExtra("name", name);
        goToInfo.putExtra("cocktailId", cocktailId);

        startActivity(goToInfo);

    }


}
