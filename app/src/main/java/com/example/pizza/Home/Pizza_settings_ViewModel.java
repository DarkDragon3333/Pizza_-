package com.example.pizza.Home;

import androidx.lifecycle.ViewModel;

import com.example.pizza.Basket.BasketViewModel;
import com.example.pizza.Pizza.Pizza;

import java.util.ArrayList;

public class Pizza_settings_ViewModel extends ViewModel {
    private Pizza data = new Pizza();
    private BasketViewModel basketViewModel;

    public void setData(Pizza newData, BasketViewModel basketViewModel) {
        this.data = newData;
        this.basketViewModel = basketViewModel;
    }

    public Pizza getData() {
        return data;
    }
    public BasketViewModel getBasketViewModel() {
        return basketViewModel;
    }
}
