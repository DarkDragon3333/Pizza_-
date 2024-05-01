package com.example.pizza.About;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.pizza.R;
import com.example.pizza.databinding.FragmentNotificationsBinding;
public class About_program extends Fragment {
    private FragmentNotificationsBinding binding;
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        NavController navController = Navigation.findNavController(
                requireActivity(),
                R.id.nav_host_fragment_activity_main
        );
        binding.button2.setOnClickListener(v -> {
            navController.navigate(R.id.action_navigation_notifications_to_about_author);
        });
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}