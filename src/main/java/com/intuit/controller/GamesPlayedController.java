package com.intuit.controller;

import com.intuit.dto.PlayerList;
import com.intuit.entity.GamesPlayed;
import com.intuit.repository.GamesPlayedRepository;
import com.intuit.service.GamesPlayedService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("v1/gamesPlayed")
public class GamesPlayedController {

    @Autowired
    private GamesPlayedService gamesPlayedService;

    @Autowired
    private GamesPlayedRepository gamesPlayedRepository;


    @PostMapping("/gamePlayed")
    public GamesPlayed newGamePlayedEntry(@RequestBody GamesPlayed gamesPlayed) throws NoSuchElementException {
        log.info("Received request to add new game played entry");
        return gamesPlayedService.addNewGamePlayed(gamesPlayed);
    }

    @GetMapping("gamesPlayedbyPlayer/{playerId}")
    public List<GamesPlayed> gameDataByPlayerId(@PathVariable long playerId) {
        log.info("Received request to fetch game data for player with ID: {}", playerId);
        return gamesPlayedService.getAllGameForPlayerId(playerId);
    }

    @GetMapping("gamesPlayedbyGame/{gameId}")
    public List<GamesPlayed> playerDataByGameId(@PathVariable long gameId) {
        log.info("Received request to fetch player data for game with ID: {}", gameId);
        return gamesPlayedService.getAllPlayerByGameId(gameId);
    }

    @PutMapping("updateGamesPlayed/{playerId}")
    public GamesPlayed modifyPlayerData(@RequestBody GamesPlayed gamesPlayed) throws Exception {
        log.info("Received request to update game played entry for player with ID: {}", gamesPlayed.getPlayerId());
        return gamesPlayedService.updateScoreByPlayerId(gamesPlayed);
    }

    @GetMapping("topFivePlayers/{gameId}")
    public List<PlayerList> getTop5PlayerData(@PathVariable long gameId) throws IOException {
        log.info("Received request to fetch top 5 players for game with ID: {}", gameId);
        return gamesPlayedService.getTopFiveForGivenGame(gameId);
    }
}
