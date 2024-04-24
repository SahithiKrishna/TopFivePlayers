package service;

import com.intuit.entity.Game;
import com.intuit.repository.GameRepository;
import com.intuit.service.GameServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class GameServiceTest {


    private GameServiceImpl gameServiceImpl;
    private GameRepository gameRepository;

    @BeforeEach
    public void setup(){
        gameRepository = mock(GameRepository.class);
        gameServiceImpl = new GameServiceImpl(gameRepository);
    }

    @Test
    public void testPostGameData() throws Exception{
        Game game = new Game(1L,"PUBG", "100 players play it at a time");
        when(gameRepository.saveAndFlush(game)).thenReturn(game);
        Game resultGame = gameServiceImpl.postNewGame(game);
        Assertions.assertNotNull(resultGame);
        Assertions.assertEquals(game.getGameId(),resultGame.getGameId());
        Assertions.assertEquals(game.getGameName(),resultGame.getGameName());
        Assertions.assertEquals(game.getDescription(),resultGame.getDescription());
    }

    @Test
    public void testGetAllPlayers() throws Exception {
        Game game1 = new Game(1L,"PUBG", "100 players play it at a time");
        Game game2 = new Game(2L,"FIFA", "PLAY AT PS5");
        List<Game> gameList = new ArrayList<>(Arrays.asList(game1,game2));
        when(gameRepository.findAll()).thenReturn(gameList);
        List<Game> resultGameList = gameServiceImpl.getAllGames();
        Assertions.assertNotNull(resultGameList);
        Assertions.assertEquals(gameList.size(),resultGameList.size());
        Assertions.assertEquals(gameList,resultGameList);
    }

    @Test
    public void testPlayerDataById() throws Exception {
        Long gameId = 1L;
        Game game = new Game(gameId,"PUBG","100 Players play it at a time");
        when(gameRepository.findById(gameId)).thenReturn(Optional.of(game));
        Game resultGame = gameServiceImpl.getGameById(gameId);
        Assertions.assertNotNull(resultGame);
        Assertions.assertEquals(game.getGameId(),resultGame.getGameId());
        Assertions.assertEquals(game.getGameName(),resultGame.getGameName());
        Assertions.assertEquals(game.getDescription(),resultGame.getDescription());
    }

    @Test
    public void testDeletePlayer() {
        long gameId = 1L;
        gameServiceImpl.deleteGame(gameId);
        verify(gameRepository).deleteById(gameId);
    }

    @Test
    public void testModifyPlayerData() throws Exception {
        Game game = new Game(1L, "PBUG", "game");
        Game updatedgame = new Game(1L, "new PBUG", "updated game");
        when(gameRepository.findById(1L)).thenReturn(Optional.of(game));
        when(gameRepository.save(game)).thenReturn(updatedgame);
        Game resultGame = gameServiceImpl.modifyGame(updatedgame);
        Assertions.assertNotNull(resultGame);
        Assertions.assertEquals(resultGame.getGameId(), updatedgame.getGameId());
        Assertions.assertEquals(resultGame.getGameName(), updatedgame.getGameName());
        Assertions.assertEquals(resultGame.getDescription(), updatedgame.getDescription());
    }
}
