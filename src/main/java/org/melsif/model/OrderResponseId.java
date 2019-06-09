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
public class OrderResponseId implements Serializable {
    
    @Column(name = "response_id")
    private Integer response;
    @Column(name = "question_id")
    private Integer question;
    
    private OrderResponseId() {}
    
    public OrderResponseId(Integer question, Integer response) {
        this.question = question;
        this.response = response;
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderResponseId that = (OrderResponseId) o;

        return Objects.equals(question, that.question) &&
               Objects.equals(response, that.response);
    }

    public int hashCode() {
        return Objects.hash(question, response);
    }
}
