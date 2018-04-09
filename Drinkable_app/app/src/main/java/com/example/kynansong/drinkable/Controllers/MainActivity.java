package com.example.kynansong.drinkable.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.kynansong.drinkable.R;

public class MainActivity extends AppCompatActivity {

    private Button welcomeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        this.welcomeButton = (Button) findViewById(R.id.welcome_button);
    }

    public void onButtonClick(View button) {
        Intent intent = new Intent(this, ChoicesActivity.class);

        startActivity(intent);
    }
}
