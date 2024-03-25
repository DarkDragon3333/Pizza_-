package com.example.pizza.Home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.example.pizza.Basket.BasketViewModel;
import com.example.pizza.Pizza.Pizza;
import com.example.pizza.Pizza.PizzaAdapter;
import com.example.pizza.R;
import com.example.pizza.databinding.FragmentHomeBinding;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ArrayList<Pizza> pizzas;
    ArrayList<String>
            id, name, recipe,
            eighteen_price, twenty_four_price, thirty_price,
            eighteen_weight, twenty_four_weight, thirty_weight;
    ArrayList<Integer> images;
    Context context;
    private FragmentHomeBinding binding;
    private NavController navController;
    BasketViewModel basketViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InitialArrayLists();

        HomeFragment_ViewModel homeFragmentViewModel =
                new ViewModelProvider(requireActivity()).get(HomeFragment_ViewModel.class);

        pizzas.addAll(homeFragmentViewModel.getData());

        basketViewModel = homeFragmentViewModel.getBasketViewModel();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle saveBundle) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        context = getContext();

        PizzaAdapter pizzaAdapter = getPizzaAdapter();//Вызываем адаптер, чтобы создать каталог пицц
        binding.listOfPizza.setAdapter(pizzaAdapter);//Устанавливаем адаптер в список

        return root;
    }

    @NonNull
    private PizzaAdapter getPizzaAdapter() {
        //Находим наше навигационную панель, которая внизу экрана
        navController = Navigation.findNavController(
                requireActivity(),
                R.id.nav_host_fragment_activity_main
        );

        Pizza_settings_ViewModel pizzaSettingsViewModel =//Создаём буффер для фрагмента Pizza_settings
                new ViewModelProvider(requireActivity()).get(Pizza_settings_ViewModel.class);

        PizzaAdapter.OnPizzaClickListener onPizzaClickListener = (Pizza, position) -> {
            pizzaSettingsViewModel.setData(Pizza, basketViewModel);//Устанавливаем данные в буффер Pizza_settings
            navController.navigate(R.id.action_navigation_home_to_pizza_settings); //Переключаем экран на фрагмент pizza_settings
        };

        return new PizzaAdapter(context, pizzas, onPizzaClickListener);
    }

    void InitialArrayLists(){
        id = new ArrayList<>();
        name = new ArrayList<>();
        recipe = new ArrayList<>();
        eighteen_price = new ArrayList<>();
        twenty_four_price = new ArrayList<>();
        thirty_price = new ArrayList<>();
        eighteen_weight = new ArrayList<>();
        twenty_four_weight = new ArrayList<>();
        thirty_weight = new ArrayList<>();
        images = new ArrayList<>();
        pizzas = new ArrayList<>();
    }

}