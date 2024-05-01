package com.example.pizza.About;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.pizza.R;
import com.example.pizza.databinding.FragmentAboutAuthorBinding;
public class About_author extends Fragment {
    FragmentAboutAuthorBinding fragmentAboutAuthorBinding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentAboutAuthorBinding = FragmentAboutAuthorBinding.inflate(inflater, container, false);

        View root = fragmentAboutAuthorBinding.getRoot();
        NavController navController = Navigation.findNavController(
                requireActivity(),
                R.id.nav_host_fragment_activity_main
        );

        fragmentAboutAuthorBinding.button4.setOnClickListener(v -> {
            navController.navigate(R.id.action_about_author_to_navigation_notifications);
        });

        return root;
    }
}