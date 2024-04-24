package com.intuit.controller;

import com.intuit.entity.Game;
import com.intuit.service.GameService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("v1/game")
@Slf4j
public class GameController {

    @Autowired
    private GameService gameService;


    @PostMapping("/game")
    public Game postNewGame(@RequestBody Game game) throws Exception {
        log.info("Received request to add a new game");
        return gameService.postNewGame(game);
    }

    @GetMapping("/games")
    public List<Game> getAllGames() throws Exception {
        log.info("Received request to fetch all games");
        return gameService.getAllGames();
    }

    @GetMapping("games/{gameId}")
    public Game gameDataById(@PathVariable long gameId) throws Exception {
        log.info("Received request to fetch game data for game with ID: {}", gameId);
        return gameService.getGameById(gameId);
    }

    @PutMapping("games/{gameId}")
    public Game modifyPlayerData(@RequestBody Game game) throws Exception {
        log.info("Received request to modify game data for game with ID: {}", game.getGameId());
        return gameService.modifyGame(game);
    }

    @DeleteMapping("/games/{gameId}")
    public void deletePlayer(@PathVariable long gameId) throws Exception {
        log.info("Received request to delete game with ID: {}", gameId);
        gameService.deleteGame(gameId);
    }

}

