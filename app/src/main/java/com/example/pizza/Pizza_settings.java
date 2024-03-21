package com.example.pizza;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentResultOwner;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pizza.databinding.FragmentHomeBinding;
import com.example.pizza.databinding.FragmentPizzaSettingsBinding;

public class Pizza_settings extends Fragment{

    String string;
    Bundle unpackingDataBundle;
    private FragmentPizzaSettingsBinding binding;
    Activity activity;
    Bundle bundle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle saveBundle) {
        binding = FragmentPizzaSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.AddToOrder.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();


        });

        return root;
    }

    void UnpackingData(){
        bundle = new Bundle();
        unpackingDataBundle = getArguments();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

}