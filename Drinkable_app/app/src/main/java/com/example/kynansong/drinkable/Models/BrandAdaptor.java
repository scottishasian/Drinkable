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
 * Created by kynansong on 25/11/2017.
 */

public class BrandAdaptor extends ArrayAdapter<Brand> {
    public BrandAdaptor(Context context, ArrayList<Brand> brands) {
        super(context,0, brands);
    }

    //To return a list of brands based on the cocktail selected.

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.brand_items, parent, false);
        }

        Brand selectedBrand = getItem(position);

        TextView brandName = listItemView.findViewById(R.id.name_brand);

        brandName.setText(selectedBrand.getBrand_name());

        TextView brandType = listItemView.findViewById(R.id.type_brand);

        brandType.setText(selectedBrand.getBrand_type());

        listItemView.setTag(selectedBrand);

        return listItemView;
    }
}
