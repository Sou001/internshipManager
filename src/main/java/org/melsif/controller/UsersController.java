package org.melsif.controller;

import org.melsif.model.User;
import org.melsif.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UsersController extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        List<User> users = userService.getAllUsers(); 
        
        for (User user : users) {
             String active = request.getParameter(user.getEmail());
             String isActive = user.getIsActive().toString();
             if (!active.equals(isActive) ) {
                 user.setIsActive(!user.getIsActive());
                 userService.mergeUser(user);
             }
         }
         this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        List<User> users = userService.getAllUsers();
        request.setAttribute("users", users);
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/users.jsp").forward(request,response);
    }
}
