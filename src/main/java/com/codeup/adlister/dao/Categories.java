package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {
    List<Category> all();

    Category findByCategoryId(long categoryId);

    List<Ad> getAdsWithCategory(Long num);
    List<Ad> getAdsWithCategory(String str);


    Long insert(long adId, long catId);
}
