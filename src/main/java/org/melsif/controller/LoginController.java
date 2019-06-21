package org.melsif.controller;

import org.melsif.model.Administrator;
import org.melsif.model.User;
import org.melsif.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import org.melsif.service.UserService;

public class LoginController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        LoginService loginService = new LoginService();
        boolean result = loginService.authenticateUser(email, password);
        if (!result) {
            response.sendRedirect("home");
        } else {
            User user = loginService.getUserByEmail(email);
            
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("name", user.getName());
            request.getSession().setAttribute("email", user.getEmail());
            request.getSession().setAttribute("society", user.getSociety());
            request.getSession().setAttribute("tel", user.getTel());
            request.getSession().setAttribute("date", user.getCreationDate());
            request.getSession().setAttribute("state", user.getIsActive() ? "Actif" : "Inactif");
            
            if (user instanceof Administrator) {
                request.getSession().setAttribute("role", "ADMINISTRATOR");
                this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request,response);
                
            } else if (user.getIsActive()) {
                request.getSession().setAttribute("role", "INTERN");
                this.getServletContext().getRequestDispatcher("/WEB-INF/views/intern.jsp").forward(request,response);
            } else {
                this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
            }
        }
    }
}
