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

public class register_new_client  extends AppCompatActivity{

    EditText addr,bloodgroup,name,emailid,age;
    Button submit_user;
    String donaddress,donbloodgroup,donname,donemailid,donage;
    FirebaseFirestore db;
    Map<String,Object> new_donor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_new_client);
        setTitle("Register Donor");

        addr = findViewById(R.id.addr);
        bloodgroup = findViewById(R.id.bloodgroup);
        name = findViewById(R.id.name);
        emailid = findViewById(R.id.emailid);
        age = findViewById(R.id.age);

        submit_user=findViewById(R.id.reg_btn);
        submit_user.setVisibility(View.VISIBLE);




        submit_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                donaddress =addr.getText().toString();
                donbloodgroup =bloodgroup.getText().toString();
                donname =name.getText().toString();
                donemailid =emailid.getText().toString();
                donage =age.getText().toString();

                if(donaddress.isEmpty()){
                    addr.setError("Enter the address ");
                    addr.requestFocus();
                }
                else if(donbloodgroup.isEmpty()){
                    bloodgroup.setError("Enter the blood group");
                    bloodgroup.requestFocus();
                }
                else if(donname.isEmpty()){
                    name.setError("Enter the Name");
                    name.requestFocus();
                }
                else if(donemailid.isEmpty()){
                    emailid.setError("Enter the emailid");
                    emailid.requestFocus();
                }
                else if(donage.isEmpty()){
                    age.setError("Enter the client age");
                    age.requestFocus();
                }
//                else if(donage.isEmpty()){
//                    age.setError("Enter the client age");
//                    age.requestFocus();
//                }
                else {

                    int iage =Integer.parseInt(donage);

                    new_donor = new HashMap<>();
                    new_donor.put("addr",donaddress);
                    new_donor.put("bloodgroup",donbloodgroup);
                    new_donor.put("name",donname);
                    new_donor.put("emailid",donemailid);
                    new_donor.put("age",iage);

                    /////
                    senddata(new_donor);

                    finish();
                    /////




                }


            }
        });

    }

    public void senddata(Map data){

        Date currentTime = Calendar.getInstance().getTime();
        db= FirebaseFirestore.getInstance();
        db.collection("bloodbank")
                .document(String.valueOf(currentTime))
                .set(data, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(register_new_client.this, "added", Toast.LENGTH_SHORT).show();
                Log.i("addedadded","data");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(register_new_client.this, "failed", Toast.LENGTH_SHORT).show();
            }
        })
        ;


    }
}


