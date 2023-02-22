package com.example.themeal.ui.activites;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.themeal.R;
import com.example.themeal.pojo.details.CategoryDetails;
import com.example.themeal.pojo.images.Meal;
import com.example.themeal.ui.Adapters.CategoryAdapter;
import com.example.themeal.ui.ViewModelDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailsCategory extends AppCompatActivity {
    RecyclerView recyclerview;
    //CategoryAdapter categoryAdapter;
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
        detailstxt = findViewById(R.id.txt_details);
        meal_txt = findViewById(R.id.txt_meal_name);
        img = findViewById(R.id.img_meal_details);
        int secret = getIntent().getExtras().getInt("secret");
        if(secret==1){
            getDetailsIngred();
        }
        else if(secret==2){
            callDetails();
        }

    }

    private void callDetails() {
        int i = getIntent().getExtras().getInt("index");
        viewModelDetails.getMealDetails();
        viewModelDetails.mealliveDataDetails.observe(this, new Observer<ArrayList<CategoryDetails>>() {
            @Override
            public void onChanged(ArrayList<CategoryDetails> categoryDetails) {
                detailstxt.setText(categoryDetails.get(i).strCategoryDescription);
                meal_txt.setText(categoryDetails.get(i).strCategory);
                Picasso.get().load(categoryDetails.get(i).strCategoryThumb).into(img);
            }
        });
        String name = getIntent().getExtras().getString("name");
        callImages(name);
    }

    private void callImages(String name) {
        viewModelDetails.getMealImages(name);
        viewModelDetails.liveDataImages.observe(this, new Observer<ArrayList<Meal>>() {
            @Override
            public void onChanged(ArrayList<Meal> meals) {
                recyclerview.setAdapter(new CategoryAdapter(meals));
            }
        });
    }

    private void getDetailsIngred() {
        String name = getIntent().getExtras().getString("nameingred");
        String desc = getIntent().getExtras().getString("desc");
        meal_txt.setText(name);
        detailstxt.setText(desc);
        getImagesIngred(name);
    }

    private void getImagesIngred(String name) {
        viewModelDetails.getIngredient_img(name);
        viewModelDetails.liveDataImagesIngred.observe(this, new Observer<ArrayList<Meal>>() {
            @Override
            public void onChanged(ArrayList<Meal> meals) {
                try {
                    Picasso.get().load(meals.get(0).strMealThumb).into(img);
                    recyclerview.setAdapter(new CategoryAdapter(meals));
                } catch (Exception e) {
                    Toast.makeText(DetailsCategory.this, "No Data", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
