/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.model;

import java.util.Objects;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author air
 */
@Data
@Entity
public class OrderQuestion {
    
    @EmbeddedId
    private OrderQuestionId id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("survey")
    private Survey survey;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("question")
    private Question question;
    
    private Integer orderQ;
    private OrderQuestion() {}
    public OrderQuestion(Survey survey, Question question, Integer orderQ) {
        this.survey = survey;
        this.question = question;
        this.orderQ = orderQ;
        this.id = new OrderQuestionId(survey.getId(), question.getId());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        OrderQuestion that = (OrderQuestion) o;
        return Objects.equals(survey, that.survey) &&
               Objects.equals(question, that.question);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(survey, question);
    }
    
}
