/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


/**
 *
 * @author air
 */

@Embeddable
public class RecordId implements java.io.Serializable {
    private Survey survey;
    private Intern intern;
    
    @ManyToOne
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @ManyToOne
    public Intern getIntern() {
        return intern;
    }
    
    public void setIntern(Intern intern) {
        this.intern = intern;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecordId that = (RecordId) o;

        if (intern != null ? !intern.equals(that.intern) : that.intern != null) return false;
        if (survey != null ? !survey.equals(that.survey) : that.survey != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (intern != null ? intern.hashCode() : 0);
        result = 31 * result + (survey != null ? survey.hashCode() : 0);
        return result;
    }
}
