package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.DeleteAdsServlet", urlPatterns = "/profile/ads/delete")
public class DeleteAdsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       long delId = Integer.parseInt(req.getParameter("delId"));
       Ads ad = DaoFactory.getAdsDao();
        ad.delete(delId);
        resp.sendRedirect("/profile");
    }

}
