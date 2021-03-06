package com.neu.suttida.bookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

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
        OkHttpClient okHttpClient=new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd","true")
                .add("Name",nameString)
                .add("User",userString)
                .add("Password",passwordSting)
                .build();
        Request.Builder builder =new Request.Builder();
        Request request = builder.url(urlPHP).post(requestBody).build();
        Call call =okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                finish();

            }
        });


    }// Upload
}//Main Class
