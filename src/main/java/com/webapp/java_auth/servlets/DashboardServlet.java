package com.webapp.java_auth.servlets;

import com.webapp.java_auth.dao.UserDAO;
import com.webapp.java_auth.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private final UserDAO userDAO = new UserDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("user") == null){
            response.sendRedirect("login.jsp");
            return;
        }

        String email = (String) session.getAttribute("user");
        User user = userDAO.getUserByEmail(email);

        request.setAttribute("user", user);
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
