package com.example.kynansong.drinkable.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kynansong.drinkable.Database.DrinkableDatabase;
import com.example.kynansong.drinkable.R;

public class AddInfoActivity extends AppCompatActivity {

    DrinkableDatabase myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);
    }
}
