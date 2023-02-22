package com.example.themeal.MealData;

import static com.example.themeal.ui.ProjectData.baseUrl;
import com.example.themeal.ui.GetMeal;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {


    Retrofit RETROFIT = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    public GetMeal getMeal() {
        return RETROFIT.create(GetMeal.class);
    }
}
