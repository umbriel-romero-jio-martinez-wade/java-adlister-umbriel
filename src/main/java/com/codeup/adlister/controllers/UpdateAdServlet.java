package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.UpdateAdServlet", urlPatterns = "/update")
public class UpdateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            String update = req.getParameter("updateId");
            req.setAttribute("updateId", update);
            req.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String updateId = req.getParameter("updateId");
        String title = req.getParameter("title");
        String description = req.getParameter("description");

        Ads ad = DaoFactory.getAdsDao();
        ad.update(Long.parseLong(updateId), title, description);


        resp.sendRedirect("/profile");
    }


}