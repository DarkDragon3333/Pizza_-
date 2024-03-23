package com.example.pizza.Home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.pizza.Basket.BasketViewModel;
import com.example.pizza.MainActivity;
import com.example.pizza.Pizza.Pizza;
import com.example.pizza.R;
import com.example.pizza.databinding.FragmentPizzaSettingsBinding;

import java.util.ArrayList;

public class Pizza_settings extends Fragment{

    private FragmentPizzaSettingsBinding binding;

    Pizza pizza;
    Pizza_settings_ViewModel pizzaSettingsViewModel;
    Context context;
    private NavController navController;
    String tempPrice = "";
    String tempSize = "";
    String tempDLC = "e";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pizza = new Pizza();
        context = getContext();
    }
//TODO Сделать редактироваие pizza_setings, страницу регистрации и страницу об авторе, дозаполнить БД
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle saveBundle) {
        binding = FragmentPizzaSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        root.findViewById(R.id.small_pizza).setOnClickListener(this::smallPizza);
        root.findViewById(R.id.medium_pizza).setOnClickListener(this::mediumPizza);
        root.findViewById(R.id.big_pizza).setOnClickListener(this::bigPizza);

        pizzaSettingsViewModel = new ViewModelProvider(requireActivity()).get(Pizza_settings_ViewModel.class);
        UnpackingData();

        binding.AddToOrder.setOnClickListener(v -> {
            navController = Navigation.findNavController(
                    requireActivity(),
                    R.id.nav_host_fragment_activity_main
            );

            ((MainActivity) this.requireActivity()).setCounter_of_baskets_pizza(
                    ((MainActivity) this.requireActivity()).getCounter_of_baskets_pizza() + 1
            );
            SendDataToBasket();
            navController.navigate(R.id.action_pizza_settings_to_navigation_home);
        });

        return root;
    }

    void UnpackingData(){
        pizza.setId(pizzaSettingsViewModel.getData().getId());
        pizza.setName(pizzaSettingsViewModel.getData().getName());
        pizza.setPicture(pizzaSettingsViewModel.getData().getPicture());
        pizza.setRecipe(pizzaSettingsViewModel.getData().getRecipe());
        pizza.setEighteen_weight(pizzaSettingsViewModel.getData().getEighteen_weight());
        pizza.setTwenty_four_weight(pizzaSettingsViewModel.getData().getTwenty_four_weight());
        pizza.setThirty_weight(pizzaSettingsViewModel.getData().getThirty_weight());
        pizza.setEighteen_price(pizzaSettingsViewModel.getData().getEighteen_price());
        pizza.setTwenty_four_price(pizzaSettingsViewModel.getData().getTwenty_four_price());
        pizza.setThirty_price(pizzaSettingsViewModel.getData().getThirty_price());

        binding.pizzaPhoto.setImageResource(pizza.getPicture());
        binding.nameOfPizzaOfSettings.setText(pizza.getName());
        binding.sizeAndWeight.setText("24 см " + pizza.getTwenty_four_weight());
        binding.recipe.setText(pizza.getRecipe());
        binding.AddToOrder.setText("Заказать за " + pizza.getTwenty_four_price());
    }

    public void smallPizza(View view){
        binding.sizeAndWeight.setText("18 см " + pizza.getEighteen_weight());
        tempSize = "18";
        binding.AddToOrder.setText("Заказать за " + pizza.getEighteen_price());
        tempPrice = pizza.getEighteen_price();
    }
    public void mediumPizza(View view){
        binding.sizeAndWeight.setText("23 см " + pizza.getTwenty_four_weight());
        tempSize = "24";
        binding.AddToOrder.setText("Заказать за " + pizza.getTwenty_four_price());
        tempPrice = pizza.getTwenty_four_price();
    }
    public void bigPizza(View view){
        binding.sizeAndWeight.setText("30 см " + pizza.getThirty_weight());
        tempSize = "30";
        binding.AddToOrder.setText("Заказать за " + pizza.getThirty_price());
        tempPrice = pizza.getThirty_price();
    }

    void SendDataToBasket(){
        BasketViewModel basketViewModel =
                new ViewModelProvider(requireActivity()).get(BasketViewModel.class);

        basketViewModel.setData(
                pizza.getName(),
                pizza.getPicture(),
                String.valueOf(tempSize),
                String.valueOf(tempPrice),
                String.valueOf(tempDLC)
        );
    }
}