package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.UpdateUserServlet", urlPatterns = "/userupdate")
public class UpdateUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            String update = req.getParameter("user");
            System.out.println("this is the username I get " + update);
            req.setAttribute("user", update);
            req.getRequestDispatcher("/WEB-INF/userupdate.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().getAttribute("user");
        User userId = (User) req.getSession().getAttribute("user");

        long id = userId.getId();
        String username = req.getParameter("username");

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Users user = DaoFactory.getUsersDao();
        user.updateUser(id, username, email, password);
        req.getSession().setAttribute("profileUsername", user.findByUsername(username).getUsername());

        resp.sendRedirect("/login");

    }
}
