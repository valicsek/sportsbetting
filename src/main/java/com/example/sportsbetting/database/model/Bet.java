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

    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public SportEvent getEvent() {
        return event;
    }
    public List<Outcome> getWinnerOutcomes() {
        return winnerOutcomes;
    }
    public BetType getType() {
        return type;
    }

    public static class Builder {
        private String description;
        private SportEvent event;
        private List<Outcome> winnerOutcomes;
        private BetType type;

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        public Builder setEvent(SportEvent event) {
            this.event = event;
            return this;
        }
        public Builder setWinnerOutcomes(List<Outcome> winnerOutcomes) {
            this.winnerOutcomes = winnerOutcomes;
            return this;
        }
        public Builder setType(BetType type) {
            this.type = type;
            return this;
        }
        public Bet build() {
            Bet bet = new Bet();
            bet.description = this.description;
            bet.event = this.event;
            bet.winnerOutcomes = this.winnerOutcomes;
            bet.type = this.type;

            return bet;
        }
    }
}

