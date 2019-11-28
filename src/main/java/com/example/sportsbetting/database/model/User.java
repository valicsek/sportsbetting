package com.example.sportsbetting.database.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int Id;

    @Column(name = "name")
    private String name;

    @Column(name = "accountNumber")
    private Integer accountNumber;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "birth", columnDefinition = "DATE")
    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private Currency currency;
}
