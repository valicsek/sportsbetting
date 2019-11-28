package com.example.sportsbetting.database.repository;

import com.example.sportsbetting.database.model.Wager;
import org.springframework.data.repository.CrudRepository;

public interface IWagerRepository extends CrudRepository<Wager, Long> {
}