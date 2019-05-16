package org.melsif.controller;

import org.melsif.model.Administrator;
import org.melsif.model.User;
import org.melsif.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            //request.getSession().setAttribute("user", user.getAccount().getName());
            //this.getServletContext().getRequestDispatcher("/WEB-INF/views/adminInterface.jsp").forward(request,response);
            request.getSession().setAttribute("user", user);
            if (user instanceof Administrator) {
                this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request,response);
            } else {
                this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request,response);
            }
        }
    }
}
