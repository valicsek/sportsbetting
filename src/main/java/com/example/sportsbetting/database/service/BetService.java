package com.example.sportsbetting.database.service;

import com.example.sportsbetting.database.model.Bet;
import com.example.sportsbetting.database.repository.IBetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BetService {
    @Autowired
    IBetRepository repository;

    public void add(Bet bet) {
        repository.save(bet);
    }
    public void delete(int id) {
        repository.deleteById(id);
    }
    public List<Bet> getBets() {
        return (List<Bet>) repository.findAll();
    }
}