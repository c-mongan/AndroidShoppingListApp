package com.example.shoppinglistapplication;


/*
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<String> {

    ArrayList<String> list;
    Context context;

    public ListViewAdapter(Context context, ArrayList<String>items){
        super(context,R.layout.list_row,items);
        this.context = context;
        list = items;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){ //convert View is the view for each row we will modify

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.list_row, null);

            //Get item position & display it
            TextView number = convertView.findViewById(R.id.number);
            number.setText(position +1+ ".");

            //Displays Item name
            TextView name = convertView.findViewById(R.id.name);
            number.setText(list.get(position));

            //Create image view objects

            ImageView duplicate = convertView.findViewById(R.id.copy);
            ImageView remove = convertView.findViewById(R.id.remove);
            duplicate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SecondActivity.addItem(list.get(position));

                }
            });


        remove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SecondActivity.removeItem(position);

                    }
        });
    }



        return convertView; //Made changes to it
}}

*/