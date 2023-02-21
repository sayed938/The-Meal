package com.example.themeal.ui.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themeal.R;
import com.example.themeal.pojo.images.Meal;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    List<Meal>list_meal;

    public CategoryAdapter(List<Meal> list_meal) {
        this.list_meal = list_meal;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.datarecycler_custom,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(list_meal.get(position).strMealThumb).into(holder.img_meaL);
    }

    @Override
    public int getItemCount() {
        return list_meal.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_meaL;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_meaL=itemView.findViewById(R.id.img_recycler);

        }
    }
}
