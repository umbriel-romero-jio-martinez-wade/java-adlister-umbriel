package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories{
    Connection connection;
    public MySQLCategoriesDao(Config config) {
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
}
