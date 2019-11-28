package com.example.sportsbetting.database.model;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player extends User {

    @Column(name ="email")
    private String email;
    @Column(name = "password")
    private String password;

}
