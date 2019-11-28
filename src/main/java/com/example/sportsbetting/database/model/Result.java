package com.example.sportsbetting.database.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue
    private int Id;

    @OneToMany(targetEntity = Outcome.class)
    private List<Outcome> winnerOutcomes;
}
