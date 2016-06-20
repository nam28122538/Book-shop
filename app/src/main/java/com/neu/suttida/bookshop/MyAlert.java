package com.neu.suttida.bookshop;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

/**
 * Created by iMac_13 on 6/20/2016 AD.
 */
public class MyAlert {

    public void myDialog(Context context,
                         String strTitle,
                         String strMessage) {
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.bird48);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("จร้า", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
           dialogInterface.dismiss();
            }
        });
        builder.show();


    }

}//Main Class
