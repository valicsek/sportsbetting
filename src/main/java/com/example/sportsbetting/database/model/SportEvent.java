package com.example.sportsbetting.database.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Inheritance
@Table(name = "sportevent")
public abstract class SportEvent {

    @Id
    @GeneratedValue
    private int Id;

    @Column(name = "title")
    private String title;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate", columnDefinition = "TIME")
    private LocalDateTime endDate;

    @OneToMany(targetEntity = Bet.class, fetch = FetchType.EAGER)
    private Set<Bet> bets;

    @OneToOne(fetch = FetchType.EAGER)
    private Result result;
}
