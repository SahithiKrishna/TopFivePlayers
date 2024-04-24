package controller;

import com.intuit.controller.GameController;
import com.intuit.entity.Game;
import com.intuit.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class GameControllerTest {

    private GameService gameService;
    private GameController gameController;

    @BeforeEach
    public void setup(){
        gameService = mock(GameService.class);
        gameController = new GameController(gameService);
    }

    @Test
    public void testNewGameEntry() throws Exception {
        Game game = new Game(1L,"PUBG", "100 players play it at a time");
        when(gameService.postNewGame(game)).thenReturn(game);
        Game resultGame = gameController.postNewGame(game);
        Assertions.assertNotNull(resultGame);
        Assertions.assertEquals(game.getGameId(),resultGame.getGameId());
        Assertions.assertEquals(game.getGameName(),resultGame.getGameName());
        Assertions.assertEquals(game.getDescription(),resultGame.getDescription());
    }

    @Test
    public void testGetAllGame() throws Exception {
        Game game1 = new Game(1L,"PUBG", "100 players play it at a time");
        Game game2 = new Game(2L,"FIFA", "PLAY AT PS5");
        List<Game> gameList = new ArrayList<>(Arrays.asList(game1,game2));
        when(gameService.getAllGames()).thenReturn(gameList);
        List<Game> resultGameList = gameController.getAllGames();
        Assertions.assertNotNull(resultGameList);
        Assertions.assertEquals(gameList.size(),resultGameList.size());
        Assertions.assertEquals(gameList,resultGameList);
    }

    @Test
    public void testGameDataById() throws Exception {
        Long gameId = 1L;
        Game game = new Game(gameId,"PUBG","100 Players play it at a time");
        when(gameService.getGameById(gameId)).thenReturn(game);
        Game resultGame = gameController.gameDataById(gameId);
        Assertions.assertNotNull(resultGame);
        Assertions.assertEquals(game.getGameId(),resultGame.getGameId());
        Assertions.assertEquals(game.getGameName(),resultGame.getGameName());
        Assertions.assertEquals(game.getDescription(),resultGame.getDescription());
    }

    @Test
    public void testDeleteGame() throws Exception {
        long gameId = 1L;
        gameController.deleteGame(gameId);
        verify(gameService).deleteGame(gameId);
    }

    @Test
    public void testModifyPlayerData() throws Exception {
        Game updatedGame = new Game(1L, "PBUG", "Updated game");
        when(gameService.modifyGame(updatedGame)).thenReturn(updatedGame);
        Game resultGame = gameController.modifyGameData(updatedGame);
        Assertions.assertNotNull(resultGame);
        Assertions.assertEquals(resultGame.getGameId(), updatedGame.getGameId());
        Assertions.assertEquals(resultGame.getGameName(), updatedGame.getGameName());
    }
}
