package com.example.themeal.ui.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.themeal.R;
import com.example.themeal.ui.activites.DetailsCategory;
import com.squareup.picasso.Picasso;


public class CategoryMeal extends Fragment {
ImageView img_beef,img_chicken,img_dessert,img_pasta,img_lamb,img_miscellaneous,img_breakfast,
    img_seafood,img_pork,img_side,img_starter,img_vegan,img_vegetarian;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View v=inflater.inflate(R.layout.fragment_category_meal, container, false);
        return v;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Loading Images
        Load(view);
        view.findViewById(R.id.card_beef).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

         gettxt(0,"Beef");
    }
});
        view.findViewById(R.id.card_breakfast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettxt(12,"Breakfast");
            }
        });
        view.findViewById(R.id.card_chicken).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettxt(1,"Chicken");
            }
        });
        view.findViewById(R.id.card_dessert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettxt(2,"Dessert");
            }
        });
        view.findViewById(R.id.card_lamb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettxt(3,"Lamb");
            }
        });
        view.findViewById(R.id.card_misc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettxt(4,"Miscellaneous");
            }
        });
        view.findViewById(R.id.card_pasta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettxt(5,"Pasta");
            }
        });
        view.findViewById(R.id.card_pork).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettxt(6,"Pork");
            }
        });
        view.findViewById(R.id.card_seafood).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettxt(7,"Seafood");
            }
        });
        view.findViewById(R.id.card_side).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettxt(8,"Side");
            }
        });
        view.findViewById(R.id.card_starter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettxt(9,"Starter");
            }
        });
        view.findViewById(R.id.card_vegan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettxt(10,"Vegan");
            }
        });
        view.findViewById(R.id.card_vegetar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettxt(11,"Vegetarian");
            }
        });
        view.findViewById(R.id.card_goat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettxt(13,"Goat");
            }
        });

    }
    private void gettxt(int ii,String name){
        Intent intent=new Intent(getContext(), DetailsCategory.class);
        intent.putExtra("index",ii);
        intent.putExtra("name",name);
        startActivity(intent);

    }
    private void Load(View view){
        img_beef=view.findViewById(R.id.img_beef);
        Picasso.get().load("https://www.themealdb.com/images/category/beef.png").into(img_beef);
        img_chicken=view.findViewById(R.id.img_chicken);
        Picasso.get().load("https://www.themealdb.com/images/category/chicken.png").into(img_chicken);
        img_dessert=view.findViewById(R.id.img_dessert);
        Picasso.get().load("https://www.themealdb.com/images/category/dessert.png").into(img_dessert);
        img_lamb=view.findViewById(R.id.img_lamb);
        Picasso.get().load("https://www.themealdb.com/images/category/lamb.png").into(img_lamb);
        img_miscellaneous=view.findViewById(R.id.img_miscellaneous);
        Picasso.get().load("https://www.themealdb.com/images/category/miscellaneous.png").into(img_miscellaneous);
        img_breakfast=view.findViewById(R.id.img_breakfast);
        Picasso.get().load("https://www.pngall.com/wp-content/uploads/7/Morning-Breakfast-PNG-Image.png").into(img_breakfast);
        img_seafood=view.findViewById(R.id.img_seafood);
        Picasso.get().load("https://www.themealdb.com/images/category/seafood.png").into(img_seafood);
        img_pasta=view.findViewById(R.id.img_pasta);
        Picasso.get().load("https://www.themealdb.com/images/category/pasta.png").into(img_pasta);
        img_pork=view.findViewById(R.id.img_pork);
        Picasso.get().load("https://www.themealdb.com/images/category/pork.png").into(img_pork);
        img_side=view.findViewById(R.id.img_side);
        Picasso.get().load("https://www.themealdb.com/images/category/side.png").into(img_side);
        img_starter=view.findViewById(R.id.img_starter);
        Picasso.get().load("https://www.themealdb.com/images/category/starter.png").into(img_starter);
        img_vegan=view.findViewById(R.id.img_vegan);
        Picasso.get().load("https://www.themealdb.com/images/category/vegan.png").into(img_vegan);
        img_vegetarian=view.findViewById(R.id.img_vegetarian);
        Picasso.get().load("https://www.themealdb.com/images/category/vegetarian.png").into(img_vegetarian);
    }
}