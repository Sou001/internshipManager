/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.controller;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.melsif.model.Administrator;
import org.melsif.model.Intern;
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
        System.out.println("IN HERE");
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
            
            Intern intern = (Intern) request.getSession().getAttribute("user");
            
            Survey survey = surveys.stream()
                    .filter(sk -> request.getParameter("survey").equals(sk.getId().toString()))
                    .findAny()
                    .orElse(null);
            
            int score = 0;
            
            for (OrderQuestion orderQuestion : survey.getOrderQuestions()) {
                Response good = orderQuestion.getQuestion().getGood();
                Integer orderQ = orderQuestion.getOrderQ();
                for (OrderResponse orderResponse : orderQuestion.getQuestion().getOrderResponses()) {
                    String order = (String) request.getParameter(""+orderQ);
                    if(order!=null && order.equals(orderQ.toString()+orderResponse.getOrderR().toString()) &&
                            orderResponse.getResponse().getContent().equals(good.getContent())){
                        score++;
                    }
                }
            }
            
            String time = (String) request.getParameter("time");
            
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            Date date2;
            try {
                date2 = dateFormat.parse(time);
                request.setAttribute("time",date2);
                
                
                long diff = date.getTime() - date2.getTime();
                
                diff/=1000;
                Long diffSeconds = diff % 60;
                diff/=60;
                Long diffMinutes = diff % 60;
                diff/=60;
                Long diffHours = diff%1;
                
                String duration = ""+ diffHours + "h"+diffMinutes+"mn"+diffSeconds+"s";
                intern.addSurvey(survey,duration,score);
                
                UserService userService = new UserService();
                userService.mergeUser(intern);
                surveyService.mergeSurvey(survey);
                
            } catch (ParseException e) {
                e.printStackTrace();
            }

            this.getServletContext().getRequestDispatcher("/WEB-INF/views/intern.jsp").forward(request,response);
    }
    
}
