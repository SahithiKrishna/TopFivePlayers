package com.intuit.repository;

import com.intuit.dto.PlayerList;
import com.intuit.entity.GamesPlayed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author 
 * JPA repository query class
 * Repository is a mechanism for encapsulating storage, retrieval, and search behavior which emulates
 * a collection of objects
 */
@Repository
public interface GamesPlayedRepository extends JpaRepository<GamesPlayed, Long>{

    @Query("SELECT gp from GamesPlayed gp JOIN Player p ON gp.playerId = p.id WHERE gp.gameId= ?1")
    List<GamesPlayed> findByGameId(long gameId);

    @Query("SELECT gp from GamesPlayed gp JOIN Game g ON gp.gameId = g.gameId WHERE gp.playerId = ?1")
    List<GamesPlayed> findByPlayerId(long playerId);

    @Query("SELECT new com.intuit.dto.PlayerList(p.name, gp.score) FROM GamesPlayed gp JOIN Player p ON gp.playerId = p.id WHERE gp.playerId in (?1) and gp.gameId = ?2")
    List<PlayerList> findAllByPlayerId(List<Long> playerIds, Long gameId);
}
