package com.example.pizza.Home;

import androidx.lifecycle.ViewModel;

import com.example.pizza.Basket.BasketViewModel;
import com.example.pizza.Pizza.Pizza;

import java.util.ArrayList;

public class HomeFragment_ViewModel extends ViewModel {
    private ArrayList<Pizza> data = new ArrayList<>();
    BasketViewModel basketViewModel;

    public void setData(ArrayList<Pizza> newData, BasketViewModel basketViewModel) {
        this.data = newData;
        this.basketViewModel = basketViewModel;
    }

    public ArrayList<Pizza> getData() {
        return data;
    }

    public BasketViewModel getBasketViewModel() {
        return basketViewModel;
    }
}
