package com.example.pizza;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.example.pizza.databinding.ActivityMainBinding;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DataForBasket{
    ArrayList<String> id, name, recipe,
            eighteen_price, twenty_four_price, thirty_price,
            eighteen_weight, twenty_four_weight, thirty_weight;
    DataBasePizzaManager dataBasePizzaManager;
    HomeFragment homeFragment;
    Bundle goToBascketBundle;
    Bundle data;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dataBasePizzaManager = new DataBasePizzaManager(MainActivity.this);

        goToBascketBundle = new Bundle();

        InitialArrayLists();
        InsertDataToDB();
        DataToArrayLists();

        homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        PackageData();

        homeFragment.setArguments(data);
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, homeFragment).commit();
    }
    public void ToFragment1(View view){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(
                R.id.nav_host_fragment_activity_main,
                homeFragment
        ).commit();
    }
    public void ToFragment2(View view){
        Basket basket = new Basket();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(
                R.id.nav_host_fragment_activity_main,
                basket
        ).commit();
    }
    public void ToFragment3(View view){
        About_program aboutProgram = new About_program();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(
                R.id.nav_host_fragment_activity_main,
                aboutProgram
        ).commit();
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
    void PackageData(){
        data = new Bundle();
        data.putStringArrayList("id", id);
        data.putStringArrayList("name", name);
        data.putStringArrayList("recipe", recipe);
        data.putStringArrayList("eighteen_price", eighteen_price);
        data.putStringArrayList("twenty_four_price", twenty_four_price);
        data.putStringArrayList("thirty_price", thirty_price);
        data.putStringArrayList("eighteen_weight", eighteen_weight);
        data.putStringArrayList("twenty_four_weight", twenty_four_weight);
        data.putStringArrayList("thirty_weight", thirty_weight);
    }

    @Override
    public void dataForBasket
            (String id, String name, String recipe,
             String eighteen_price, String twenty_four_price, String thirty_price,
             String eighteen_weight, String twenty_four_weight, String thirty_weight) {

    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add(id);
    arrayList.add(name);
    arrayList.add(recipe);
    arrayList.add(eighteen_price);
    arrayList.add(twenty_four_price);
    arrayList.add(thirty_price);
    arrayList.add(eighteen_weight);
    arrayList.add(twenty_four_weight);
    arrayList.add(thirty_weight);

    data.putStringArrayList("DataForBasket", arrayList);

    Basket basket = new Basket();
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(
            R.id.nav_host_fragment_activity_main,
            basket
    ).commit();

    }


}