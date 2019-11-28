package com.example.sportsbetting.database.repository;

import com.example.sportsbetting.database.model.SportEvent;
import org.springframework.data.repository.CrudRepository;

public interface ISportEventRepository extends CrudRepository<SportEvent, Long> {
}
