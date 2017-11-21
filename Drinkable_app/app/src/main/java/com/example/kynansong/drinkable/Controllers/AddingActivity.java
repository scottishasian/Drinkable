package com.example.kynansong.drinkable.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.kynansong.drinkable.Database.DrinkableDatabase;
import com.example.kynansong.drinkable.R;

import java.util.List;

public class AddingActivity extends AppCompatActivity {

    Spinner ingredients1;
    Spinner ingredients2;
    Spinner ingredients3;
    ChoicesActivity choices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);



        ingredients1 = (Spinner) findViewById(R.id.ingredient1);
        ingredients2 = (Spinner) findViewById(R.id.ingredient2);
        ingredients3 = (Spinner) findViewById(R.id.ingredient3);

        insertIngredients();
    }

    public void insertIngredients() {

        DrinkableDatabase db = new DrinkableDatabase(this);
        List<String> items = db.getAllIngredients();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);

        ingredients1.setAdapter(adapter);
        ingredients2.setAdapter(adapter);
        ingredients3.setAdapter(adapter);



    }
}
