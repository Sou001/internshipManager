package org.melsif.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Question {
    
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    
    private Boolean isActive;
    private String title;
    
    @OneToMany(
        mappedBy = "question",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<OrderQuestion> orderQ = new ArrayList<>();
    
    @OneToMany(
        mappedBy = "question",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<OrderResponse> orderR = new ArrayList<>();
    
    @OneToOne
    private Response good;
    
    
}
