package com.example.sportsbetting.database.service;

import com.example.sportsbetting.database.model.SportEvent;
import com.example.sportsbetting.database.repository.ISportEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SportEventService {
    @Autowired
    ISportEventRepository repository;

    public void add(SportEvent sportEvent) {
        repository.save(sportEvent);
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<SportEvent> getBets() {
        return (List<SportEvent>) repository.findAll();
    }
}