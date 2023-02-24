package com.example.themeal.ui.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themeal.R;
import com.example.themeal.pojo.images.Meal;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AreaFoodAdapter extends RecyclerView.Adapter<AreaFoodAdapter.ViewHolder> {
    ArrayList<Meal> meals;

    public AreaFoodAdapter(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    @NonNull
    @Override
    public AreaFoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.area_food_custom, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AreaFoodAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(meals.get(position).strMeal);
        Picasso.get().load(meals.get(position).strMealThumb).into(holder.img_food);
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView img_food;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.area_food_txt);
            img_food = itemView.findViewById(R.id.area_food_img);

        }
    }
}
