package com.example.sportsbetting.database.service;

import com.example.sportsbetting.database.model.Player;
import com.example.sportsbetting.database.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class PlayerService {
    @Autowired
    IPlayerRepository repository;

    public void add(Player player) {
        repository.save(player);
    }

    public void save(Player player) {
        repository.save(player);
    }
    public void delete(int id) {
        repository.deleteById(id);
    }
    public List<Player> getPlayers() {
        return (List<Player>) repository.findAll();
    }
    public Player getPlayerById(int id) {
        Optional<Player> optionalPlayer = repository.findById(id);
        return optionalPlayer.orElseThrow();
    }
    public Player getPlayerByEmail(String email) {
        return repository.findByEmail(email);
    }
}