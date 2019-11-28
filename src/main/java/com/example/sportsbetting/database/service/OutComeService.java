package com.example.sportsbetting.database.service;

import com.example.sportsbetting.database.model.Outcome;
import com.example.sportsbetting.database.repository.IOutcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OutComeService {
    @Autowired
    IOutcomeRepository repository;

    public void add(Outcome outcome) {
        repository.save(outcome);
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<Outcome> getBets() {
        return (List<Outcome>) repository.findAll();
    }
}