package com.example.themeal.ui;


import com.example.themeal.pojo.images.Root;
import com.example.themeal.pojo.details.RootDetails;
import com.example.themeal.pojo.ingredient.RootIngred;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetMeal {
    @GET("api/json/v1/1/filter.php")
    Observable<Root> getmeal(@Query("c") String category);
    @GET("api/json/v1/1/categories.php")
    Observable<RootDetails>getdetails();
    @GET("api/json/v1/1/list.php")
        Observable<RootIngred> getIngredient(@Query("i") String ingredient);
    @GET("api/json/v1/1/filter.php")
    Observable<Root> getIngredient_img(@Query("i") String ingredient);

}
