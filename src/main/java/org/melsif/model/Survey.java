package org.melsif.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Survey {
    
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    
    private Boolean isActive;
    private String title;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill")
    private Skill skill;
    
    @OneToMany(
        mappedBy = "survey",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<OrderQuestion> order = new ArrayList<>();
    
    @OneToMany(
        mappedBy = "survey",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Record> record = new ArrayList<>();
}
