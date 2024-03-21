package com.example.pizza.Home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pizza.databinding.FragmentPizzaSettingsBinding;

public class Pizza_settings extends Fragment{

    private FragmentPizzaSettingsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle saveBundle) {
        binding = FragmentPizzaSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.AddToOrder.setOnClickListener(v -> {
            Pizza_settings_ViewModel viewModel = new ViewModelProvider(requireActivity()).get(Pizza_settings_ViewModel.class);
            viewModel.setData("Новые данные");
        });

        return root;
    }

    void UnpackingData(){

    }

}