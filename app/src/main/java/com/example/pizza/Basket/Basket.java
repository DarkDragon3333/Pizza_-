package com.example.pizza.Basket;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.pizza.MainActivity;
import com.example.pizza.Pizza.PizzaBasketAdapter;
import com.example.pizza.R;
import com.example.pizza.databinding.BasketBinding;
import java.util.ArrayList;

public class Basket extends Fragment {

    private BasketBinding binding;
    Context context;
    BasketViewModel viewModel;
    int count_of_basckets_pizzas = 0;
    public ArrayList<String>
            Name_pizza_of_basket, Size_pizza_of_basket, Price_pizza_of_basket, DLC_pizza_of_basket;
    public ArrayList<Integer> Image_of_basket;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitialArrayLists();
        UnpackingData();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = BasketBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        context = getContext();
        Fragment currentFragment = this;

        String name_current_Fragment = currentFragment.getClass().getName();


        if(viewModel.getFlag() == 1 ){
            PizzaBasketAdapter pizzaBasketAdapter = new PizzaBasketAdapter(
                    context,
                    Name_pizza_of_basket,
                    Size_pizza_of_basket,
                    Price_pizza_of_basket,
                    DLC_pizza_of_basket,
                    Image_of_basket,
                    count_of_basckets_pizzas,
                    name_current_Fragment,
                    ((MainActivity) this.requireActivity()).getNum_in_layout_of_basket(),
                    viewModel
            );
            binding.listOfChosePizza.setAdapter(pizzaBasketAdapter);

        }

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public void UnpackingData(){
        viewModel = new ViewModelProvider(requireActivity()).get(BasketViewModel.class);
        if(viewModel.getFlag() == 1 ){
            Name_pizza_of_basket.addAll(viewModel.getName());
            Size_pizza_of_basket.addAll(viewModel.getSize());
            Price_pizza_of_basket.addAll(viewModel.getPrice());
            DLC_pizza_of_basket.addAll(viewModel.getDLC());
            Image_of_basket.addAll(viewModel.getImage());
            count_of_basckets_pizzas = viewModel.getCount_of_bascket_pizzas();
        }

    }
    void InitialArrayLists(){
        Name_pizza_of_basket = new ArrayList<>();
        Size_pizza_of_basket = new ArrayList<>();
        Price_pizza_of_basket = new ArrayList<>();
        DLC_pizza_of_basket = new ArrayList<>();
        Image_of_basket = new ArrayList<>();
    }
}