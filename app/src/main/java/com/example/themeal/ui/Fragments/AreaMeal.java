package com.example.themeal.ui.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.themeal.R;
import com.example.themeal.pojo.area.MealArea;
import com.example.themeal.pojo.images.Meal;
import com.example.themeal.ui.Adapters.AreaAdapter;
import com.example.themeal.ui.Adapters.AreaFoodAdapter;
import com.example.themeal.ui.ViewModelDetails;

import java.util.ArrayList;

public class AreaMeal extends Fragment {
    private RecyclerView areaRecycler, areaFoodRecycler;
    private ViewModelDetails model;
    private TextView name_area;
    private AreaAdapter.Clicking clicking;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_area_meal, container, false);
        name_area = v.findViewById(R.id.name_area);
        areaRecycler = v.findViewById(R.id.area_recycler);
        areaFoodRecycler = v.findViewById(R.id.area_food_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false);
        areaRecycler.setLayoutManager(layoutManager);

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false);
        areaFoodRecycler.setLayoutManager(layoutManager2);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = ViewModelProviders.of(this).get(ViewModelDetails.class);
        clicking = new AreaAdapter.Clicking() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClicked(String name) {
                name_area.setText(name + " Food");
                getFoodImg(name);
            }
        };
        getArea();
        getFoodImg("American");
    }

    private void getArea() {
        model.getArea();
        model.liveDataArea.observe(getActivity(), new Observer<ArrayList<MealArea>>() {
            @Override
            public void onChanged(ArrayList<MealArea> meals) {
                areaRecycler.setAdapter(new AreaAdapter(meals, clicking));
            }
        });
    }

    private void getFoodImg(String area) {
        model.getAreaFoodImg(area);
        model.liveDataImages.observe(getActivity(), new Observer<ArrayList<Meal>>() {
            @Override
            public void onChanged(ArrayList<Meal> meals) {
                areaFoodRecycler.setAdapter(new AreaFoodAdapter(meals));
            }
        });
    }

}