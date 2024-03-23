package com.example.pizza.Pizza;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Pizza implements Serializable {

    private String
            id, Name, Recipe,
            eighteen_price,  twenty_four_price,  thirty_price,
            eighteen_weight,  twenty_four_weight,  thirty_weight,
            DLC;
    private int Picture;

    public Pizza() {}

    public Pizza(
            String id, String name, String recipe,
                 int picture,
                 String eighteen_price, String twenty_four_price, String thirty_price,
                 String eighteen_weight, String twenty_four_weight, String thirty_weight) {
        this.id = id;
        Name = name;
        Recipe = recipe;
        this.eighteen_price = eighteen_price;
        this.twenty_four_price = twenty_four_price;
        this.thirty_price = thirty_price;
        this.eighteen_weight = eighteen_weight;
        this.twenty_four_weight = twenty_four_weight;
        this.thirty_weight = thirty_weight;
        Picture = picture;
    }

    public String getDLC() {
        return DLC;
    }

    public void setDLC(String DLC) {
        this.DLC = DLC;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRecipe() {
        return Recipe;
    }

    public void setRecipe(String recipe) {
        Recipe = recipe;
    }

    public String getEighteen_price() {
        return eighteen_price;
    }

    public void setEighteen_price(String eighteen_price) {
        this.eighteen_price = eighteen_price;
    }

    public String getTwenty_four_price() {
        return twenty_four_price;
    }

    public void setTwenty_four_price(String twenty_four_price) {
        this.twenty_four_price = twenty_four_price;
    }

    public String getThirty_price() {
        return thirty_price;
    }

    public void setThirty_price(String thirty_price) {
        this.thirty_price = thirty_price;
    }

    public String getEighteen_weight() {
        return eighteen_weight;
    }

    public void setEighteen_weight(String eighteen_weight) {
        this.eighteen_weight = eighteen_weight;
    }

    public String getTwenty_four_weight() {
        return twenty_four_weight;
    }

    public void setTwenty_four_weight(String twenty_four_weight) {
        this.twenty_four_weight = twenty_four_weight;
    }

    public String getThirty_weight() {
        return thirty_weight;
    }

    public void setThirty_weight(String thirty_weight) {
        this.thirty_weight = thirty_weight;
    }

    public int getPicture() {
        return Picture;
    }

    public void setPicture(int picture) {
        Picture = picture;
    }

}