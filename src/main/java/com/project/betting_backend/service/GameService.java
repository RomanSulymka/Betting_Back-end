package com.project.betting_backend.service;

import com.project.betting_backend.domain.Game;

import java.util.List;

public interface GameService {
    Game createNewGame(Game game);
    Game updateGameInfo(Game game);
    void deleteGame(Long id);
    Game getGameById(Long id);
    List<Game> getAllGames();
}
