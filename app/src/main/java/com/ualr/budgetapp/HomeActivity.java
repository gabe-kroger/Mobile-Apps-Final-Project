package com.ualr.budgetapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);
    }
    public void onToBudgetScreenButtonClicked(View view) {
        Intent intent = new Intent(this, BudgetScreen.class);
        startActivity(intent);
    }
    public void onToCalendarButtonClicked(View view) {
        Intent intent = new Intent(this, CalenderActivity.class);
        startActivity(intent);
    }
}
