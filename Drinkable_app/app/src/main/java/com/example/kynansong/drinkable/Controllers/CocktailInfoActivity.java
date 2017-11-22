package com.example.kynansong.drinkable.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.kynansong.drinkable.Models.Cocktails;
import com.example.kynansong.drinkable.R;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;

import java.awt.font.TextAttribute;

public class CocktailInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail_info);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        CocktailsRepo cocktailsRepo = new CocktailsRepo(this);

        String cocktailInfo = extras.getString("info");

        TextView cocktailInfoTextView = findViewById(R.id.cocktail_information);


        cocktailInfoTextView.setText(cocktailInfo);

    }




}
