package com.example.sportsbetting.database.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bet")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "description")
    private String description;

    @OneToOne()
    @JoinColumn(name = "Person_FK")
    private SportEvent event;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Outcome> winnerOutcomes;

    @Enumerated(EnumType.STRING)
    private BetType type;
}

