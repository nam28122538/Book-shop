package com.neu.suttida.bookshop;

import android.content.Context;

/**
 * Created by iMac_13 on 6/21/2016 AD.
 */
public class BookAdapter {

    //Explicit
    private Context context;
    private String[] iconString, nameString, priceStrings;

    public BookAdapter(Context context, String[] iconString, String[] nameString, String[] priceStrings) {
        this.context = context;
        this.iconString = iconString;
        this.nameString = nameString;
        this.priceStrings = priceStrings;
    } // Constructor


}//Main Class
