package com.example.themeal.ui.Adapters;

import static com.example.themeal.ui.ProjectData.sayed1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themeal.R;
import com.example.themeal.pojo.area.MealArea;
import com.example.themeal.ui.Fragments.AreaMeal;
import com.example.themeal.ui.ProjectData;

import java.security.PublicKey;
import java.util.ArrayList;

public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.ViewHolder> {
    ArrayList<MealArea> area_list = new ArrayList<>();
    private Clicking listener;

    public AreaAdapter(ArrayList<MealArea> area_list, Clicking clicking) {
        this.area_list = area_list;
        this.listener = clicking;
    }


    @NonNull
    @Override
    public AreaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.area_custom, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AreaAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.area_name.setText(area_list.get(position).strArea);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(area_list.get(position).strArea);
            }
        });
    }

    @Override
    public int getItemCount() {
        return area_list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView area_name, area_name_food;
        CardView card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            area_name = itemView.findViewById(R.id.area_name);
            area_name_food = itemView.findViewById(R.id.name_area);
            card = itemView.findViewById(R.id.card_area_name);
        }

    }

    public interface Clicking {
        void onItemClicked(String name);
    }

}

