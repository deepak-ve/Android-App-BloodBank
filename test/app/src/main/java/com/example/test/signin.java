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


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class signin  extends AppCompatActivity{

    EditText eidsi,pwwdsi;
    Button sin;
    String usereid,userpwd;
    FirebaseFirestore db2;
    Map<String,Object> new_user ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        setTitle("User Sign in");


        eidsi = findViewById(R.id.eidsi);
        pwwdsi = findViewById(R.id.pwwdsi);

        sin=findViewById(R.id.si_btn);
        sin.setVisibility(View.VISIBLE);




        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){


                usereid =eidsi.getText().toString();
                userpwd =pwwdsi.getText().toString();


                if(usereid.isEmpty()){
                    eidsi.setError("Enter the emailid");
                    eidsi.requestFocus();
                }
                else if(userpwd.isEmpty()){
                    pwwdsi.setError("Enter the client age");
                    pwwdsi.requestFocus();
                }
                else {
                    verifyit();

                    finish();
                    /////




                }


            }
        });


    }
    public void verifyit(){
        db2 = FirebaseFirestore.getInstance();
        CollectionReference client_collection = db2.collection("userinfo");

        client_collection
                .whereEqualTo("emailid",usereid)
                .whereEqualTo("pass",userpwd)
                .get().
                addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                          @Override
                                          public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                              if (task.isSuccessful()) {
                                                  Toast.makeText(signin.this, String.valueOf(task.getResult().size()), Toast.LENGTH_SHORT).show();
                                                  int s =task.getResult().size();
                                                  if(s==0)
                                                  {
                                                      eidsi.setError("Enter the emailid");
                                                      eidsi.requestFocus();
                                                      pwwdsi.setError("Enter the client age");
                                                      pwwdsi.requestFocus();
                                                  }
                                                  else
                                                  {
                                                      Intent i =new Intent(signin.this,main_page.class);
                                                      startActivity(i);
                                                  }



                                              }

                                          }
                                      }
                );
    }
    }

//}


