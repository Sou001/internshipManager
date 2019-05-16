package org.melsif.model;

import java.util.Set;
import javax.persistence.*;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Survey {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer surveyId;
    
    private Boolean isActive;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill")
    private Skill skill;
    
    //@OneToMany(mappedBy = "Survey")
    //Set<OrderQuestion> orders;
}
