package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText edtname,edtpass;
    TextView textregister;

    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtname=findViewById(R.id.email);
        edtpass=findViewById(R.id.password);
        textregister=findViewById(R.id.register);
        btnlogin=findViewById(R.id.login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edtname.getText().toString();
                String password = edtpass.getText().toString();
                Toast.makeText(getApplicationContext(),"Logging in",Toast.LENGTH_SHORT).show();

            }
        });

        textregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,SignUp.class);
                Login.this.startActivity(intent);
            }
        });
    }
}