package com.example.sportsbetting.database.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "result")
public class Result {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(targetEntity = Outcome.class)
    private List<Outcome> winnerOutcomes;

    public int getId() {
        return id;
    }
    public List<Outcome> getWinnerOutcomes() {
        return winnerOutcomes;
    }

    public static class Builder {
        private List<Outcome> winnerOutcomes;

        public Builder setWinnerOutcomes(List<Outcome> winnerOutcomes) {
            this.winnerOutcomes = winnerOutcomes;
            return this;
        }

        public Result build() {
            Result result = new Result();
            result.winnerOutcomes = this.winnerOutcomes;

            return result;
        }
    }
}
