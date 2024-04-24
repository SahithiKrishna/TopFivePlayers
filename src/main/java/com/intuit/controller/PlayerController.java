package com.intuit.controller;

import com.intuit.entity.Player;
import com.intuit.service.PlayerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("v1/player")
@Slf4j
public class PlayerController {



    //private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    private PlayerService playerService;


    @PostMapping("/player")
    public Player newPlayerEntry(@RequestBody Player playerData) throws Exception {
        log.info("Received request to add a new player entry");
        return playerService.addPlayer(playerData);
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() throws Exception {
        log.info("Received request to fetch all players");
        return playerService.getAllPlayers();
    }

    @GetMapping("players/{playerId}")
    public Player playerDataById(@PathVariable long playerId) throws Exception {
        log.info("Received request to fetch player data for player with ID: {}", playerId);
        return playerService.getPlayerById(playerId);
    }

    @PutMapping("players/{playerId}")
    public Player modifyPlayerData(@RequestBody Player playerData) throws Exception {
        log.info("Received request to modify player data for player with ID: {}", playerData.getPlayerId());
        return playerService.modifyPlayer(playerData);
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable long playerId) throws Exception {
        log.info("Received request to delete player with ID: {}", playerId);
        playerService.deletePlayer(playerId);
    }

}

