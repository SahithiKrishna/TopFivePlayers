package controller;

import com.intuit.controller.GamesPlayedController;
import com.intuit.dto.PlayerList;
import com.intuit.entity.GamesPlayed;
import com.intuit.service.GamesPlayedService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GamePlayedControllerTest {

    private GamesPlayedController gamesPlayedController;
    private GamesPlayedService gamesPlayedService;

    @BeforeEach
    public void setup(){
        gamesPlayedService = mock(GamesPlayedService.class);
        gamesPlayedController = new GamesPlayedController(gamesPlayedService);
    }

    @Test
    public void testNewPlayerEntry() throws Exception {
        GamesPlayed inputGamesPlayed = new GamesPlayed(2L,3L,32);
        GamesPlayed resultGamesPlayed = new GamesPlayed(1L,2L,3L,32);
        when(gamesPlayedService.addNewGamePlayed(inputGamesPlayed)).thenReturn(resultGamesPlayed);
        GamesPlayed retunedGamesPlayed = gamesPlayedController.newGamePlayedEntry(inputGamesPlayed);
        Assertions.assertNotNull(retunedGamesPlayed);
        Assertions.assertEquals(retunedGamesPlayed.getPlayerId(),resultGamesPlayed.getPlayerId());
        Assertions.assertEquals(retunedGamesPlayed.getGameId(),resultGamesPlayed.getGameId());
        Assertions.assertEquals(retunedGamesPlayed.getScore(),resultGamesPlayed.getScore());
    }

    @Test
    public void testGameDataByPlayerId() throws Exception {
        Long playerID = 2L;
        GamesPlayed gamesPlayed1 = new GamesPlayed(playerID,3L,32);
        GamesPlayed gamesPlayed2 = new GamesPlayed(playerID,5L,45);
        List<GamesPlayed> gamesPlayedList = new ArrayList<>(Arrays.asList(gamesPlayed1,gamesPlayed2));
        when(gamesPlayedService.getAllGameForPlayerId(playerID)).thenReturn(gamesPlayedList);
        List<GamesPlayed> resultGamesPlayed = gamesPlayedController.gameDataByPlayerId(playerID);
        Assertions.assertNotNull(resultGamesPlayed);
        Assertions.assertEquals(gamesPlayedList.size(),resultGamesPlayed.size());
        Assertions.assertEquals(gamesPlayedList,resultGamesPlayed);
    }

    @Test
    public void testPlayerDataByGameId() throws Exception {
        Long playerId = 1L;
        GamesPlayed gamesPlayed1 = new GamesPlayed(1L,2L,32);
        GamesPlayed gamesPlayed2 = new GamesPlayed(2L,2L,45);
        List<GamesPlayed> gamesPlayedList = new ArrayList<>(Arrays.asList(gamesPlayed1,gamesPlayed2));
        when(gamesPlayedService.getAllPlayerByGameId(2L)).thenReturn(gamesPlayedList);
        List<GamesPlayed> resultGamesPlayed = gamesPlayedController.playerDataByGameId(2L);
        Assertions.assertNotNull(resultGamesPlayed);
        Assertions.assertEquals(gamesPlayedList.size(),resultGamesPlayed.size());
        Assertions.assertEquals(gamesPlayedList,resultGamesPlayed);
    }

    @Test
    public void testModifyPlayerData() throws Exception {
        GamesPlayed gamesPlayed = new GamesPlayed(1L,2L,32);
        when(gamesPlayedService.updateScoreByPlayerId(gamesPlayed)).thenReturn(gamesPlayed);
        GamesPlayed resultGamesPlayed = gamesPlayedController.modifyPlayerData(gamesPlayed);
        Assertions.assertNotNull(resultGamesPlayed);
        Assertions.assertEquals(resultGamesPlayed.getPlayerId(), gamesPlayed.getPlayerId());
        Assertions.assertEquals(resultGamesPlayed.getGameId(), gamesPlayed.getGameId());
        Assertions.assertEquals(resultGamesPlayed.getScore(), gamesPlayed.getScore());
    }

    @Test
    public void testGetTop5PlayerData() throws Exception {
        PlayerList gamesPlayed1 = new PlayerList("Sahithi",32);
        PlayerList gamesPlayed2 = new PlayerList("Supriya",45);
        PlayerList gamesPlayed3 = new PlayerList("Rohit",55);
        PlayerList gamesPlayed4 = new PlayerList("laddu",65);
        PlayerList gamesPlayed5 = new PlayerList("Harish",75);
        PlayerList gamesPlayed6 = new PlayerList("Suguna",85);
        List<PlayerList> top5PlayerData = new ArrayList<>(Arrays.asList(gamesPlayed1,gamesPlayed2,gamesPlayed3,gamesPlayed4,gamesPlayed5));
        when(gamesPlayedService.getTopFiveForGivenGame(3L)).thenReturn(top5PlayerData);
        List<PlayerList> top5Players = gamesPlayedController.getTop5PlayerData(3L);
        Assertions.assertNotNull(top5Players);
        Assertions.assertEquals(top5Players.size(), top5PlayerData.size());
    }
}
