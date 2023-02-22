package com.example.themeal.ui.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themeal.R;
import com.example.themeal.pojo.images.Meal;
import com.example.themeal.pojo.ingredient.MealIngred;
import com.example.themeal.ui.activites.DetailsCategory;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder> {
    ArrayList<MealIngred> ingreds = new ArrayList<>();

    public IngredientAdapter(ArrayList<MealIngred> ingreds) {
        this.ingreds = ingreds;
    }

    @NonNull
    @Override
    public IngredientAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingrediant_custom, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientAdapter.ViewHolder holder, int position) {
        MealIngred mealIngred = ingreds.get(position);
        holder.name.setText(mealIngred.strIngredient);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.getClicked(mealIngred.strIngredient, mealIngred.strDescription);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ingreds.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CardView view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.ingred_name);
            view = itemView.findViewById(R.id.cardView_ingred);
        }

        public void getClicked(String name, String desc) {
            Intent intent = new Intent(itemView.getContext(), DetailsCategory.class);
            intent.putExtra("nameingred", name);
            intent.putExtra("desc", desc);
            intent.putExtra("secret",1);
            itemView.getContext().startActivity(intent);
        }
    }
}
