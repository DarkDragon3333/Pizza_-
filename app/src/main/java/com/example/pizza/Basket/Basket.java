package com.example.pizza.Basket;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.pizza.MainActivity;
import com.example.pizza.Pizza.PizzaBasketAdapter;
import com.example.pizza.R;
import com.example.pizza.databinding.BasketBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class Basket extends Fragment {
    private BasketBinding binding;
    Context context;
    BasketViewModel viewModel;
    int count_of_basckets_pizzas = 0;
    NavController navController;
    FloatingActionButton floatingActionButton;
    public ArrayList<String>
            Name_pizza_of_basket, Size_pizza_of_basket, Price_pizza_of_basket, DLC_pizza_of_basket;
    public ArrayList<Integer> Image_of_basket;

    public TextView Final_price;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitialArrayLists();
        UnpackingData();//ПОЛУЧАЕМ ДАННЫЕ ИЗ БУФФЕРА КОРЗИНЫ
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = BasketBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        context = getContext();//Где будет происходить действия
        Fragment currentFragment = this;//Экземпляр фрагменты корзины

        navController = Navigation.findNavController(
                requireActivity(),
                R.id.nav_host_fragment_activity_main
        );

        String name_current_Fragment = currentFragment.getClass().getName();//Получаем имя фрагмента

        if(viewModel.getFlag() == 1 ){//Если вызвали приложение и сразу перешли в корзину, то ничего не происходит
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


        floatingActionButton = ((MainActivity) this.requireActivity()).floatingActionButton;
        Final_price = ((MainActivity) this.requireActivity()).finalPrice;

        navController.addOnDestinationChangedListener((navController, navDestination, bundle) -> {
            if(navDestination.getId() == R.id.navigation_dashboard){
                floatingActionButton.setEnabled(true);
                floatingActionButton.setVisibility(View.VISIBLE);
                Final_price.setVisibility(View.VISIBLE);
            }
        });

        floatingActionButton.setOnClickListener(v -> {
            if(viewModel.getFlag() == 0 ){
                Toast toast = Toast.makeText(context, "Выберете пиццу", Toast.LENGTH_SHORT);
                toast.show();
            }
            else {
                Toast toast = Toast.makeText(context, "Заказ оформлен! Ожидайте.", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        navController.addOnDestinationChangedListener((navController, navDestination, bundle) -> {
            if(navDestination.getId() == R.id.navigation_home || navDestination.getId() == R.id.navigation_notifications ||
                    navDestination.getId() == R.id.about_author || navDestination.getId() == R.id.pizza_settings){
                floatingActionButton.setEnabled(false);
                floatingActionButton.setVisibility(View.INVISIBLE);
                Final_price.setVisibility(View.INVISIBLE);
            }
        });

        int Pr = 0;
        for (String i : viewModel.getPrice_pizza_of_basket()){
            Pr += Integer.parseInt(i);
        }

        Final_price.setText("Итоговая цена: " + Pr);
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
            count_of_basckets_pizzas = viewModel.getCount_of_basket_pizzas();
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