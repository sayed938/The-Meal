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
import com.example.themeal.pojo.ingredient.MealIngred;
import com.example.themeal.ui.Adapters.IngredientAdapter;
import com.example.themeal.ui.ViewModelDetails;
import java.util.ArrayList;


public class Ingredients extends Fragment {
    private RecyclerView ingredRecycler;
    private ViewModelDetails model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);
        ingredRecycler = view.findViewById(R.id.recycler_ingredient);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false);
        ingredRecycler.setLayoutManager(manager);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
