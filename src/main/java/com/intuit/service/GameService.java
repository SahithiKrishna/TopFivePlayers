package com.intuit.service;


import com.intuit.entity.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameService {

    Game postNewGame(Game game);

    List<Game> getAllGames();

    Game getGameById(long gameId);

    void deleteGame(long gameId);

    Game modifyGame(Game game);


}
