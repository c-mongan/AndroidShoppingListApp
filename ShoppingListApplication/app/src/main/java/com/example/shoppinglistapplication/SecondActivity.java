package com.example.shoppinglistapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SecondActivity extends AppCompatActivity {


    ArrayList<Items> items = new ArrayList<>();
    ListView listView;
    private int itemPrice;
    private String itemName;


    public void addItemsAL() {

       EditText inputName = findViewById(R.id.inputName);
        EditText inputPrice = findViewById(R.id.inputPrice);


        itemName = inputName.getText().toString();
        itemPrice = Integer.parseInt(inputPrice.getText().toString());
        //Toast displays if they have not entered an item name

        if (itemName == null || itemName.length() == 0) {
            makeToast("Enter an item name");
        } else if (itemPrice == 0 ) {
            makeToast("Enter an item price");

        } else


            //If they have entered an item name then call the addItem method
            items.add( new Items(itemName, itemPrice));
        inputName.setText("");//The text is set as empty once the user presses enter
        inputPrice.setText("");
        makeToast("Added: " + itemName);
        showListView();

//Test Data
    /*   Items i1 = new Items();
        String name = "Bread";
        int price = 4;
        int quantity = 3;


            i1 = new Items( " " + name + " ", price);
            items.add(i1);


     */
        }








    public void checkOut() {
        int current_total = 0;


        for(int i = 0; i < items.size(); i++)
        {
            Items item = items.get(i);
            current_total += item.price;




           // or current_total += items.get(i).price;
        }

         String total = Integer.toString(current_total);

        Intent intent = new Intent(SecondActivity.this, Checkout_Activity.class);
        //intent.putExtra("Items",items);
        intent.putExtra("Total", total);
        startActivity(intent);



    }

    public void removeItem(){

        EditText removeItem = findViewById(R.id.removeProduct);
        itemName = removeItem.getText().toString();

        for(Iterator<Items> iterator = items.iterator(); iterator.hasNext(); ) {
            if(iterator.next().name.equalsIgnoreCase(itemName))
                iterator.remove();
            removeItem.setText("");
            makeToast("Removed: " + itemName);
            showListView();
        }



            }


    public void showListView() {

        CustomAdapter myCustomAdapter = new CustomAdapter(SecondActivity.this, items);
        listView.setAdapter(myCustomAdapter);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_second);
        setContentView(R.layout.menu_activity);


        Button addItemButton;
        Button showItemsButton;
        Button removeItemsButton;
        Button checkOutButton;


        //Intent to get data
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");

        //TextView
        TextView mResultTv = findViewById(R.id.resultTv);

        //Set Text
        mResultTv.setText("Welcome : " + name);

        addItemButton = (Button) findViewById(R.id.addItems);
        showItemsButton = (Button) findViewById(R.id.showItems);
        removeItemsButton = (Button) findViewById(R.id.removeItems);
        checkOutButton = (Button) findViewById(R.id.checkOut);

        listView = (ListView) findViewById(R.id.listView);


        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemsAL();
            }
        });

        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkOut();
            }
        });

        showItemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showListView();
            }
        });
        removeItemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem();
            }
        });



    }

    Toast toast;

    private void makeToast(String s) {
        if (toast != null) toast.cancel();
        toast = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT);
        toast.show();

    }

}
