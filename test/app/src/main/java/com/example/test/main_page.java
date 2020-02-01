package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class main_page extends AppCompatActivity {


    Button register ,viewdata;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        setTitle("Your Account");

        register= findViewById(R.id.register);
        viewdata=findViewById(R.id.viewdata);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(main_page.this,register_new_client.class);
                startActivity(i);
            }
        });


        viewdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(main_page.this,view_data.class);
                startActivity(i);
            }
        });


    }
}
