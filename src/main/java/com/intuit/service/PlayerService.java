package com.intuit.service;


import com.intuit.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {

    Player addPlayer(Player player);

    List<Player> getAllPlayers();

    Player getPlayerById(long playerId);

    void deletePlayer(long playerId);

    Player modifyPlayer(Player player);


}
