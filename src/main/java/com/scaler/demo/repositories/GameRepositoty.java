package com.scaler.demo.repositories;

import com.scaler.demo.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepositoty extends JpaRepository<Game,Long> {
}
