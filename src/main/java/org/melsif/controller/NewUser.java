/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.melsif.model.User;
import org.melsif.model.Administrator;
import org.melsif.model.Intern;
import org.melsif.service.UserService;

/**
 *
 * @author air
 */

public class NewUser extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/newUser.jsp").forward(request,response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        User user;
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final String society = request.getParameter("society");
        final String tel = request.getParameter("tel");
        final String role = request.getParameter("role");
        final String name = request.getParameter("name");
    
        
        if (role.equals("Admin")) {
            user = new Administrator();
            user.setIsActive(true);
            user.setRole(User.Role.ADMINISTRATOR);
        } else {
            user = new Intern();
            user.setIsActive(false);
            user.setRole(User.Role.INTERN);
        }
        
        
        user.setSociety(society);
        user.setTel(tel);
        user.setName(name);
        user.setCreationDate(LocalDate.now());
        
        
        
        
        
        user.setEmail(email);
        user.setPassword(password);
        userService.newUser(user);
        
        
        request.getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request, response);  
    }
}
