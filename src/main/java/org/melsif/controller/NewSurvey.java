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

import org.melsif.model.OrderResponse;
import org.melsif.service.OrderResponseService;

import org.melsif.model.OrderQuestion;
import org.melsif.service.OrderQuestionService;

import org.melsif.model.Survey;
import org.melsif.service.SurveyService;

import org.melsif.model.Skill;
import org.melsif.service.SkillService;

import org.melsif.model.Question;
import org.melsif.service.QuestionService;

import org.melsif.model.Response;
import org.melsif.service.ResponseService;

/**
 *
 * @author air
 */
public class NewSurvey extends HttpServlet {
    
    
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
        //get skills list
        SkillService skillService = new SkillService();
        List<Skill> skills = skillService.getAllSkills();
        request.setAttribute("skills", skills);
        
        // set the attributes
        request.setAttribute("nbquestion", request.getParameter("question"));
        request.setAttribute("nbresponse", request.getParameter("response"));
         
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/newSurvey.jsp").forward(request,response);
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
        
// on set d'abord le survey
        SkillService skillService = new SkillService();
        List<Skill> skills = skillService.getAllSkills();
        
        SurveyService surveyService = new SurveyService();
        Survey survey = new Survey();
        
        final String title = request.getParameter("title");
        final String subject = request.getParameter("skill");
        final String active = request.getParameter("actif");
        
        Skill skill = skills.stream()
                .filter(sk -> subject.equals(sk.getSubject()))
                .findAny()
                .orElse(null);
        
        survey.setSkill(skill);
        
        if (active.equals("actif")) {
            survey.setIsActive(true);
        } else { 
            survey.setIsActive(false);
        }
        survey.setTitle(title);
        
        surveyService.newSurvey(survey);
        
        // on set les réponses et les questions --> faut QuestionService & ResponseService
        int nbquestion = Integer.parseInt(request.getParameter("nbquestion"));
        int nbresponse = Integer.parseInt(request.getParameter("nbresponse"));
        
       
        QuestionService questionService = new QuestionService();
        ResponseService responseService = new ResponseService();
        OrderResponseService orderResponseService = new OrderResponseService();
        OrderQuestionService orderQuestionService = new OrderQuestionService();

       
        // I've got to see the case if the user don't select a good response
        for(int i = 1; i <= nbquestion; i++) {
            //set question
            Question question = new Question();
            question.setTitle((String) request.getParameter("title"+i));
            question.setIsActive(true);
            
            //fetch the good response
            Response good = new Response();
            String goodone = (String) request.getParameter("good"+i);
            
            
            for(int j = 1; j <= nbresponse; j++) {
                // new response
                Response reponse = new Response();
                reponse.setIsActive(true);
                reponse.setContent((String) request.getParameter("response"+i+j));
                responseService.newResponse(reponse);
                
                //on set la dernière reponse a good si none has been selected
                if (goodone != null && goodone.equals("good"+i+j)) {
                   good = reponse;
                } else { 
                    good = reponse;
                }
                
                // set l ordre de la réponse dans la question
                OrderResponse orderR = new OrderResponse();
                orderR.setQuestion(question);
                orderR.setResponse(reponse);
                orderR.setOrdreR(j);
                orderResponseService.newOrderResponse(orderR);
            }
            
            question.setGood(good);
            questionService.newQuestion(question);
            
            //on set l ordre de la quesiton dans le survey
            OrderQuestion orderQ = new OrderQuestion();
            orderQ.setQuestion(question);
            orderQ.setSurvey(survey);
            orderQ.setOrdreQ(i);
            orderQuestionService.newOrderQuestion(orderQ);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request,response);
    }

}
