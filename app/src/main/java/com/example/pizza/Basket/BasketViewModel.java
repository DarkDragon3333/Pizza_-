package com.example.pizza.Basket;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pizza.Pizza.Pizza;

import java.util.ArrayList;

public class BasketViewModel extends ViewModel {
    private ArrayList<Pizza> data = new ArrayList<>();

    public void setData(ArrayList<Pizza> newData) {
        this.data = newData;
    }

    public ArrayList<Pizza> getData() {
        return data;
    }
}
