/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.melsif.model.User;

/**
 *
 * @author air
 */
public class InternController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        user.setRole(User.Role.INTERN);
        request.setAttribute("user", user);
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        
    }
}
