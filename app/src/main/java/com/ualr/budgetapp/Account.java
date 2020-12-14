package com.ualr.budgetapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

public class Account implements Parcelable {
    private String totalBudget;
    private String expenses;

    public Account(String totalBudget, String expenses) {
        this.totalBudget = totalBudget;
        this.expenses = expenses;
    }

    protected Account(Parcel in) {
        totalBudget = in.readString();
    }

    public static final Creator<com.ualr.budgetapp.Account> CREATOR = new Creator<com.ualr.budgetapp.Account>() {
        @Override
        public com.ualr.budgetapp.Account createFromParcel(Parcel in) {
            return new com.ualr.budgetapp.Account(in);
        }

        @Override
        public com.ualr.budgetapp.Account[] newArray(int size) {
            return new com.ualr.budgetapp.Account[size];
        }
    };

    public String getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(String firstName) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(totalBudget);
    }

    /*public BigDecimal getBalance(){
        //return totalBudget - expenses;
    }*/

    public String getExpenses() {
        return expenses;
    }

    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }
}
