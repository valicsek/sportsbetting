package com.example.sportsbetting.database.model;

import javax.persistence.Id;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "outcomeodd")
public class OutcomeOdd {

        @Id
        @GeneratedValue
        private int Id;

        @Column(name="value")
        private BigDecimal value;

        @Column(name="validFrom")
        private LocalDateTime validFrom;

        @Column(name="validUntil")
        private LocalDateTime validUntil;

        @OneToOne()
        private Outcome outcome;
}
