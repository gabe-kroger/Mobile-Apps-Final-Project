package com.ualr.budgetapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    public HashMap<String, String> loginDB = new HashMap<String, String>();
    public final String loginInfo = "users";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateDB();
    }

    public void onLoginClick(View view) {

        //TODO 1: Get user info

        EditText userET = findViewById(R.id.loginUsernameET);
        EditText passwordET = findViewById(R.id.loginPasswordET);
        String user = userET.getText().toString();
        String password = passwordET.getText().toString();

        //TODO 2: Validate credentials

        if (hasAccount(user, password)) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(MainActivity.this, "There is no such account.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onRegisterClick(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void populateDB() {
        File directory;
        if (loginInfo.isEmpty()) {
            directory = getFilesDir();
        } else {
            directory = getDir(loginInfo, MODE_PRIVATE);
        }

        try {
            FileInputStream fis = openFileInput(loginInfo);
            Scanner scanner = new Scanner(fis);

            while (scanner.hasNext()) {
                Log.d("TAG", "Populating database.");
                String user = scanner.next();
                String password = scanner.next();
                loginDB.put(user, password);
                Log.d("TAG", "User " + user + " with password " + password + " added to database.");
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean hasAccount(String user, String password) {
        if (loginDB.containsKey(user)) {
            String value = loginDB.get(user);
            if (value.compareTo(password) == 0) {
                return true;
            } else {
                Log.d("TAG", "Invalid password");
                return false;
            }
        } else {
        Log.d("TAG", "No user");
            return false;
        }
    }

    public void testButton(View view){

        Intent intent = new Intent(this, BudgetScreen.class);
        startActivity(intent);

    }



}