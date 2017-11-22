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


        String cocktailInfo = extras.getString("info");
        String cocktailMeasurements = extras.getString("measurements");


        TextView cocktailInfoTextView = findViewById(R.id.cocktail_information);
        TextView cocktailMeasurementTextView = findViewById(R.id.cocktail_measurements);


        cocktailInfoTextView.setText(cocktailInfo);
        cocktailMeasurementTextView.setText(cocktailMeasurements);

    }




}
