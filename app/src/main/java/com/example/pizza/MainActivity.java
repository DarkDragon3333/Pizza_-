package com.example.pizza;

import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pizza.Basket.BasketViewModel;
import com.example.pizza.Home.HomeFragment_ViewModel;
import com.example.pizza.Pizza.Pizza;
import com.example.pizza.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    ArrayList<String> id, name, recipe,
            eighteen_price, twenty_four_price, thirty_price,
            eighteen_weight, twenty_four_weight, thirty_weight;
    ArrayList<String>
            Name_for_basket, Size_for_basket, Price_for_basket,
            DLC_for_basket, num_in_layout_of_basket;
    ArrayList<Integer>
            Image_for_basket, resourceId, flag_of_RecyclerItem;
    DataBasePizzaManager dataBasePizzaManager;
    private ActivityMainBinding binding;
    ArrayList<Pizza> pizzas;
    ArrayList<Drawable> photosList ;
    String[] photoNames;
    private int
            counter_of_baskets_pizza = 0, counter_of_pizza_button_click = 0;

    BasketViewModel basketViewModel;
    public FloatingActionButton floatingActionButton;
    public TextView finalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HomeFragment_ViewModel homeFragmentViewModel =
                new ViewModelProvider(this).get(HomeFragment_ViewModel.class); //Создаём буффер для фрагмента Home_Fragment

        dataBasePizzaManager = new DataBasePizzaManager(MainActivity.this); //Создаём нашу БД

        InitialArrayLists();  //Указываем место, где будут хранится наши массивы
        InsertDataToDB();  //Вставляем данные в базу данных
        DataToArrayLists(); //Достаём данные из БД
        PackingData(); //Покуем данные для отправки


        basketViewModel = new ViewModelProvider(this).get(BasketViewModel.class);//Создаём буффер для фрагмента Basket_Fragment
        homeFragmentViewModel.setData(pizzas, basketViewModel); //Отправляем в буфер Home_Fragment наши данные и экземпляр буффера Basket_Fragment

        binding = ActivityMainBinding.inflate(getLayoutInflater());//Находим всю разметку
        setContentView(binding.getRoot());


        floatingActionButton = findViewById(R.id.floatingActionButton);  //Создаём кнопку заказа
        floatingActionButton.setEnabled(false);//Неактивна
        floatingActionButton.setVisibility(View.INVISIBLE);//Невидима

        finalPrice = findViewById(R.id.finalPrice);//Итоговая цена
        finalPrice.setVisibility(View.INVISIBLE);//Невидима
    }
    @Override
    protected void onStart() {
        super.onStart();
        AppBarConfiguration appBarConfiguration =//Находим элементы для нашего меню. Их всего 3
                new AppBarConfiguration.Builder(
                        R.id.navigation_home,
                        R.id.navigation_dashboard,
                        R.id.navigation_notifications
                ).build();
        NavController navController = Navigation.findNavController(
                this,
                R.id.nav_host_fragment_activity_main
        );
        NavigationUI.setupActionBarWithNavController(
                this,
                navController,
                appBarConfiguration
        );
        NavigationUI.setupWithNavController(
                binding.navView,
                navController
        );
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
        pizzas = new ArrayList<>();
        resourceId = new ArrayList<>();
        photosList = new ArrayList<>();
        Name_for_basket = new ArrayList<>();
        Size_for_basket  = new ArrayList<>();
        Price_for_basket  = new ArrayList<>();
        DLC_for_basket = new ArrayList<>();
        Image_for_basket = new ArrayList<>();
        num_in_layout_of_basket = new ArrayList<>();
        flag_of_RecyclerItem = new ArrayList<>();

        for (int i = 0; i <41; i++){
            flag_of_RecyclerItem.add(0);
        }
        for (int i = 0; i <41; i++){
            num_in_layout_of_basket.add("0");
        }
    }
    void InsertDataToDB(){
        dataBasePizzaManager.InsertData(
                0, "BBQ", "Сыр, кетчуп, колбаса, зелень, грибы",
                "500", "699", "1345",
                "500", "700", "900"
        );
        dataBasePizzaManager.InsertData(
                1, "Маргарита", "Сыр :Пармезан: колбаса :Солями:, зелень",
                "500", "600", "900",
                "400 гр", "600 гр", "850 гр"
        );
        dataBasePizzaManager.InsertData(
                2, "Пиперонни", "Сыр :Пармезан: колбаса :Солями:, солённые огурцы",
                "300", "500", "700",
                "300 гр", "500 гр", "750 гр"
        );
    }
    void DataToArrayLists(){
        Cursor cursor = dataBasePizzaManager.ReadData();//Берём строковые данные из БД с помощью объекта Cursor.
            while (cursor.moveToNext()){//Пока есть куда двигаться по БД
                id.add(cursor.getString(0));//
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
    void PackingData(){
        photoNames = getResources().getStringArray(R.array.drawable_photos);
        for (String photoName : photoNames) {
            resourceId.add(
                    getResources().getIdentifier(//Получаем по имени изображение изображение. Делали так в 4 практической работе
                        photoName,
                        "drawable",
                        getPackageName()
                    )
            );
        }
        for(int i = 0; i <= 2; i++){//В приложении всего 3 фотки. Поэтому 3 пиццы
            Pizza pizza = getPizza(i);
            pizzas.add(pizza);
        }
    }
    @NonNull
    private Pizza getPizza(int i) {
        Pizza pizza = new Pizza();//создаём объект пицца и дальше заполняем его полученными данными
        pizza.setId(id.get(i));
        pizza.setPicture(resourceId.get(i));
        pizza.setName(name.get(i));
        pizza.setRecipe(recipe.get(i));
        pizza.setEighteen_price(eighteen_price.get(i));
        pizza.setTwenty_four_price(twenty_four_price.get(i));
        pizza.setThirty_price(thirty_price.get(i));
        pizza.setEighteen_weight(eighteen_weight.get(i));
        pizza.setTwenty_four_weight(twenty_four_weight.get(i));
        pizza.setThirty_weight(thirty_weight.get(i));
        return pizza;//Получаем пиццу
    }
    public ArrayList<String> getNum_in_layout_of_basket() {
        return num_in_layout_of_basket;
    }

    public void setNum_in_layout_of_basket(int num, int position) {
        this.num_in_layout_of_basket.set(position, String.valueOf(num));
    }

    public void removeNum_in_layout_of_basket(int position){
        this.num_in_layout_of_basket.remove(position);
    }

    public void setFlag_of_RecyclerItem(int flag_of_RecyclerItem, int position) {
        this.flag_of_RecyclerItem.add(position, flag_of_RecyclerItem);
    }

    public boolean onSupportNavigateUp() {
        onBackPressed(); // Здесь вызывается метод onBackPressed(), чтобы обработать нажатие кнопки назад
        return true;
    }

}