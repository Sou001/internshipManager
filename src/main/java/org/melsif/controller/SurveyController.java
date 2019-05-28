/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.melsif.model.Survey;
import org.melsif.service.SurveyService;

/**
 *
 * @author air
 */
public class SurveyController extends HttpServlet {
    SurveyService surveyService = new SurveyService();
    List<Survey> surveys = surveyService.getAllSurveys();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("surveys", surveys);
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/survey.jsp").forward(request,response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        for (Survey survey : surveys) {
             String active = request.getParameter(""+survey.getId()+"");
             String isActive = survey.getIsActive().toString();
             if (!active.equals(isActive)) {
                 survey.setIsActive(!survey.getIsActive());
                 surveyService.mergeSurvey(survey);
             }
         }
         this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request,response);
    }

}
