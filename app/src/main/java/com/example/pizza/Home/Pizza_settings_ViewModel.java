package com.example.pizza.Home;

import androidx.lifecycle.ViewModel;

import com.example.pizza.Pizza.Pizza;

import java.util.ArrayList;

public class Pizza_settings_ViewModel extends ViewModel {
    private ArrayList<Pizza> data = new ArrayList<>();

    public void setData(ArrayList<Pizza> newData) {
        this.data = newData;
    }

    public ArrayList<Pizza> getData() {
        return data;
    }
}
