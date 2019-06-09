/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.model;

import java.util.Objects;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderResponse {
    
    @EmbeddedId
    private OrderResponseId id;
    
     @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("response")
    private Response response;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("question")
    private Question question;
    
    
    private Integer orderR;
    
    private OrderResponse() {}
    public OrderResponse(Question question, Response response,Integer orderR) {
        this.response = response;
        this.question = question;
        this.orderR = orderR;
        this.id = new OrderResponseId(question.getId(), response.getId());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        OrderResponse that = (OrderResponse) o;
        return Objects.equals(question, that.question) &&
                Objects.equals(response, that.response);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(question,response);
    }
    
}
