package org.melsif.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;
import javax.persistence.Id;


@Data
@Entity
public class Skill {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(unique = true)
    private String subject;
    
    @OneToMany(mappedBy = "skill")
    private List<Survey> items = new ArrayList<Survey>();
}
