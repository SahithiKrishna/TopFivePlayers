package com.intuit.service;

import com.intuit.dto.PlayerList;
import com.intuit.entity.GamesPlayed;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public interface GamesPlayedService {

    List<GamesPlayed> getAllPlayerByGameId(long gameId);
    List<GamesPlayed> getAllGameForPlayerId(long playerId);
    List<PlayerList> getTopFiveForGivenGame(long gameId) throws IOException;

    GamesPlayed addNewGamePlayed(GamesPlayed gamesPlayed) throws NoSuchElementException;
    GamesPlayed updateScoreByPlayerId(GamesPlayed gamesPlayed) throws NoSuchElementException;
}
