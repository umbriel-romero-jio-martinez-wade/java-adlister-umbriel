package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/login");
            return;
        }

        if(req.getSession().getAttribute("user") != null) {
            User userId = (User)req.getSession().getAttribute("user");
            System.out.println(userId.getId());
            String username = userId.getUsername();
            req.setAttribute("username",username);
            req.setAttribute("profileAds", DaoFactory.getAdsDao().allUserAds(userId.getId()));

        }else {
            resp.sendRedirect("/login");
        }
        req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req, resp);
    }
}
