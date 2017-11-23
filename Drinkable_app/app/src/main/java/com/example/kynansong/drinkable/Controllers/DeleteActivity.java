package com.example.kynansong.drinkable.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kynansong.drinkable.Database.DrinkableDatabase;
import com.example.kynansong.drinkable.Models.Cocktails;
import com.example.kynansong.drinkable.R;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;
import com.example.kynansong.drinkable.Repo.DrinksRepo;

import java.util.ArrayList;
import java.util.List;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Cocktails> drinks;
    private DrinkableDatabase db;
    private CocktailsRepo cocktailsRepo;
    private Button delete_cocktail;
    private Spinner spinner_cocktails1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        db = new DrinkableDatabase(this);
        cocktailsRepo = new CocktailsRepo(this);

        spinner_cocktails1 = (Spinner) findViewById(R.id.delete_cocktail_list);
        delete_cocktail = (Button) findViewById(R.id.delete_button);

        insertCocktails();
    }

    public void insertCocktails() {

        cocktailsRepo = new CocktailsRepo(this);

        this.drinks = cocktailsRepo.getAllCocktails();

        ArrayList<String> drink_item = new ArrayList<>();

        for(Cocktails cocktails : this.drinks) {
            drink_item.add(cocktails.getCocktailName());
        }


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, drink_item);

        spinner_cocktails1.setAdapter(adapter1);
    }

    public void onClickDeleteCocktail() {
        delete_cocktail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int positionDrink = this.spinner_cocktails1.getSelectedItemPosition();
        final Integer idDrink = this.drinks.get(positionDrink).getCocktailID();

        cocktailsRepo.deleteCocktail(idDrink);
        Toast.makeText(DeleteActivity.this, "Cocktail Deleted", Toast.LENGTH_LONG).show();

    }
}
