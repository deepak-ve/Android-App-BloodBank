package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class view_data extends AppCompatActivity {


    Button register, viewdata;
    FirebaseFirestore db;
    Map<String, Object> maaap2 = new HashMap<>();
    ListView clientdatalist;
    ArrayList<client_model> arrayList;

    list_adapter adapter ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_data);
        setTitle("Blood Availability");
        updatelist();
    }


    public void updatelist() {
        clientdatalist = findViewById(R.id.clients_list_view);
        arrayList = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        CollectionReference client_collection = db.collection("bloodbank");

        client_collection
                .get().
                addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                                 @Override
                                                 public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                     if (task.isSuccessful()) {
                                                         Toast.makeText(view_data.this, String.valueOf(task.getResult().size()), Toast.LENGTH_SHORT).show();
                                                         for (QueryDocumentSnapshot documentSnapshot:  task.getResult()) {
                                                             Map<String, Object> map = documentSnapshot.getData();
                                                             String cname = String.valueOf(map.get("name"));
                                                             String ceid = String.valueOf(map.get("emailid"));
                                                             String caddress = String.valueOf(map.get("addr"));
                                                             int cage = Integer.parseInt(map.get("age").toString());
                                                             String bloodgroup = (String)map.get("bloodgroup");

                                                             arrayList.add(new client_model( caddress,cname, bloodgroup,  ceid, cage));
                                                         }
                                                     }
                                                     adapter = new list_adapter(arrayList, view_data.this);
                                                     clientdatalist.setAdapter(adapter);
                                                 }
                                             }
        );
    }

}