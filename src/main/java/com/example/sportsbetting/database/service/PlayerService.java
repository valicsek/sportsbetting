package com.example.sportsbetting.database.service;

import com.example.sportsbetting.database.model.Player;
import com.example.sportsbetting.database.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerService {
    @Autowired
    IPlayerRepository repository;

    public void add(Player player) {
        repository.save(player);
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<Player> getPlayers() {
        return (List<Player>) repository.findAll();
    }

}