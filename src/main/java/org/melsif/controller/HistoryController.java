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
import org.melsif.model.Record;
import org.melsif.service.RecordService;

/**
 *
 * @author air
 */
public class HistoryController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecordService recordService = new RecordService();
        List<Record> records = recordService.getAllRecords();
        System.out.println("in records");
        System.out.println(records.size());
        request.setAttribute("records", records);     
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/history.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}
