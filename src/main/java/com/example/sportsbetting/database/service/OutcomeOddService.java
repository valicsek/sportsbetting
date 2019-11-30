package com.example.sportsbetting.database.service;

import com.example.sportsbetting.database.model.OutcomeOdd;
import com.example.sportsbetting.database.repository.IOutcomeOddRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class OutcomeOddService {
    @Autowired
    IOutcomeOddRepository repository;

    public void add(OutcomeOdd outcomeOdd) {
        repository.save(outcomeOdd);
    }
    public void delete(int id) {
        repository.deleteById(id);
    }
    public List<OutcomeOdd> getOutcomeOdds() {
        return (List<OutcomeOdd>) repository.findAll();
    }
}