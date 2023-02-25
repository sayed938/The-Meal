package com.example.themeal.ui.Adapters;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themeal.R;
import com.example.themeal.pojo.area.MealArea;

import java.util.ArrayList;

public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.ViewHolder> {
    ArrayList<MealArea> area_list = new ArrayList<>();
    private final Clicking listener;
    int pos;

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
                pos = position;
                listener.onItemClicked(area_list.get(position).strArea);
                notifyDataSetChanged();
            }
        });
        if (pos == position) {
            holder.card.setBackgroundResource(R.drawable.bottom_nav_custom);
        } else {
            holder.card.setBackgroundResource(R.drawable.area_card_custom);
        }
    }

    @Override
    public int getItemCount() {
        return area_list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView area_name;
        CardView card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            area_name = itemView.findViewById(R.id.area_name);
            card = itemView.findViewById(R.id.card_area_name);
        }
    }

    public interface Clicking {
        void onItemClicked(String name);
    }

}

