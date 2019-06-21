/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import org.melsif.model.Administrator;
import org.melsif.model.User;
import org.melsif.service.LoginService;

/**
 *
 * @author air
 */
@WebServlet(name = "profil", urlPatterns = {"/profil"})
public class Profil extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/profil.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        LoginService loginService = new LoginService();
        User user = loginService.getUserByEmail(email);
        if (user instanceof Administrator) {
                this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request,response);
                
        } else {
                this.getServletContext().getRequestDispatcher("/WEB-INF/views/intern.jsp").forward(request,response);
        }
    }

}
