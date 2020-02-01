package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;


import java.util.ArrayList;

public class list_adapter extends ArrayAdapter<client_model> {

    private ArrayList<client_model> dataSet;
    public Context mContext;

    public list_adapter(ArrayList<client_model> data, Context context) {
        super(context, R.layout.row_client, data);
        this.dataSet = data;
        this.mContext=context;
    }


    @Override
    public int getCount() {
        int count=dataSet.size(); //counts the total number of elements from the arrayList.
        return count;//returns the total count to adapter
    }

    @Nullable
    @Override
    public client_model getItem(int position) {
        return dataSet.get(position);
    }


    @Nullable
    @Override
    public View getView(int position, View convertView, @Nullable ViewGroup parent) {
         client_model cm = getItem(position);
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_client, parent, false);
      }
        TextView cname = (TextView) convertView.findViewById(R.id.client_name);
        TextView cemailid = (TextView) convertView.findViewById(R.id.client_email);
        TextView caddress = (TextView) convertView.findViewById(R.id.client_address);
        TextView cage = (TextView) convertView.findViewById(R.id.client_age);
        TextView cbloodgroup =(TextView) convertView.findViewById(R.id.client_bloodgroup);

        cname.setText(cm.getName());
        cemailid.setText(cm.getEmailid());
        caddress.setText(cm.getAddress());
        cage.setText( String.valueOf(cm.getAge()));
        cbloodgroup.setText(cm.getBloodgroup());
      return convertView;
    }




}
