package com.ualr.budgetapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddBudgetActivity extends AppCompatActivity{


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_add_budget);
        }


    public void addAmount(View view){
        Toast.makeText(this, "Amount was added to budget", Toast.LENGTH_LONG).show();
    }

}
