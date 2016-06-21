package com.neu.suttida.bookshop;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    //Explicit
    private EditText userEditTex,passwordEditText;
    private String userString,passwoetString;
    private static final String urlJSON = "http://swiftcodingthai.com/neu/get_user.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Windget
        userEditTex = (EditText)findViewById(R.id.editText4);
        passwordEditText = (EditText)findViewById(R.id.editText5);


    } //Main Method

    //create Inner vClass
    private class MySynchronize extends AsyncTask<Void, Void, String> {

        private Context context;
        private String urLString;
        private boolean statusABoolean = true;
        private String truePasswordString;


        public MySynchronize(Context context, String urLString) {
            this.context = context;
            this.urLString = urLString;
        }

        @Override
        protected String doInBackground(Void... voids) {


            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urLString).build();
                Response response =okHttpClient.newCall(request).execute();
                return response.body().string();


            }catch (Exception e){
                return null;
            }

        } //doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("BookShopV1","JSON ==> "+ s);

            try {

                JSONArray jsonArray = new JSONArray(s);
                for (int i=0;i<jsonArray.length();i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    if (userString.equals(jsonObject.getString("User"))) {
                        statusABoolean = false;
                        truePasswordString = jsonObject.getString("Password");




                    }//if

                }//for

                //checkUser
                if (statusABoolean) {
                    MyAlert myAlert = new MyAlert();
                    myAlert.myDialog(context,"ไม่มี User นี้", "ไม่มี " + userString + " ไม่มีในฐานข้อมูลของเรา");
                } else if (passwoetString.equals(truePasswordString)) {
                    //Password
                    Toast.makeText(context, "Welcome User",Toast.LENGTH_SHORT).show();

                } else {
                    MyAlert myAlert = new MyAlert();
                    myAlert.myDialog(context,"Password False","Please Tey Password False");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } //onPost
    } //Class

    public  void clickSignIn(View view){
        //Get Value form Edit text
        userString = userEditTex.getText().toString().trim();
        passwoetString = passwordEditText.getText().toString().trim();
         //check space
        if (userString.equals("") || passwoetString.equals("") ) {
            //Have Space
            MyAlert myAlert =new MyAlert();
            myAlert.myDialog(this," Have Space","Please Fill All Blank");

        } else {

            searchUserAnPassword();

            //No Space


        }




    } // clickSignIn

    private void searchUserAnPassword() {

        MySynchronize mySynchronize = new MySynchronize(this, urlJSON);
        mySynchronize.execute();

    } //searchUser

    public void clickSignUpMain(View view) {
        startActivity(new Intent(MainActivity.this,SignUpActivity.class));
    }
}// Main Class นี้คือ คลาสหลัก
