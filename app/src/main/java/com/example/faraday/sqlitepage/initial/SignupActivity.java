package com.example.faraday.sqlitepage.initial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.faraday.sqlitepage.R;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {


    EditText edt_name,edt_email,edt_password;
    Button btn_signup;
    Button txt_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signuppage);

        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_password = (EditText) findViewById(R.id.edt_password);

        btn_signup = (Button) findViewById(R.id.btn_signup);
        txt_login = (Button) findViewById(R.id.txt_login);

        btn_signup.setOnClickListener(this);
        txt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn_signup:
                signupmethod();
                break;
            case R.id.txt_login:
                loginpage();
                break;
        }
    }

    private void loginpage() {
        Intent intent = new Intent(SignupActivity.this,LoginPageActivity.class);
        startActivity(intent);
    }

    private void signupmethod() {

        String str_name = edt_name.getText().toString();
        String str_email = edt_email.getText().toString();
        String str_pass = edt_password.getText().toString();



    }
}
