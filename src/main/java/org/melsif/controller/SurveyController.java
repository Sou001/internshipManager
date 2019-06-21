/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.melsif.model.Administrator;
import org.melsif.model.Skill;
import org.melsif.model.Survey;
import org.melsif.model.User;
import org.melsif.service.SkillService;
import org.melsif.service.SurveyService;
import org.melsif.service.UserService;

/**
 *
 * @author air
 */
public class SurveyController extends HttpServlet {

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
        
        String email = request.getParameter("action");
        UserService userService = new UserService();
        User user = userService.getUserByEmail(email);
        request.setAttribute("user",user);
        
        SurveyService surveyService = new SurveyService();
        List<Survey> surveys = surveyService.getAllSurveys();
        
        
        if (user instanceof Administrator) {
            request.setAttribute("role", "administrator");
        } else {
            request.setAttribute("role", "intern");
            surveys = surveys.stream()
                    .filter(p -> p.getIsActive())
                    .collect(Collectors.toList());
        }
        
        
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
        SurveyService surveyService = new SurveyService();
        List<Survey> surveys = surveyService.getAllSurveys();
        
        String id = request.getParameter("surveyId");
        String internSurveyId = request.getParameter("internSurveyId");
        String email = request.getParameter("intern");
        
        if (id!= null) {
            
            for (Survey survey : surveys) {
                String idString = survey.getId().toString();
                if(idString == null ? id == null : idString.equals(id)) {
                    request.setAttribute("survey",survey);
                }
                
            }
            
            SkillService skillService = new SkillService();
            List<Skill> skills = skillService.getAllSkills();
            request.setAttribute("skills", skills);
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(request,response);
        } else if (internSurveyId != null) {
            //Get survey's details
            Survey survey = surveys.stream()
                .filter(sk -> internSurveyId.equals(sk.getId().toString()))
                .findAny()
                .orElse(null);
            request.setAttribute("survey",survey);
            
            
            UserService userService = new UserService();
            User user = userService.getUserByEmail(email);
            
            request.setAttribute("user",user);
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/record.jsp").forward(request,response);
        } else if (email != null) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/intern.jsp").forward(request,response);
        } else {
            
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
    
}
