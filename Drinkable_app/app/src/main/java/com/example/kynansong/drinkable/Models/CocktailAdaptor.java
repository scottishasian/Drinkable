package com.example.kynansong.drinkable.Models;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kynansong.drinkable.R;

import java.util.ArrayList;

/**
 * Created by kynansong on 22/11/2017.
 */

public class CocktailAdaptor extends ArrayAdapter<Cocktails>{
    public CocktailAdaptor(Context context, ArrayList<Cocktails> cocktails) {
        super(context,0, cocktails);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.cocktail_items, parent, false);
        }

        Cocktails currentCocktailItem = getItem(position);

        TextView cocktail_name = listItemView.findViewById(R.id.cocktal_name);

        cocktail_name.setText(currentCocktailItem.getCocktailName());

        TextView cocktail_measurements = listItemView.findViewById(R.id.cocktail_measurements);

        cocktail_measurements.setText(currentCocktailItem.getCocktailMeasurements());

        listItemView.setTag(currentCocktailItem);

        return listItemView;
    }
}
