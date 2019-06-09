/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.service;

import java.util.List;
import org.melsif.dao.QuestionDao;
import org.melsif.model.Question;

/**
 *
 * @author air
 */
public class QuestionService {
    public List<Question> getAllQuestions() {
        return QuestionDao.getInstance().findAll();
    }
    
    public void newQuestion(Question question) {
        QuestionDao.getInstance().persist(question);
    }
    public void mergeQuestion(Question question) {
        QuestionDao.getInstance().merge(question);
    }
    
    public Question getQuesiton(String title){
        return QuestionDao.getInstance().getByTitle(title);
    }
}
