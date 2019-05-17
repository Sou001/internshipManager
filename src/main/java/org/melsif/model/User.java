package org.melsif.model;

import java.time.LocalDate;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user")
public abstract class User {

    public enum Role {
        ADMINISTRATOR,
        INTERN
    }
    @Id
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
     private String name;
    private String society;
    private String tel;
    private LocalDate creationDate;
    private Boolean isActive;
}

