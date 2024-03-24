package com.example.pizza.Basket;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
public class BasketViewModel extends ViewModel {
    private ArrayList<String>
            Name_pizza_of_basket = new ArrayList<>(),
            Size_pizza_of_basket = new ArrayList<>(),
            Price_pizza_of_basket = new ArrayList<>(),
            DLC_pizza_of_basket = new ArrayList<>();
    private ArrayList<Integer>
            Image_of_basket  = new ArrayList<>();

    public int flag = 0;
    int Count_of_bascket_pizzas = 0;

    public void setData(String name, Integer image ,String size, String price, String dlc) {
        Name_pizza_of_basket.add(name);
        Image_of_basket.add(image);
        Size_pizza_of_basket.add(size);
        Price_pizza_of_basket.add(price);
        DLC_pizza_of_basket.add(dlc);
        flag = 1;
    }

    public void setName_pizza_of_basket(ArrayList<String> name_pizza_of_basket) {
        Name_pizza_of_basket = name_pizza_of_basket;
    }

    public void setSize_pizza_of_basket(ArrayList<String> size_pizza_of_basket) {
        Size_pizza_of_basket = size_pizza_of_basket;
    }

    public void setPrice_pizza_of_basket(ArrayList<String> price_pizza_of_basket) {
        Price_pizza_of_basket = price_pizza_of_basket;
    }

    public void setDLC_pizza_of_basket(ArrayList<String> DLC_pizza_of_basket) {
        this.DLC_pizza_of_basket = DLC_pizza_of_basket;
    }

    public void setImage_of_basket(ArrayList<Integer> image_of_basket) {
        Image_of_basket = image_of_basket;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public ArrayList<Integer> getImage() {
        return Image_of_basket;
    }

    public ArrayList<String> getName() {
        return Name_pizza_of_basket;
    }

    public ArrayList<String> getSize() {
        return Size_pizza_of_basket;
    }

    public ArrayList<String> getPrice() {
        return Price_pizza_of_basket;
    }

    public ArrayList<String> getDLC() {
        return DLC_pizza_of_basket;
    }
    public int getCount_of_bascket_pizzas() {
        return Count_of_bascket_pizzas;
    }

    public void setCount_of_bascket_pizzas(int count_of_basckets_pizzas) {
        Count_of_bascket_pizzas = count_of_basckets_pizzas;
    }
    void InitialArrayLists(){
        Name_pizza_of_basket = new ArrayList<>();
        Size_pizza_of_basket = new ArrayList<>();
        Price_pizza_of_basket = new ArrayList<>();
        DLC_pizza_of_basket = new ArrayList<>();
        Image_of_basket = new ArrayList<>();
    }


}
