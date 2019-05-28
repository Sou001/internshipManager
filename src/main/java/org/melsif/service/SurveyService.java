/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.service;

import java.util.List;
import org.melsif.dao.SurveyDao;
import org.melsif.model.Survey;

/**
 *
 * @author air
 */
public class SurveyService {
    public List<Survey> getAllSurveys() {
        return SurveyDao.getInstance().findAll();
    }
    
    public void mergeSurvey(Survey survey) {
        SurveyDao.getInstance().merge(survey);
    }
}
