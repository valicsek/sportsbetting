package com.example.sportsbetting.database.service;

import com.example.sportsbetting.database.model.Result;
import com.example.sportsbetting.database.repository.IResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResultService {
    @Autowired
    IResultRepository repository;

    public void add(Result result) {
        repository.save(result);
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<Result> getBets() {
        return (List<Result>) repository.findAll();
    }
}