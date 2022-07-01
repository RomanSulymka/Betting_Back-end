package com.project.betting_backend.repository;

import com.project.betting_backend.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Integer> {
    void deleteById(Long id);
    Optional<Game> getGameById(Long id);

}
