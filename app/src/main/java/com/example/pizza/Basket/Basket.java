package com.example.pizza.Basket;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.pizza.MainActivity;
import com.example.pizza.Pizza.PizzaBasketAdapter;
import com.example.pizza.databinding.BasketBinding;
import java.util.ArrayList;

public class Basket extends Fragment {

    private BasketBinding binding;
    public Integer Image = 0;
    Context context;
    BasketViewModel viewModel;

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

        PizzaBasketAdapter pizzaBasketAdapter = new PizzaBasketAdapter(
                context,
                ((MainActivity) this.requireActivity()).getName_for_basket(),
                ((MainActivity) this.requireActivity()).getSize_for_basket(),
                ((MainActivity) this.requireActivity()).getPrice_for_basket(),
                ((MainActivity) this.requireActivity()).getDLC_for_basket(),
                ((MainActivity) this.requireActivity()).getImage_for_basket(),
                ((MainActivity) this.requireActivity()).getCounter_of_baskets_pizza());
        binding.listOfChosePizza.setAdapter(pizzaBasketAdapter);

        return root;
    }

    public void UnpackingData(){
        viewModel = new ViewModelProvider(requireActivity()).get(BasketViewModel.class);
        Name_pizza_of_basket.add(viewModel.getName());
        Size_pizza_of_basket.add(viewModel.getSize());
        Price_pizza_of_basket.add(viewModel.getPrice());
        DLC_pizza_of_basket.add(viewModel.getDLC());
        Image_of_basket.add(viewModel.getImage());

        ((MainActivity) this.requireActivity()).setName_for_basket(Name_pizza_of_basket);
        ((MainActivity) this.requireActivity()).setSize_for_basket(Size_pizza_of_basket);
        ((MainActivity) this.requireActivity()).setPrice_for_basket(Price_pizza_of_basket);
        ((MainActivity) this.requireActivity()).setDLC_for_basket(DLC_pizza_of_basket);
        ((MainActivity) this.requireActivity()).setImage_for_basket(Image_of_basket);
    }

    void InitialArrayLists(){
        Name_pizza_of_basket = new ArrayList<>();
        Size_pizza_of_basket = new ArrayList<>();
        Price_pizza_of_basket = new ArrayList<>();
        DLC_pizza_of_basket = new ArrayList<>();
        Image_of_basket = new ArrayList<>();
    }
}