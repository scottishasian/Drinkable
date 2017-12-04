package com.example.kynansong.drinkable.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kynansong.drinkable.Models.Cocktails;
import com.example.kynansong.drinkable.R;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;

import java.awt.font.TextAttribute;

public class CocktailInfoActivity extends AppCompatActivity {

    private Button recommended_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail_info);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();


        String cocktailInfo = extras.getString("info");
        String cocktailMeasurements = extras.getString("measurements");
        String cocktailName = extras.getString("name");


        TextView cocktailInfoTextView = findViewById(R.id.cocktail_information);
        TextView cocktailMeasurementTextView = findViewById(R.id.cocktail_measurements);
        TextView cocktailNameTextView = findViewById(R.id.name_of_cocktail);


        cocktailInfoTextView.setText(cocktailInfo);
        cocktailMeasurementTextView.setText(cocktailMeasurements);
        cocktailNameTextView.setText(cocktailName);

        this.recommended_button = (Button) findViewById(R.id.recommended_brand_button);

    }

    public void onRecommendedButtonClick(View button) {
        Intent intent = new Intent(this, RecommendedActivity.class);

        Intent cocktailid = getIntent();

        Bundle extrasBrand = cocktailid.getExtras();

        Integer brandInfo = extrasBrand.getInt("cocktailId");

        intent.putExtra("brandInfo", brandInfo);


        startActivity(intent);
    }

    public void onWhereToFindButtonClick(View button) {

        Intent toMap = new Intent(this, BarLocationsActivity.class);

        Toast.makeText(CocktailInfoActivity.this, "Under Construction", Toast.LENGTH_LONG).show();

        startActivity(toMap);

    }




}
