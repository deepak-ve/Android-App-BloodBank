package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class signup  extends AppCompatActivity{

    EditText eid,pwwd;
    Button sup;
    String usereid,userpwd;
    FirebaseFirestore db2;
    Map<String,Object> new_user ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        setTitle("Register User");

        eid = findViewById(R.id.eid);
        pwwd = findViewById(R.id.pwwd);

        sup=findViewById(R.id.su_btn);
        sup.setVisibility(View.VISIBLE);




        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){


                usereid =eid.getText().toString();
                userpwd =pwwd.getText().toString();

                if(usereid.isEmpty()){
                    eid.setError("Enter the emailid");
                    eid.requestFocus();
                }
                else if(userpwd.isEmpty()){
                    pwwd.setError("Enter the client age");
                    pwwd.requestFocus();
                }
                else {



                    new_user = new HashMap<>();
                    new_user.put("emailid",usereid);
                    new_user.put("pass",userpwd);

                    /////
                    senddata(new_user);

                    finish();
                    /////




                }


            }
        });

    }

    public void senddata(Map data){

        Date currentTime = Calendar.getInstance().getTime();
        db2= FirebaseFirestore.getInstance();
        db2.collection("userinfo")
                .document(String.valueOf(currentTime))
                .set(data, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(signup.this, "added", Toast.LENGTH_SHORT).show();
                Log.i("addedadded","data");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(signup.this, "failed", Toast.LENGTH_SHORT).show();
            }
        })
        ;


    }
}


