package com.example.sportsbetting.database.service;

import com.example.sportsbetting.database.model.FootballSportEvent;
import com.example.sportsbetting.database.repository.IFootballSportEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class FootballSportEventService {
    @Autowired
    IFootballSportEventRepository repository;

    public void add(FootballSportEvent FootballSportEvent) {
        repository.save(FootballSportEvent);
    }
    public void delete(int id) {
        repository.deleteById(id);
    }
    public List<FootballSportEvent> getFootballSportEvents() {
        return (List<FootballSportEvent>) repository.findAll();
    }
}