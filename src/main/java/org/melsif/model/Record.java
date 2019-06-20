/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.model;

import java.sql.Time;
import java.util.Objects;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Record {
    
    @EmbeddedId
    private RecordId id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("survey")
    private Survey survey;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("intern")
    private Intern intern;
    
    private String duration;
    private Integer score;
    
    
    private Record() {}
    public Record(Intern intern, Survey survey, String duration, Integer score) {
        this.survey = survey;
        this.intern = intern;
        this.duration = duration;
        this.score = score;
        this.id = new RecordId(intern.getEmail(), survey.getId());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        Record that = (Record) o;
        return Objects.equals(survey, that.survey) &&
               Objects.equals(intern, that.intern);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(intern, survey);
    }
}
