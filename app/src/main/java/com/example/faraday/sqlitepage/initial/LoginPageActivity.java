package com.example.faraday.sqlitepage.initial;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.faraday.sqlitepage.R;
import com.example.faraday.sqlitepage.initial.objects.LoginResponse;
import com.example.faraday.sqlitepage.initial.utils.API;
import com.example.faraday.sqlitepage.initial.utils.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginPageActivity extends AppCompatActivity implements View.OnClickListener {

    Button txt_signup;
    Button btn_login;
    EditText edt_password,edt_username;

    LoginResponse loginResponse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);


        txt_signup = (Button) findViewById(R.id.txt_signup);
        btn_login = (Button) findViewById(R.id.btn_login);
        edt_password = (EditText) findViewById(R.id.edt_password);
        edt_username = (EditText) findViewById(R.id.edt_username);
        btn_login.setOnClickListener(this);
        txt_signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

            switch (view.getId()){

                case R.id.btn_login:

                    if(checkInternetconnection()){
                        loginmethod();
                    }else {
                        Toast.makeText(LoginPageActivity.this,"No Internet Connection",Toast.LENGTH_LONG).show();
                    }

                    break;

                case R.id.txt_signup:
                    signuppage();

                    break;


            }
    }

    private void signuppage() {

        Intent intent = new Intent(LoginPageActivity.this,SignupActivity.class);
        startActivity(intent);
    }

    private void loginmethod() {

        String str_username = edt_username.getText().toString();
        String str_password = edt_password.getText().toString();

        final ProgressDialog progressDialog = new ProgressDialog(LoginPageActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Logging...");
        progressDialog.show();


        API.getservices().login(str_username,str_password,"12345").enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                loginResponse = response.body();
                progressDialog.dismiss();
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginPageActivity.this);
                builder.setMessage("Success");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      Intent intent = new Intent(LoginPageActivity.this,Dashboard.class);
                      intent.putExtra("TokenId",loginResponse.getTokenId());
                      startActivity(intent);
                    }
                });
                builder.show();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                progressDialog.dismiss();
            }
        });


    }

    public boolean checkInternetconnection(){

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo !=null && networkInfo.isConnected();
    }

}
