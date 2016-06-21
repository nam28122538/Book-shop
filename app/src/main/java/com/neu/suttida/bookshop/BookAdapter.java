package com.neu.suttida.bookshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by iMac_13 on 6/21/2016 AD.
 */
public class BookAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] iconString, nameString, priceStrings;

    public BookAdapter(Context context, String[] iconString, String[] nameString, String[] priceStrings) {
        this.context = context;
        this.iconString = iconString;
        this.nameString = nameString;
        this.priceStrings = priceStrings;
    } // Constructor


    @Override
    public int getCount() {
        return nameString.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.book_listview, viewGroup, false);
        ImageView imageView =(ImageView) view1.findViewById(R.id.imageView2);
        Picasso.with(context).load(iconString[i]).resize(150,180).into(imageView);

        TextView nameTextView =(TextView)view1.findViewById(R.id.textView7);
        nameTextView.setText(nameString[i]);

        TextView priceTextView = (TextView)view1.findViewById(R.id.textView8);
        nameTextView.setText(nameString[i]);




        return view1;
    }
}//Main Class
