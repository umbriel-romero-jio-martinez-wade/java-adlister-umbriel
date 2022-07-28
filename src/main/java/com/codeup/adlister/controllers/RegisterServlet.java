package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");


        // validate input
        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty()
                || password.isEmpty()
                || (!password.equals(passwordConfirmation));

        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
        }


        Users checkUsername = DaoFactory.getUsersDao();
        User search = checkUsername.findByUsername(username);
        if (search == null) {
            // create and save a new user
            User user = new User(username, email, password);

            DaoFactory.getUsersDao().insert(user);
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("profileUsername", DaoFactory.getUsersDao().findByUsername(username).getUsername());

            response.sendRedirect("/login");
        } else {
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("password", password);
            request.getSession().setAttribute("passwordConfirmation", passwordConfirmation);

            response.sendRedirect("/register");

        }


    }
}
