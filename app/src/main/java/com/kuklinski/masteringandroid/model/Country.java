package com.kuklinski.masteringandroid.model;

import android.content.Context;

public class Country {

    private String countryCode;
    private String name;

    public Country(String countryCode) {
        this.countryCode = countryCode;
        this.name = getNameByCountryCode(countryCode);
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getName() {
        return name;
    }

    public int getImageRes(Context ctx) {
        return ctx.getResources().getIdentifier(countryCode.toLowerCase(), "drawable", ctx.getPackageName());
    }

    public static String getNameByCountryCode(String countryCode) {
        //This method should convert the country code to a name using a list of key values to find the match
        // for the sake of simplicity in this simplicity will be implemented in a quick way
        if (countryCode.equals("ES")) {
            return "Spain";
        } else if (countryCode.equals("GB")) {
            return "Great Britain";
        } else {
            return "Unknown";
        }
    }
}
