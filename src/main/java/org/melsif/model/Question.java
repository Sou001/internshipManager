package org.melsif.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author air
 */
@Data
@Entity
public class Question {
    
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    
    private Boolean isActive;
    @NaturalId(mutable = true)
    private String title;
    
    @OneToOne
    private Response good;
    
    @OneToMany(
        mappedBy = "question",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<OrderQuestion> orderQuestions = new ArrayList<>();
    
    @OneToMany(
        mappedBy = "question",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<OrderResponse> orderResponses = new ArrayList<>();
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(title, question.title);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
    
     public void addResponse(Response response, Integer order) {
        OrderResponse orderResponse = new OrderResponse(this, response, order);
        orderResponses.add(orderResponse);
        response.getOrderResponses().add(orderResponse);
    }
 
    public void removeResponse(Response response) {
        for (Iterator<OrderResponse> iterator = orderResponses.iterator();
             iterator.hasNext(); ) {
            OrderResponse orderResponse = iterator.next();
 
            if (orderResponse.getQuestion().equals(this) &&
                    orderResponse.getResponse().equals(response)) {
                iterator.remove();
                orderResponse.getQuestion().getOrderQuestions().remove(orderResponse);
                orderResponse.setQuestion(null);
                orderResponse.setResponse(null);
            }
        }
    }
    
    
}
