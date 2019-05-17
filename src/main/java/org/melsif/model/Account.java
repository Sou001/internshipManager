package org.melsif.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


public class Account {

    
    private Integer id;
    private String name;
    private String society;
    private String tel;
    private LocalDate creationDate;
    private Boolean isActive;
}
