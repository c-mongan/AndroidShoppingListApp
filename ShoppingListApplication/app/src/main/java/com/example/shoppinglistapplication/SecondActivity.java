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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

   static ListView listView;
   static ArrayList<String> items;
    static ListViewAdapter adapter; //Holds items to be displayed in ListView

    EditText input;
    ImageView enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        //Intent to get data
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");

        //TextView
        TextView mResultTv = findViewById(R.id.resultTv);

        //Set Text
        mResultTv.setText("Welcome : "+name);

        listView = findViewById(R.id.listview);
        input = findViewById(R.id.input);
        enter = findViewById(R.id.enter);



        items = new ArrayList<>();
        items.add("Apple");
        items.add("Chicken roll");
        items.add("Pizza");


        //Setting our Layout for our adapter and declaring what we want displayed
        adapter = new ListViewAdapter(getApplicationContext(), items);
        listView.setAdapter(adapter); //Setting the adapter for our ListView so that it can be displayed

//Method for when the user clicks the tick icon
enter.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //Get text from the add item text box
        String text = input.getText().toString();

        //Toast displays if they have not entered an item name
        if(text == null || text.length() == 0){
            makeToast("Enter an item");
        }else{
            //If they have entered an item name then call the addItem method
            addItem(text); //This method takes in text and adds it to our listview
            input.setText("");//The text is set as empty once the user presses enter
            makeToast("Added: " +text);
        }

    }
});




//ADD ITEM
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = items.get(position); //Position of item in ArrayList
                makeToast(name); //Name of item in Arraylist pop up
            }
        });

        //REMOVE ITEM
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                makeToast("Removed: " + items.get(position));
                removeItem(position);

                return false;
            }
        });




    }

    //METHODS

    public static void addItem(String item){
        items.add(item);
        listView.setAdapter(adapter);
        //alternatively adapter.notifyDataSetChanged();
        //or you could use listView.setAdapter(adapter)
    }

    public static void removeItem(int remove){
        items.remove(remove);
        adapter.notifyDataSetChanged();


    }


    Toast toast;

    private void makeToast(String s) {
        if(toast !=null) toast.cancel();
        toast = Toast.makeText(getApplicationContext(), s , Toast.LENGTH_SHORT);
        toast.show();
    }
}