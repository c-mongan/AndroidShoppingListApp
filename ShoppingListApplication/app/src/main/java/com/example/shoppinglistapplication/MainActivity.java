package com.example.shoppinglistapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Actionbar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Register");


        //Edit Text
        EditText editTextUserName = findViewById(R.id.editTextUserName);
        EditText editTextPassword = findViewById(R.id.editTextPassword);

        //Button
        Button mSaveBtn = findViewById(R.id.btnRegister);

        //Button click listener
        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {


                //Get data from edit text
                String name = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();


                if (name.length() >= 6 && password.length() >= 6 && !password.contains(" ")) {
                    //Activity intent
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("NAME", name);
                    startActivity(intent);


                } else if (name.length() < 6 && password.length() >= 6 && !password.contains(" ")) {
                    Toast.makeText(MainActivity.this, "Username must be more than 6 characters", Toast.LENGTH_SHORT).show();

                } else if (password.length() < 6 && name.length() >= 6 && !password.contains(" ")) {
                    Toast.makeText(MainActivity.this, "Password must be more than 6 characters", Toast.LENGTH_SHORT).show();

                } else if (name.length() >= 6 && password.length() >= 6 && password.contains(" ")) {
                    Toast.makeText(MainActivity.this, "Password cannot contain spaces", Toast.LENGTH_SHORT).show();

                } else if (name.length() < 6 && password.length() < 6 && !password.contains(" ")) {
                    Toast.makeText(MainActivity.this, "Name & Password must be more than 6 characters", Toast.LENGTH_SHORT).show();


                } else if (name.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please ensure no fields are left blank", Toast.LENGTH_SHORT).show();


                }


                }
            });}}