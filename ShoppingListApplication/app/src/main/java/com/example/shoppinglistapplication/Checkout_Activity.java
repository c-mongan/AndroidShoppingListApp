package com.example.shoppinglistapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class Checkout_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        ListView listView;

        listView = (ListView) findViewById(R.id.listView);

        //Intent to get data
        Intent intent = getIntent();

        //TextView
        TextView totalCost = findViewById(R.id.total);

        //Set Text
        totalCost.setText("Your total is : €" + intent.getStringExtra("Total"));
    }
}