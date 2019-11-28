package com.example.sportsbetting.database.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "outcome")
public class Outcome {

    @Id
    @GeneratedValue
    private int Id;

    @Column(name = "description")
    private String description;

    @OneToOne()
    private Bet bet;

    @OneToMany()
    private List<OutcomeOdd> outcomeOdds;
}