package org.melsif.controller;

import org.melsif.model.User;
import org.melsif.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        LoginService loginService = new LoginService();
        boolean result = loginService.authenticateUser(email, password);
        if (!result) {
            response.sendRedirect("error");
        } else {
            User user = loginService.getUserByEmail(email);
            System.out.println(user.getClass());
            System.out.println(user);
            request.getSession().setAttribute("user", user.getAccount().getName());
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/adminInterface.jsp").forward(request,response);
            response.sendRedirect("adminInterface");
            
        }
    }
}
