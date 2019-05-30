/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melsif.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderResponse {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id")
    private Response response;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id")
    private Question question;
    
    
    private Integer ordreR;
    
}
