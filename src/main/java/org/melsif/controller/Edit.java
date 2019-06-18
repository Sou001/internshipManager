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
import org.melsif.model.Skill;
import org.melsif.model.Survey;
import org.melsif.service.SkillService;
import org.melsif.service.SurveyService;

/**
 *
 * @author air
 */
public class Edit extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        SurveyService surveyService = new SurveyService();
        List<Survey> surveys = surveyService.getAllSurveys();
        
        SkillService skillService = new SkillService();
        List<Skill> skills = skillService.getAllSkills();
        
        final String title = request.getParameter("title");
        final String subject = request.getParameter("skill");
        final String active = request.getParameter("actif");
        
        String id = request.getParameter("survey");
        
        
        Survey survey = surveys.stream()
                .filter(sk -> id.equals(sk.getId().toString()))
                .findAny()
                .orElse(null);
        
        Skill skill = skills.stream()
                .filter(sk -> subject.equals(sk.getSubject()))
                .findAny()
                .orElse(null);
        
        if(!survey.getSkill().getId().equals(skill.getId())) {
            survey.setSkill(skill);
        }
        if(!survey.getTitle().equals(title)){
            survey.setTitle(title);
        }
        
        
        if (!active.equals("actif")) {
            survey.setIsActive(!survey.getIsActive());
        }
            
        
        surveyService.mergeSurvey(survey);
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request,response);
        
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
    
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(request,response);
    }
}
