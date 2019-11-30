package com.example.sportsbetting.database.service;

import com.example.sportsbetting.database.model.TennisSportEvent;
import com.example.sportsbetting.database.repository.ITennisSportEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TennisSportEventService {
    @Autowired
    ITennisSportEventRepository repository;

    public void add(TennisSportEvent tennisSportEvent) {
        repository.save(tennisSportEvent);
    }
    public void delete(int id) {
        repository.deleteById(id);
    }
    public List<TennisSportEvent> getTennisSportEvents() {
        return (List<TennisSportEvent>) repository.findAll();
    }
}