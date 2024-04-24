package com.intuit.service;

import com.intuit.entity.Player;
import com.intuit.repository.PlayerRepository;
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
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerRepository playerRepository;

    public Player addPlayer(Player player) {
        return playerRepository.saveAndFlush(player);
    }

    @Cacheable(value = "players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Cacheable(value = "players", key = "#playerId")
    public Player getPlayerById(long playerId) throws NoSuchElementException {
        return playerRepository.findById(playerId).orElseThrow();
    }

    @CacheEvict(value = "players", key = "#playerId")
    public void deletePlayer(long playerId) throws IllegalArgumentException {
        playerRepository.deleteById(playerId);
    }


    @CachePut(value = "players", key = "#player.id")
    public Player modifyPlayer(Player updatedPlayerData) {
        Player existingPlayer = playerRepository.findById(updatedPlayerData.getPlayerId())
                .orElseThrow(() -> new NoSuchElementException("Player not found"));

        existingPlayer.setName(updatedPlayerData.getName());

        return playerRepository.save(existingPlayer);
    }

}

