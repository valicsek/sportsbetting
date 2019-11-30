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
    private int id;

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

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public Set<Bet> getBets() {
        return bets;
    }
    public Result getResult() {
        return result;
    }
    public static class Builder {
        private String title;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Set<Bet> bets;
        private Result result;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }
        public Builder setStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }
        public Builder setEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }
        public Builder setBets(Set<Bet> bets) {
            this.bets = bets;
            return this;
        }
        public Builder setResult(Result result) {
            this.result = result;
            return this;
        }
        public SportEvent build(int sportEventType) {
            if(sportEventType == 0) {
                FootballSportEvent footballSportEvent = (FootballSportEvent) new Builder()
                        .setTitle(this.title)
                        .setStartDate(this.startDate)
                        .setEndDate(this.endDate)
                        .setBets(this.bets)
                        .setResult(this.result)
                        .build(0);

                return footballSportEvent;
            }
            else{
                TennisSportEvent tennisSportEvent = (TennisSportEvent) new Builder()
                        .setTitle(this.title)
                        .setStartDate(this.startDate)
                        .setEndDate(this.endDate)
                        .setBets(this.bets)
                        .setResult(this.result)
                        .build(1);

                return tennisSportEvent;
            }
        }
    }
}
