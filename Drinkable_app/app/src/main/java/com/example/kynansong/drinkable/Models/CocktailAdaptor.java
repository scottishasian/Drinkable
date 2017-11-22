package com.example.kynansong.drinkable.Models;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by kynansong on 22/11/2017.
 */

public class CocktailAdaptor extends ArrayAdapter<Cocktails>{
    public CocktailAdaptor(Context context, ArrayList<Cocktails> cocktails) {
        super(context,0,cocktails);
    }
}
