package com.example.pizza.Home;

import androidx.lifecycle.ViewModel;

import com.example.pizza.Pizza.Pizza;

import java.util.ArrayList;

public class Pizza_settings_ViewModel extends ViewModel {
    private Pizza data = new Pizza();

    public void setData(Pizza newData) {
        this.data = newData;
    }

    public Pizza getData() {
        return data;
    }
}
