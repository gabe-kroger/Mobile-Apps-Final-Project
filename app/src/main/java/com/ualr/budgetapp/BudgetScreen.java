package com.ualr.budgetapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class BudgetScreen extends MainActivity {

    public static final String EXTRA_ACCOUNT = "AccountData";
    EditText etTotalBudget;
    TextView tvBalance;
    String totalBudget;
    String expenses;
    ListView listView;
    List list = new ArrayList();
    ArrayAdapter adapter;
    MenuItem item;
    private ImageButton btnGoCalender;
    BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_budget);
        btnGoCalender = findViewById(R.id.calenderButton);
        bottom_navigation = findViewById(R.id.bottom_navigation);

        btnGoCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BudgetScreen.this, CalenderActivity.class);
                startActivity(intent);
            }
        });



        listView = findViewById(R.id.expensesList);

        list.add("Groceries");
        list.add("Gas");
        list.add("Electric Bill");
        list.add("Car Note");
        list.add("Water Bill");
        list.add("School Supplies");
        list.add("Internet Bill");
        list.add("Car Insurance");
        list.add("Car Maintenance");
        list.add("Phone Bill");
        list.add("TV Repair Cost");
        list.add("Car Tires");
        list.add("Kid's Field Trip");
        list.add("Items for Halloween Party");
        list.add("Kid's clothes for next semester");
        list.add("Sundries");
        list.add("Self-Indulging");
        list.add("Favor for friend");

        Intent incomingDate = getIntent();
        String date = incomingDate.getStringExtra("date");
        //theDate.setText(date);

        adapter = new ArrayAdapter(BudgetScreen.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }






    public void plusButton(View view){

        Intent intent = new Intent(this, AddBudgetActivity.class);
        startActivity(intent);
    }

    public void budgetEntered(View view){
        etTotalBudget = (EditText) findViewById(R.id.etTotalBudget);
        tvBalance = (TextView) findViewById(R.id.tvBalance);
        String amount = etTotalBudget.getText().toString();
        Toast.makeText(this, "this is: " + amount, Toast.LENGTH_SHORT).show();
        tvBalance.setText("$ " + amount);

    }

/*    public void onTotalButtonClick(View view) {
        etTotalBudget = findViewById(R.id.etTotalBudget);
        //etExpenses = Expenses retrieved and added up from list.

        totalBudget = etTotalBudget.getText().toString();
        Intent intent = new Intent(this, Account.class);
        Account a = new Account(totalBudget, expenses);
        intent.putExtra(EXTRA_ACCOUNT, a);
        startActivity(intent);
    }*/
}
