package com.example.sportsbetting.database.service;

import com.example.sportsbetting.database.model.Wager;
import com.example.sportsbetting.database.repository.IWagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WagerService {
    @Autowired
    IWagerRepository repository;

    public void add(Wager wager) {
        repository.save(wager);
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<Wager> getBets() {
        return (List<Wager>) repository.findAll();
    }
}