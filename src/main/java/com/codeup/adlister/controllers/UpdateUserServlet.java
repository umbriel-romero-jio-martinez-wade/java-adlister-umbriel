package com.codeup.adlister.controllers;


import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.UpdateUserServlet", urlPatterns = "/register")
public class UpdateUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (req.getSession().getAttribute("user") != null) {
//            String update = req.getParameter("user");
//            System.out.println("this is the username I get " + update);
//            req.setAttribute("user", update);
        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
//        } else {
//            resp.sendRedirect("/login");
//        }
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/profile");
    }
}
