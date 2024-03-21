package com.example.pizza;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pizza.Basket.Basket;
import com.example.pizza.Home.HomeFragment;
import com.example.pizza.Home.Pizza_settings_ViewModel;
import com.example.pizza.databinding.ActivityMainBinding;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    ArrayList<String> id, name, recipe,
            eighteen_price, twenty_four_price, thirty_price,
            eighteen_weight, twenty_four_weight, thirty_weight;
    DataBasePizzaManager dataBasePizzaManager;
    private ActivityMainBinding binding;
    private Pizza_settings_ViewModel pizzaSettingsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        pizzaSettingsViewModel = new ViewModelProvider(this).get(Pizza_settings_ViewModel.class);

        dataBasePizzaManager = new DataBasePizzaManager(MainActivity.this);

        InitialArrayLists();
        InsertDataToDB();
        DataToArrayLists();

    }
    @Override
    protected void onStart() {
        super.onStart();
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

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
    }
    void DataToArrayLists(){
        Cursor cursor = dataBasePizzaManager.ReadData();
        if (cursor.getCount() == 0){}
        else { //Берём строковые данные из БД
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                recipe.add(cursor.getString(2));
                eighteen_price.add(cursor.getString(3));
                twenty_four_price.add(cursor.getString(4));
                thirty_price.add(cursor.getString(5));
                eighteen_weight.add(cursor.getString(6));
                twenty_four_weight.add(cursor.getString(7));
                thirty_weight.add(cursor.getString(8));
            }
        }

    }
    void InsertDataToDB(){
        dataBasePizzaManager.InsertData(
                0, "BBQ", "сыр",
                "200", "299", "345",
                "400", "600", "900"
        );
        dataBasePizzaManager.InsertData(
                1, "Margarita", "колбаса",
                "300", "400", "500",
                "1", "2", "3"
        );
    }

}