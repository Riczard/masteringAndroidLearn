package com.kuklinski.masteringandroid.holders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuklinski.masteringandroid.R;
import com.kuklinski.masteringandroid.model.Country;

public class CountryViewHolder {

    private TextView name;
    private ImageView flag;

    public CountryViewHolder(View view) {
        this.name = view.findViewById(R.id.rowJobCountryTitle);
        this.flag = view.findViewById(R.id.rowJobCountryImage);

    }

    public void bindView(Country country, Context context) {
        this.name.setText(country.getName());
        this.flag.setImageResource(country.getImageRes(context));
    }
}
