package com.example.pizza.Basket;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pizza.Pizza.Pizza;

import java.util.ArrayList;

public class BasketViewModel extends ViewModel {

    private Integer Image = 0;
    private String Name = "";
    private String Size = "";
    private String Price = "";
    private String DLC = "";

    public void setData(String name, Integer image ,String Size, String Price, String DLC) {
        this.DLC = DLC;
        this.Image = image;
        this.Size = Size;
        this.Name = name;
        this.Price = Price;
    }

    public Integer getImage() {
        return Image;
    }

    public String getName() {
        return Name;
    }

    public String getSize() {
        return Size;
    }

    public String getPrice() {
        return Price;
    }

    public String getDLC() {
        return DLC;
    }

}
