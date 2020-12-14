package com.ualr.budgetapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RegisterActivity extends MainActivity {

    public File directory;
    public final String loginInfo = "users";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
    }

    public void onSignInInsteadClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onRegisterClick(View view) {
        FileOutputStream fos = null;

        EditText username = findViewById(R.id.usernameET);
        EditText password = findViewById(R.id.passwordET);
        EditText confirmPW = findViewById(R.id.password_ConfirmET);

        if (username.getText().toString().compareTo("") != 0) {
            if (password.getText().toString().compareTo(confirmPW.getText().toString()) == 0) {
                try {
                    fos = openFileOutput(loginInfo, MODE_APPEND);
                    fos.write(username.getText().toString().getBytes());
                    fos.write(String.valueOf("\n").getBytes());
                    fos.write(password.getText().toString().getBytes());
                    fos.write(String.valueOf("\n").getBytes());
                    fos.close();
                    Log.d("TAG", "Wrote " + username.getText().toString() + " with password " + password.getText().toString() + " to file");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Log.d("TAG", "Passwords do not match.");
            }
        } else {
            Log.d("TAG", "Username field blank.");
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
