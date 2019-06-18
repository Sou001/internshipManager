/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 *
 * @author air
 */

@Embeddable
public class RecordId implements java.io.Serializable {
    
    @Column(name = "intern_id")
    private String intern;
    @Column(name = "survey_id")
    private Integer survey;
    
    private RecordId() {}
    
   public RecordId(String intern, Integer survey) {
        this.survey = survey;
        this.intern = intern;
    }
   
   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        RecordId that = (RecordId) o;
        return Objects.equals(intern, that.intern) &&
               Objects.equals(survey, that.survey);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(survey, intern);
    }
}
