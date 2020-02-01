package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.register_new_client;
import com.example.test.view_data;

public class login extends AppCompatActivity {


    Button li ,su;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle("Home Page");

        li= findViewById(R.id.li);
        su=findViewById(R.id.su);


        li.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(com.example.test.login.this, signin.class);
                startActivity(i);
            }
        });


        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(com.example.test.login.this, signup.class);
                startActivity(i);
            }
        });


    }
}