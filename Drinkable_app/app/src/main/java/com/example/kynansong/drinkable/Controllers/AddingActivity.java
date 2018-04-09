package com.example.kynansong.drinkable.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kynansong.drinkable.Database.DrinkableDatabase;
import com.example.kynansong.drinkable.R;
import com.example.kynansong.drinkable.Repo.CocktailsRepo;
import com.example.kynansong.drinkable.Repo.DrinksRepo;

public class AddingActivity extends AppCompatActivity {


    private CocktailsRepo cocktailsRepo;
    private DrinksRepo drinksRepo;
    private EditText name, measurements, description;
    private Button save_cocktail, add_ingredient;
    private DrinkableDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);

        cocktailsRepo = new CocktailsRepo(this);
        drinksRepo = new DrinksRepo(this);
        db = new DrinkableDatabase(this);

        name = (EditText) findViewById(R.id.add_cocktail);
        measurements = (EditText) findViewById(R.id.add_measurements);
        description = (EditText) findViewById(R.id.add_description);
        save_cocktail = (Button) findViewById(R.id.save_button);
        add_ingredient = (Button) findViewById(R.id.add_ingredient);

        onClickAddCocktail();
    }

    //Write a function to create a list of ingredients that are then saved when saving the new cocktail info.


//    public void addIngredientToList(View button) {
//        add_ingredient.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                int position = ingredients1.getSelectedItemPosition();
//                Ingredients ingredientsObject = items.get(position);
//                new_cocktail.add(ingredientsObject);
//
//                Toast.makeText(AddingActivity.this, "Ingredient Added " + new_cocktail.size(), Toast.LENGTH_LONG).show();
//
//            }
//        });
//
//
//    }
//
//    public ArrayList<Integer> getIngredientsListIds() {
//        ArrayList<Integer> ids = new ArrayList<>();
//        for(Ingredients id : new_cocktail) {
//            ids.add(id.getIngredientID());
//        }
//        return ids;
//    }

    public void onButtonClickToAddIngredients(View button) {
    Intent intent = new Intent(this, AddIngredientsToCocktailActivity.class);

    startActivity(intent);
    }

    public void onClickAddCocktail() {
        save_cocktail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((name.getText().length() != 0) && (measurements.getText().length() != 0)) {
                    cocktailsRepo.insertCocktails(db.getWritableDatabase(), name.getText().toString(),
                            measurements.getText().toString(), description.getText().toString());
                    Toast.makeText(AddingActivity.this, "Cocktail Added", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AddingActivity.this, "Cocktail Not Added", Toast.LENGTH_LONG).show();
                }
            }
        }
        );
    }

}
