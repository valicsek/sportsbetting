package com.example.sportsbetting.database.model;

import javax.persistence.*;

@Entity
public class Player {
    @Id
    @GeneratedValue
            private int id;

    @Column(name ="email")
    private String email;
    @Column(name = "password")
    private String password;
}
