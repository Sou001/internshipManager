/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.melsif.model.Survey;
import org.melsif.service.SurveyService;

/**
 *
 * @author air
 */
public class Edit extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        /*SurveyService surveyService = new SurveyService();
        List<Survey> surveys = surveyService.getAllSurveys();
        
        for (Survey survey : surveys) {
             String active = request.getParameter("survey"+survey.getId());
             System.out.println("IN HERE");
             System.out.println(active);
             if(active != null && active.length() > 0) {
                 request.setAttribute("survey",active);
             }
         }*/
        
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(request,response);
    }
}
