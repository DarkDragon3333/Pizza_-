package com.example.pizza.Basket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pizza.Home.Pizza_settings_ViewModel;
import com.example.pizza.Pizza.Pizza;
import com.example.pizza.databinding.BasketBinding;

import java.util.ArrayList;

public class Basket extends Fragment {

    private BasketBinding binding;
    ArrayList<Pizza> pizzas;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = BasketBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Pizza_settings_ViewModel viewModel = new ViewModelProvider(requireActivity()).get(Pizza_settings_ViewModel.class);
        pizzas = new ArrayList<>();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}