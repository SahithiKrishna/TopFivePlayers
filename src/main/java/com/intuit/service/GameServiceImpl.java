package com.intuit.service;

import com.intuit.entity.Game;
import com.intuit.repository.GameRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@Slf4j
@AllArgsConstructor
public class GameServiceImpl implements GameService{

    @Autowired
    private GameRepository gameRepository;

    public Game postNewGame(Game game) {
        return gameRepository.saveAndFlush(game);
    }

    @Cacheable(value = "games")
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Cacheable(value = "games", key = "#gameId")
    public Game getGameById(long gameId) throws NoSuchElementException {
        return gameRepository.findById(gameId).orElseThrow();
    }


    @CacheEvict(value = "games", key = "#gameId")
    public void deleteGame(long gameId) throws IllegalArgumentException {
        gameRepository.deleteById(gameId);
    }



    @CachePut(value = "games", key = "#game.id")
    public Game modifyGame(Game updatedGameData) {
        Game existingGame = gameRepository.findById(updatedGameData.getGameId())
                .orElseThrow(() -> new NoSuchElementException("Game not found"));

        existingGame.setGameName(updatedGameData.getGameName());
        existingGame.setDescription(updatedGameData.getDescription());

        return gameRepository.save(existingGame);
    }

}

