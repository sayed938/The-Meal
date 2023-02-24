package com.example.themeal.ui;

import android.annotation.SuppressLint;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.themeal.MealData.RetrofitBuilder;
import com.example.themeal.pojo.area.MealArea;
import com.example.themeal.pojo.area.RootArea;
import com.example.themeal.pojo.details.CategoryDetails;
import com.example.themeal.pojo.details.RootDetails;
import com.example.themeal.pojo.images.Meal;
import com.example.themeal.pojo.images.Root;
import com.example.themeal.pojo.ingredient.MealIngred;
import com.example.themeal.pojo.ingredient.RootIngred;


import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ViewModelDetails extends ViewModel {

    public MutableLiveData<ArrayList<CategoryDetails>> mealliveDataDetails = new MutableLiveData<>();
    public MutableLiveData<ArrayList<Meal>> liveDataImages = new MutableLiveData<>();
    public MutableLiveData<ArrayList<Meal>> liveDataImagesIngred = new MutableLiveData<>();
    public MutableLiveData<ArrayList<MealIngred>> liveDataingredient = new MutableLiveData<>();
    public MutableLiveData<ArrayList<MealArea>> liveDataArea = new MutableLiveData<>();


    @SuppressLint("CheckResult")
    public void getMealDetails() {
        Observable<RootDetails> observable = new RetrofitBuilder().getMeal().getdetails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o -> mealliveDataDetails.setValue(o.categories), e -> System.out.println(e.getMessage()));
    }

    @SuppressLint("CheckResult")
    public void getMealImages(String name) {
        Observable<Root> observable = new RetrofitBuilder().getMeal().getmeal(name)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o -> liveDataImages.setValue(o.meals));
    }

    @SuppressLint("CheckResult")
    public void getIngredients() {
        Observable<RootIngred> observable = new RetrofitBuilder().getMeal().getIngredient("list")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o -> liveDataingredient.setValue(o.meals));

    }

    @SuppressLint("CheckResult")
    public void getIngredient_img(String s) {
        Observable<Root> observable = new RetrofitBuilder().getMeal().getIngredient_img(s)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o -> liveDataImagesIngred.setValue(o.meals));
    }

    @SuppressLint("CheckResult")
    public void getArea() {
        Observable<RootArea> observable = new RetrofitBuilder().getMeal().getArea("list")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o -> liveDataArea.setValue(o.meals), e -> System.out.println("ERROR : " + e.getMessage()));
    }

    @SuppressLint("CheckResult")
    public void getAreaFoodImg(String name) {
        Observable<Root> observable = new RetrofitBuilder().getMeal().getAreaFoodImg(name)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o -> liveDataImages.setValue(o.meals));
    }

}
