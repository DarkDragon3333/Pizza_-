package com.example.pizza.Pizza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizza.Basket.BasketViewModel;
import com.example.pizza.MainActivity;
import com.example.pizza.R;

import java.util.ArrayList;
import java.util.Objects;

public class PizzaBasketAdapter extends RecyclerView.Adapter<PizzaBasketAdapter.ViewHolder>{
    private LayoutInflater inflater; //XML для данных
    Context context;
    public ArrayList<String> Name, Size, Price, DLC;
    public ArrayList<Integer> Image;
    int Counter_of_baskets_pizza;
    ArrayList<String> num_of_recyclerItem;
    String name_current_fragment = "";
    BasketViewModel basketViewModel;
    public PizzaBasketAdapter(Context context,
                              ArrayList<String> name,
                              ArrayList<String> size,
                              ArrayList<String> price,
                              ArrayList<String> dlc,
                              ArrayList<Integer> image,
                              int counter_of_baskets_pizza,
                              String name_current_fragment,
                              ArrayList<String> num_of_recyclerItem,
                              BasketViewModel basketViewModel
    ) {
        this.context = context;
        Name = name;
        Size = size;
        Price = price;
        DLC = dlc;
        Image = image;
        Counter_of_baskets_pizza = counter_of_baskets_pizza;
        this.name_current_fragment = name_current_fragment;
        this.num_of_recyclerItem = num_of_recyclerItem;
        this.basketViewModel = basketViewModel;
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
        ArrayList<String> t = new ArrayList<>();
        int[] counter = new int[1];
        final String[] temp = {""};

        holder.image_in_layout.setImageResource(Image.get(position));
        holder.name_in_layout.setText(Name.get(position));
        holder.size_in_layout.setText(Size.get(position));
        holder.price_in_layout.setText(Price.get(position));
        holder.DLC_in_layout.setText(DLC.get(position));

        if(Objects.equals(((MainActivity) context).getNum_in_layout_of_basket().get(position), "0")
        ){
            holder.num_in_layout.setText(String.valueOf(1));
            ((MainActivity) context).setFlag_of_RecyclerItem(1, position);
            ((MainActivity) context).setNum_in_layout_of_basket(1, position);
            counter[0] = 1;
        }
        else {
            t = ((MainActivity) context).getNum_in_layout_of_basket();
            counter[0] = Integer.parseInt(String.valueOf(t.get(position)));
            holder.num_in_layout.setText(String.valueOf(counter[0]));
        }

        holder.minus_in_layout.setOnClickListener(v -> {
            temp[0] = String.valueOf(--counter[0]);
            holder.num_in_layout.setText(temp[0]);
            ((MainActivity) context).setNum_in_layout_of_basket(Integer.parseInt(temp[0]), position);

            if(Objects.equals(holder.num_in_layout.getText(), "0")){
                removeItem(position, holder);
            }
        });

        holder.plus_in_layout.setOnClickListener(v -> {
            temp[0] = String.valueOf(++counter[0]);
            holder.num_in_layout.setText(temp[0]);
            ((MainActivity) context).setNum_in_layout_of_basket(Integer.parseInt(temp[0]), position);
        });

    }

    public void removeItem(int position, @NonNull PizzaBasketAdapter.ViewHolder holder){

        ArrayList<String> tempName, tempSize, tempPrice, tempDLC, tempNum_in_layout;
        ArrayList<Integer> tempImage;

        holder.image_in_layout.setImageResource(0);
        holder.name_in_layout.setText("");
        holder.size_in_layout.setText("");
        holder.price_in_layout.setText("");
        holder.DLC_in_layout.setText("");
        holder.num_in_layout.setText("");

        tempName = basketViewModel.getName();
        tempImage = basketViewModel.getImage();
        tempSize = basketViewModel.getSize();
        tempPrice = basketViewModel.getPrice();
        tempDLC = basketViewModel.getDLC();
        tempNum_in_layout = ((MainActivity) context).getNum_in_layout_of_basket();

        tempName.remove(position);
        tempImage.remove(position);
        tempSize.remove(position);
        tempPrice.remove(position);
        tempDLC.remove(position);
        tempNum_in_layout.remove(position);

        basketViewModel.setName_pizza_of_basket(tempName);
        basketViewModel.setImage_of_basket(tempImage);
        basketViewModel.setSize_pizza_of_basket(tempSize);
        basketViewModel.setPrice_pizza_of_basket(tempPrice);
        basketViewModel.setDLC_pizza_of_basket(tempDLC);
        basketViewModel.setCount_of_basket_pizzas(
                basketViewModel.getCount_of_basket_pizzas() - 1
        );
        ((MainActivity) context).removeNum_in_layout_of_basket(position);

        Name.remove(position);
        Size.remove(position);
        Price.remove(position);
        DLC.remove(position);
        Image.remove(position);
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
