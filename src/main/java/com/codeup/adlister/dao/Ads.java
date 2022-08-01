package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    List<Ad>all(String sql,String search);
    Long insert(Ad ad);

    Ad singleAd(int adId);

    List<Ad> allUserAds(long userId);

    void delete(long delId);

    void update(long updateId,String title,String description);
    void deletes(long delId);


}
