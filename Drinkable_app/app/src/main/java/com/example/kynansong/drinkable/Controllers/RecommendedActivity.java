package com.example.kynansong.drinkable.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.kynansong.drinkable.Models.Brand;
import com.example.kynansong.drinkable.Models.BrandAdaptor;
import com.example.kynansong.drinkable.Models.CocktailAdaptor;
import com.example.kynansong.drinkable.Models.Cocktails;
import com.example.kynansong.drinkable.R;
import com.example.kynansong.drinkable.Repo.BrandRepo;

import java.util.ArrayList;

public class RecommendedActivity extends AppCompatActivity {


    BrandRepo brandRepo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended);

        brandRepo = new BrandRepo(this);

        ListView brandListView = findViewById(R.id.brandlist);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        Integer cocktailID = extras.getInt("brandInfo");

        ArrayList<Brand> brandResult = brandRepo.getAllBrands(cocktailID);

        BrandAdaptor brandAdaptor = new BrandAdaptor(this, brandResult);

        brandListView.setAdapter(brandAdaptor);

    }

    public void getSelectedBrandID(View listItemSelected) {

        Brand selectedBrand = (Brand) listItemSelected.getTag();

        Intent goToWebsite = new Intent(RecommendedActivity.this, WebViewActivity.class);

        String websiteLink = brandRepo.getBrandWebsite(selectedBrand.getBrand_id());

        goToWebsite.putExtra("weblink", websiteLink);

        startActivity(goToWebsite);
    }
}

//Issue with back button as app crashes when returning to the cocktail info page.
