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
import org.melsif.model.Administrator;
import org.melsif.model.OrderQuestion;
import org.melsif.model.OrderResponse;
import org.melsif.model.Question;
import org.melsif.model.Response;
import org.melsif.model.Survey;
import org.melsif.model.User;
import org.melsif.service.SurveyService;
import org.melsif.service.UserService;

/**
 *
 * @author air
 */
public class RecordController extends HttpServlet {
    
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
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/record.jsp").forward(request,response);
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
        
        User user = (User) request.getSession().getAttribute("user");
        
        Survey survey = surveys.stream()
                .filter(sk -> request.getParameter("survey").equals(sk.getId().toString()))
                .findAny()
                .orElse(null);
        
        request.setAttribute("survey",survey);
        request.setAttribute("user",user);
        int score = 0;
        
        System.out.println("IN HERE");
        for (OrderQuestion orderQuestion : survey.getOrderQuestions()) {
            System.out.println("START");
            Response good = orderQuestion.getQuestion().getGood();
            System.out.println(good.getContent());
            Integer orderQ = orderQuestion.getOrderQ();
            for (OrderResponse orderResponse : orderQuestion.getQuestion().getOrderResponses()) {
                String order = (String) request.getAttribute("resp"+orderQ);
                System.out.println(order);
                if(order!=null && order.equals(orderQ.toString()+orderResponse.getOrderR().toString()) &&
                        orderResponse.getResponse().getContent().equals(good.getContent())){
                    score++;
                }
            }
        }
        request.setAttribute("score",score);
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request,response);
    }
    
}
