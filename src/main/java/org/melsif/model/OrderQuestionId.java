/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author air
 */
@Embeddable
public class OrderQuestionId implements Serializable {
    @Column(name = "question_id")
    private Integer question;
    @Column(name = "survey_id")
    private Integer survey;
    
    private OrderQuestionId() {}
    
   public OrderQuestionId(Integer survey, Integer question) {
        this.survey = survey;
        this.question = question;
    }
   
   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        OrderQuestionId that = (OrderQuestionId) o;
        return Objects.equals(question, that.question) &&
               Objects.equals(survey, that.survey);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(survey, question);
    }
}
