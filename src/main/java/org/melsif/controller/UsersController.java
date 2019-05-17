package org.melsif.controller;

import org.melsif.model.User;
import org.melsif.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UsersController extends HttpServlet {
    UserService userService = new UserService();
    List<User> users = userService.getAllUsers();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         for (User user : users) {
             String active = (String) request.getSession().getAttribute(user.getName());
             String isActive = user.getIsActive() ? "True" : "False";
             if (active != isActive ) {
                 user.setIsActive(!user.getIsActive());
                 userService.mergeUser(user);
             }
         }
         this.getServletContext().getRequestDispatcher("/WEB-INF/views/users.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setAttribute("users", users);
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/users.jsp").forward(request,response);
    }
}
