package com.example.pizza.Basket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pizza.Home.Pizza_settings_ViewModel;
import com.example.pizza.databinding.BasketBinding;

public class Basket extends Fragment {

    private BasketBinding binding;
    String s;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = BasketBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Pizza_settings_ViewModel viewModel = new ViewModelProvider(requireActivity()).get(Pizza_settings_ViewModel.class);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}