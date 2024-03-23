package com.example.pizza.Pizza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pizza.R;

import java.util.ArrayList;

public class PizzaBasketAdapter extends RecyclerView.Adapter<PizzaBasketAdapter.ViewHolder>{

    private LayoutInflater inflater; //XML для данных
    Context context;
    public ArrayList<String> Name, Size, Price, DLC;
    public ArrayList<Integer> Image;
    int counter, Counter_of_baskets_pizza;

    public PizzaBasketAdapter(Context context,
                              ArrayList<String> name,
                              ArrayList<String> size,
                              ArrayList<String> price,
                              ArrayList<String> dlc,
                              ArrayList<Integer> image,
                              int counter_of_baskets_pizza
    ) {
        this.context = context;
        Name = name;
        Size = size;
        Price = price;
        DLC = dlc;
        Image = image;
        Counter_of_baskets_pizza = counter_of_baskets_pizza;
    }

    @NonNull
    @Override
    public PizzaBasketAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_of_pizza_of_basket, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaBasketAdapter.ViewHolder holder, int position) {
        counter = 1;
        holder.image_in_layout.setImageResource(Image.get(position));
        holder.name_in_layout.setText(Name.get(position));
        holder.size_in_layout.setText(Size.get(position));
        holder.price_in_layout.setText(Price.get(position));
        holder.DLC_in_layout.setText(DLC.get(position));

        holder.num_in_layout.setOnClickListener(v -> {
            Toast toast = Toast.makeText(v.getContext(), "qwe", Toast.LENGTH_SHORT);
            toast.show();
        });
        holder.plus_in_layout.setOnClickListener(v -> {
            Toast toast = Toast.makeText(v.getContext(), "qwe", Toast.LENGTH_SHORT);
            toast.show();
        });
    }

    @Override
    public int getItemCount() {
        return Counter_of_baskets_pizza;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_in_layout;
        TextView name_in_layout, price_in_layout, size_in_layout, DLC_in_layout, num_in_layout;
        Button minus_in_layout, plus_in_layout;
        ViewHolder(View itemView) {
            super(itemView);
            image_in_layout = itemView.findViewById(R.id.pizza_photo_in_basket);
            name_in_layout = itemView.findViewById(R.id.name_of_pizza_in_basket);
            price_in_layout = itemView.findViewById(R.id.price_in_basket);
            size_in_layout = itemView.findViewById((R.id.size_in_basket));
            DLC_in_layout = itemView.findViewById((R.id.DLC_in_basket));
            minus_in_layout = itemView.findViewById(R.id.minus);
            plus_in_layout = itemView.findViewById(R.id.plus);
            num_in_layout = itemView.findViewById(R.id.num);
        }
    }
}
