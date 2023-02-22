package com.example.themeal.ui.Fragments;

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

import com.example.themeal.R;
import com.example.themeal.pojo.images.Meal;
import com.example.themeal.pojo.ingredient.MealIngred;
import com.example.themeal.ui.Adapters.IngredientAdapter;
import com.example.themeal.ui.ViewModelDetails;
import com.example.themeal.ui.activites.DetailsCategory;

import java.util.ArrayList;

import io.reactivex.Observable;


public class Ingredients extends Fragment {
    private RecyclerView ingredRecycler;
    ViewModelDetails model;
    IngredientAdapter adapter;
    ArrayList<String> m;
    ArrayList<String> m2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ingredients, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ingredRecycler = view.findViewById(R.id.recycler_ingredient);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false);
        ingredRecycler.setLayoutManager(manager);
        model = ViewModelProviders.of(this).get(ViewModelDetails.class);
        model.getIngredients();
        model.liveDataingredient.observe(getActivity(), new Observer<ArrayList<MealIngred>>() {
            @Override
            public void onChanged(ArrayList<MealIngred> mealIngreds) {
               ingredRecycler.setAdapter(new IngredientAdapter(mealIngreds));
            }
        });
    }

}
