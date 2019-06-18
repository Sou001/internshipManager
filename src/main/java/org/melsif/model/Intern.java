package org.melsif.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
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
    private List<Record> records = new ArrayList<>();
    
    public void addSurvey(Survey survey, Time duration, Integer score) {
        Record record = new Record(this, survey, duration,score);

        records.add(record);
        survey.getRecords().add(record);
    }
 
    public void removeRecord(Survey survey) {
        for (Iterator<Record> iterator = records.iterator();
             iterator.hasNext(); ) {
            Record record = iterator.next();
 
            if (record.getIntern().equals(this) &&
                    record.getIntern().equals(survey)) {
                iterator.remove();
                record.getSurvey().getOrderQuestions().remove(record);
                record.setSurvey(null);
                record.setSurvey(null);
            }
        }
    }
}
