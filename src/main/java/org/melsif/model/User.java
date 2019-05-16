package org.melsif.model;

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
    @OneToOne
    private Account account;
    private Role role;
}

