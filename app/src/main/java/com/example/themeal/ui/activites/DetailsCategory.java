package com.example.themeal.ui.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.themeal.R;
import com.example.themeal.pojo.details.CategoryDetails;
import com.example.themeal.pojo.images.Meal;
import com.example.themeal.ui.Adapters.CategoryAdapter;
import com.example.themeal.ui.ViewModelDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailsCategory extends AppCompatActivity {
    RecyclerView recyclerview;
    CategoryAdapter categoryAdapter;
    TextView meal_txt, detailstxt;
    ImageView img;
    ViewModelDetails viewModelDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_category);
        viewModelDetails = ViewModelProviders.of(this).get(ViewModelDetails.class);
        recyclerview = findViewById(R.id.category_recycler);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                DetailsCategory.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerview.setLayoutManager(manager);
        int num = getIntent().getExtras().getInt("index");
        String name = getIntent().getExtras().getString("name");
        callDetails(num);
        callImages(name);

    }

    public void callDetails(int i) {
        detailstxt = findViewById(R.id.txt_details);
        meal_txt = findViewById(R.id.txt_meal_name);
        img = findViewById(R.id.img_meal_details);
        viewModelDetails.getMealDetails();
        viewModelDetails.mealliveDataDetails.observe(this, new Observer<ArrayList<CategoryDetails>>() {
            @Override
            public void onChanged(ArrayList<CategoryDetails> categoryDetails) {
                detailstxt.setText(categoryDetails.get(i).strCategoryDescription);
                meal_txt.setText(categoryDetails.get(i).strCategory);
                Picasso.get().load(categoryDetails.get(i).strCategoryThumb).into(img);
            }
        });

    }

    public void callImages(String name) {
        viewModelDetails.getMealImages(name);
        viewModelDetails.liveDataImages.observe(this, new Observer<ArrayList<Meal>>() {
            @Override
            public void onChanged(ArrayList<Meal> meals) {
                categoryAdapter = new CategoryAdapter(meals);
                recyclerview.setAdapter(categoryAdapter);
            }
        });
    }

}
