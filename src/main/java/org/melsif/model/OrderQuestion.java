/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.model;

import javax.persistence.*;
import lombok.Data;

public class OrderQuestion {
    
    @EmbeddedId
    OrderQuestion id;
    
    @ManyToOne
    @MapsId("quesitonId")
    @JoinColumn(name = "quesitonId")
    Question question;
    
    @ManyToOne
    @MapsId("surveyId")
    @JoinColumn(name = "surveyId")
    Survey survey;
    
    private Integer ordreQ;
    
}
