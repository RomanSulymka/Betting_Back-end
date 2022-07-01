package com.project.betting_backend.service.impl;

import com.project.betting_backend.domain.Game;
import com.project.betting_backend.exceptions.NullEntityReferenceException;
import com.project.betting_backend.repository.GameRepository;
import com.project.betting_backend.service.GameService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    @Override
    public Game createNewGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game updateGameInfo(Game game) {
        if (game != null) {
            Game oldGame = getGameById(game.getId());
            if (oldGame != null) {
                return gameRepository.save(game);
            }
        }
        throw new NullEntityReferenceException("Game can`t be null");
    }

    @Override
    public void deleteGame(Long id) {
        Game game = getGameById(id);
        if (game != null) {
            gameRepository.deleteById(id);
        } else {
            throw new NullEntityReferenceException("Game with id: " + id + " was not found");
        }
    }

    @Override
    public Game getGameById(Long id) {
        return gameRepository.getGameById(id)
                .orElseThrow(() -> new NullEntityReferenceException("Game with id: " + id + " was not found"));
    }

    @Override
    public List<Game> getAllGames() {
        List<Game> games = gameRepository.findAll();
        return games.isEmpty() ? new ArrayList<>() : games;
    }
}
