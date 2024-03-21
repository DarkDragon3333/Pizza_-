package com.example.pizza;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.pizza.databinding.FragmentHomeBinding;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ArrayList<Pizza> pizzas;
    ArrayList<String>
            id, name, recipe,
            eighteen_price, twenty_four_price, thirty_price,
            eighteen_weight, twenty_four_weight, thirty_weight;
    ArrayList<Integer> images;
    Bundle unpackingDataBundle;
    Context context;
    Pizza_settings pizzaSettings;
    Basket basket;
    private FragmentHomeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle saveBundle) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        InitialArrayLists();
        unpackingDataBundle = getArguments();
        UnpackingData();
        CreatePizzas();
        context = getContext();
        PizzaAdapter pizzaAdapter = getPizzaAdapter();
        binding.listOfPizza.setAdapter(pizzaAdapter);

        return root;
    }

    @NonNull
    private PizzaAdapter getPizzaAdapter() {
        PizzaAdapter.OnPizzaClickListener onPizzaClickListener = (Pizza, position) -> {
            pizzaSettings = new Pizza_settings();
            Bundle bundle = new Bundle();

            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            bundle.putString("1", Pizza.getName());
            pizzaSettings.setArguments(bundle);
            fragmentTransaction.replace(
                    R.id.nav_host_fragment_activity_main,
                    pizzaSettings
            ).commit();
        };

        PizzaAdapter pizzaAdapter = new PizzaAdapter(context, pizzas, onPizzaClickListener);
        return pizzaAdapter;
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

        images.add(0, R.drawable.id_1);
        images.add(1, R.drawable.id_2);
    }

    void UnpackingData(){
        if (unpackingDataBundle != null) {
            id = unpackingDataBundle.getStringArrayList("id");
            name = unpackingDataBundle.getStringArrayList("name");
            recipe = unpackingDataBundle.getStringArrayList("recipe");
            eighteen_price = unpackingDataBundle.getStringArrayList("eighteen_price");
            twenty_four_price = unpackingDataBundle.getStringArrayList("twenty_four_price");
            thirty_price = unpackingDataBundle.getStringArrayList("thirty_price");
            eighteen_weight = unpackingDataBundle.getStringArrayList("eighteen_weight");
            twenty_four_weight = unpackingDataBundle.getStringArrayList("twenty_four_weight");
            thirty_weight = unpackingDataBundle.getStringArrayList("thirty_weight");
        }
    }

    void CreatePizzas(){
        for(int i = 0; i < 2; i++){
            pizzas.add(new Pizza(
                    id.get(i),
                    name.get(i),
                    recipe.get(i),
                    images.get(i),
                    eighteen_price.get(i),
                    twenty_four_price.get(i),
                    thirty_price.get(i),
                    eighteen_weight.get(i),
                    twenty_four_weight.get(i),
                    thirty_weight.get(i))
            );
        }
    }

}