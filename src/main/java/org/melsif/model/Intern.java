package org.melsif.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Data
@Entity
@DiscriminatorValue("intern")
public class Intern extends User {
    
    @OneToMany(
        mappedBy = "intern",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Record> record = new ArrayList<>();
}
