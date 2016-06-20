package com.neu.suttida.bookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    //Exelicit   ประกาศตัวแปร
    private EditText nameEditText, userEditText, passwordEditText;
    private String nameString,userString,passwordSting;
    private static final String urlPHP = "http://swiftcodingthai.com/neu/add_user_master.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //Bind Wiget
        nameEditText = (EditText) findViewById(R.id.editText);
        userEditText = (EditText) findViewById(R.id.editText2);
        passwordEditText = (EditText) findViewById(R.id.editText3);

    }// Main Methood

    public void clickSingUpSign(View view) {

        nameString = nameEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordSting = passwordEditText.getText().toString().trim();

        //Check Space
        if (nameString.equals("") ||userString.equals("") || passwordSting.equals("") ) {
            //Have Space
            MyAlert myAlert =new MyAlert();
            myAlert.myDialog(this," มีช่องว่าง","กรุณากรอกทุกช่อง  ค่ะ");

        } else {
            //No Space
            uploadToServer();


        }

    }// clickSign

    private void uploadToServer() {

    }
}//Main Class
