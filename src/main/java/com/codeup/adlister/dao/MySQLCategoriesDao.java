package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories{
    Connection connection;
    public MySQLCategoriesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public List<Category> all() {
        PreparedStatement stmt= null;

        try {
            stmt=connection.prepareStatement("SELECT * FROM category");
            ResultSet rs = stmt.executeQuery();
            return createCategoryFromResults(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    private Category extractCategory(ResultSet rs) throws SQLException {
        if(!rs.next()){
            return null;
        }
        return new Category(
                rs.getLong("id"),
                rs.getString("name")
        );
    }

    private List<Category> createCategoryFromResults(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            categories.add(extractCategory(rs));
        }

        return categories;
    }



    @Override
    public Category findByCategoryId(long categoryId) {
        String sql = "SELECT * FROM category WHERE id =? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1,categoryId);
            return extractCategory(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Long insert(long catId, long adID) {
        try {
            String insertCat = "INSERT INTO category_and_ads(ad_id,category_id ) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertCat, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1,catId);
            stmt.setLong(2, adID);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    public List<Ad> getAdsWithCategory(Long num) {
        String sql = "SELECT a.id,c.name,a.title,a.description,a.user_ID FROM ads AS a JOIN category_and_ads caa on a.id = caa.ad_id JOIN category c on caa.category_id = c.id WHERE c.id =?";
        try {
            List<Ad> ad = new ArrayList<>();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, num);
            ResultSet rs =   stmt.executeQuery();
//            ResultSet rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                ad.add(new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_ID"),
                                rs.getString("title"),
                                rs.getString("description")
                        )

                );
            }
            return ad;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Ad> getAdsWithCategory(String string) {
        String sql = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?";
        try {
            List<Ad> ad = new ArrayList<>();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            String str = "%"+string+"%";
            stmt.setString(1, str);
            stmt.setString(2,str);
            System.out.println(stmt.toString());
            ResultSet rs =   stmt.executeQuery();
//            ResultSet rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                ad.add(new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_ID"),
                                rs.getString("title"),
                                rs.getString("description")
                        )

                );
            }
            return ad;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
