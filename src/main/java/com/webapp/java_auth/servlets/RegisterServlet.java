package com.webapp.java_auth.servlets;

import com.webapp.java_auth.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password  = request.getParameter("password");

        boolean isRegistered = userService.registerUser(fullName, email, password);

        if (isRegistered){
            response.sendRedirect("login.jsp?success=1");
        }else{
            response.sendRedirect("register.jsp?error=1");
        }
    }
}