package com.intuit.service;

import com.intuit.dto.PlayerList;
import com.intuit.entity.GamesPlayed;
import com.intuit.repository.GameRepository;
import com.intuit.repository.GamesPlayedRepository;
import com.intuit.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

@Component
@AllArgsConstructor
@Slf4j
public class GamePlayedServiceImpl implements GamesPlayedService {

    @Autowired
    private GamesPlayedRepository gamesPlayedRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;

    public List<GamesPlayed> getAllPlayerByGameId(long gameId) {
        List<GamesPlayed> players = gamesPlayedRepository.findByGameId(gameId);
        log.info("Fetched {} players for game with ID: {}", players.size(), gameId);
        return players;
    }

    public List<GamesPlayed> getAllGameForPlayerId(long playerId) {
        List<GamesPlayed> games = gamesPlayedRepository.findByPlayerId(playerId);
        log.info("Fetched {} games for player with ID: {}", games.size(), playerId);
        return games;
    }

    public List<PlayerList> getTopFiveForGivenGame(long gameId) throws IOException {
        List<GamesPlayed> gamesPlayedList = gamesPlayedRepository.findByGameId(gameId);
        PriorityQueue<GamesPlayed> priorityQueue = new PriorityQueue<>(gamesPlayedList.size(), (p1, p2) -> p1.getScore() >= p2.getScore() ? -1 : 1);
        priorityQueue.addAll(gamesPlayedList);

        List<Long> topPlayers = new ArrayList<>();
        while (!priorityQueue.isEmpty() && topPlayers.size() < 5) {
            topPlayers.add(priorityQueue.poll().getPlayerId());
        }
        log.info("top 5 players: {}",topPlayers);
        List<PlayerList> topFivePlayers = gamesPlayedRepository.findAllByPlayerId(topPlayers,gameId);
        log.info("Fetched top five players for game with ID: {}, Players: {}", gameId, topFivePlayers);

        BufferedWriter f_writer
                = new BufferedWriter(new FileWriter(
                "C:/Users/sahit/Desktop/Top5Players.txt"));

        for(PlayerList player : topFivePlayers) {
            f_writer.write("\n"+player.getPlayerName()+" "+player.getScore());
        }

        f_writer.close();
        return topFivePlayers;
    }

    @Override
    public GamesPlayed addNewGamePlayed(GamesPlayed gamesPlayed) throws  NoSuchElementException {
        playerRepository.findById(gamesPlayed.getPlayerId()).orElseThrow(()-> new NoSuchElementException("Player Not Found"));//Validating to see if there exists such player
        gameRepository.findById(gamesPlayed.getGameId()).orElseThrow(()-> new NoSuchElementException("Game Not Found")); //Validating to see tf the game exists
        GamesPlayed newGamePlayed = gamesPlayedRepository.saveAndFlush(gamesPlayed);
        log.info("Added new game played entry: {}", newGamePlayed);
        return newGamePlayed;
    }

    @Override
    public GamesPlayed updateScoreByPlayerId(GamesPlayed gamesPlayed) {
        GamesPlayed existingPlayer = gamesPlayedRepository.findById(gamesPlayed.getId())
                .orElseThrow(() -> new NoSuchElementException("Player not found"));

        existingPlayer.setScore(gamesPlayed.getScore());

        log.info("Updated game played entry: {}", gamesPlayed);
        return gamesPlayedRepository.saveAndFlush(existingPlayer);
    }
}

