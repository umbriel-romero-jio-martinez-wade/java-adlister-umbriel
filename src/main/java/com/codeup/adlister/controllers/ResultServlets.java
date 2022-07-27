package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ResultsServlets", urlPatterns = "/results")
public class ResultServlets extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?";
        String search = request.getParameter("search");
        String searchWithWildCards = "%" + search + "%";
        request.setAttribute("search", search);

        List<Ad> ads = DaoFactory.getAdsDao().all(sql, searchWithWildCards);
        request.setAttribute("ads", ads);
        System.out.println(search);

        request.getRequestDispatcher("/WEB-INF/ads/results.jsp").forward(request, response);

    }
}
