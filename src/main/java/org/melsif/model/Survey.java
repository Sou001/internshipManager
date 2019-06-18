package org.melsif.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

@Data
@Entity
public class Survey {
    
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    
    private Boolean isActive;
    
    @NaturalId(mutable = true)
    private String title;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill")
    private Skill skill;
    
    @OneToMany(
        mappedBy = "survey",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<OrderQuestion> orderQuestions = new ArrayList<>();
    
    @OneToMany(
        mappedBy = "survey",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Record> records = new ArrayList<>();
    
    
    
    public void addQuestion(Question question, Integer order) {
        OrderQuestion orderQuestion = new OrderQuestion(this, question, order);
        orderQuestions.add(orderQuestion);
        question.getOrderQuestions().add(orderQuestion);
    }
 
    public void removeQuestion(Question question) {
        for (Iterator<OrderQuestion> iterator = orderQuestions.iterator();
             iterator.hasNext(); ) {
            OrderQuestion orderQuestion = iterator.next();
 
            if (orderQuestion.getSurvey().equals(this) &&
                    orderQuestion.getQuestion().equals(question)) {
                iterator.remove();
                orderQuestion.getQuestion().getOrderQuestions().remove(orderQuestion);
                orderQuestion.setSurvey(null);
                orderQuestion.setQuestion(null);
            }
        }
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        Survey survey = (Survey) o;
        return Objects.equals(title, survey.title);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
