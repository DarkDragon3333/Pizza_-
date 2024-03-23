package com.example.pizza.Pizza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizza.R;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder>{
    private LayoutInflater inflater; //XML для данных
    Context context;
    ArrayList<Pizza> pizzas;
    private final OnPizzaClickListener onClickListener;

    public interface OnPizzaClickListener{
        void onPizzaClick(Pizza Pizza, int position);
    }

    //Конструктор адаптера
    public  PizzaAdapter(Context context, ArrayList<Pizza> pizzas, OnPizzaClickListener onClickListener1) {
        this.context = context;
        this.pizzas = pizzas;
        this.onClickListener = onClickListener1;
    }

    @NonNull
    @Override
    public PizzaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.list_of_pizzas, parent, false);
        return new ViewHolder(view);
    }

    @Override  //Получаем данные
    public void onBindViewHolder(PizzaAdapter.ViewHolder holder, int position) {
        Pizza pizza = pizzas.get(position);
        holder.flagView.setImageResource(pizza.getPicture());
        holder.name.setText(pizza.getName());
        holder.recipe.setText(pizza.getRecipe());
        holder.twenty_four.setText(pizza.getTwenty_four_price());

        holder.itemView.setOnClickListener(v -> {
            onClickListener.onPizzaClick(pizza, position);
        });
    }

    @Override
    public int getItemCount() {
        return pizzas.size();
    }

    //Получаем view, в которые будет вставлять данные
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView flagView;
        TextView name, recipe, twenty_four;
        ViewHolder(View view){
            super(view);
            flagView = view.findViewById(R.id.pizza_photo);
            name = view.findViewById(R.id.name_of_pizza);
            recipe = view.findViewById(R.id.tvPizzaRecipe);
            twenty_four = view.findViewById((R.id.tvPizzaPrice)); //Цена, фото, имя, размер, ДЛС
        }
    }
}
