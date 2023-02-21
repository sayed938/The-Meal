package com.example.themeal.ui;

import android.annotation.SuppressLint;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.themeal.MealData.RetrofitBuilder;
import com.example.themeal.pojo.details.CategoryDetails;
import com.example.themeal.pojo.details.RootDetails;
import com.example.themeal.pojo.images.Meal;
import com.example.themeal.pojo.images.Root;


import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ViewModelDetails extends ViewModel {

    public MutableLiveData<ArrayList<CategoryDetails>> mealliveDataDetails = new MutableLiveData<>();
    public MutableLiveData<ArrayList<Meal>> liveDataImages = new MutableLiveData<>();

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


}
