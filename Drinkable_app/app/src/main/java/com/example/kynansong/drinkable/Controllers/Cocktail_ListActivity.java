package com.example.kynansong.drinkable.Controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kynansong.drinkable.Models.CocktailAdaptor;
import com.example.kynansong.drinkable.Models.Cocktails;
import com.example.kynansong.drinkable.R;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;

import java.util.ArrayList;
import java.util.List;

public class Cocktail_ListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail__list);

        final CocktailsRepo cocktailsRepo = new CocktailsRepo(this);

        ListView cocktailListView = findViewById(R.id.cocktailList);

        final Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        final Integer cocktailID = extras.getInt("cocktailID");

        ArrayList<Cocktails> cocktailResult = cocktailsRepo.getListOfCocktails(cocktailID);

        CocktailAdaptor cocktailAdaptor = new CocktailAdaptor(this, cocktailResult);

        cocktailListView.setAdapter(cocktailAdaptor);



        cocktailListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent goToInfo = new Intent(Cocktail_ListActivity.this, CocktailInfoActivity.class);

                String info = cocktailsRepo.getCocktailInfo(cocktailID);

                goToInfo.putExtra("info", info);



                startActivity(goToInfo);
            }
        });

    }


}
