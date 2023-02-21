package com.example.themeal.pojo.details;

import com.example.themeal.pojo.details.CategoryDetails;

import java.util.ArrayList;

public class RootDetails {
    public ArrayList<CategoryDetails> categories;

    public RootDetails(ArrayList<CategoryDetails> categories) {
        this.categories = categories;
    }

    public ArrayList<CategoryDetails> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<CategoryDetails> categories) {
        this.categories = categories;
    }
}
