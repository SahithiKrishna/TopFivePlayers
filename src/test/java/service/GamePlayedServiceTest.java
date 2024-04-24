package service;

import com.intuit.dto.PlayerList;
import com.intuit.entity.Game;
import com.intuit.entity.GamesPlayed;
import com.intuit.entity.Player;
import com.intuit.repository.GameRepository;
import com.intuit.repository.GamesPlayedRepository;
import com.intuit.repository.PlayerRepository;
import com.intuit.service.GamePlayedServiceImpl;
import com.intuit.service.GamesPlayedService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class GamePlayedServiceTest {

    private GamesPlayedRepository gamesPlayedRepository;
    private PlayerRepository playerRepository;
    private GameRepository gameRepository;
    private GamesPlayedService gamesPlayedService;

    @BeforeEach
    public void setup(){
        playerRepository = mock(PlayerRepository.class);
        gameRepository = mock(GameRepository.class);
        gamesPlayedRepository = mock(GamesPlayedRepository.class);
        gamesPlayedService = new GamePlayedServiceImpl(gamesPlayedRepository,playerRepository,gameRepository);
    }

    @Test
    public void testGetAllPlayerByGameId() throws Exception {
        GamesPlayed gamesPlayed1 = new GamesPlayed(1L,2L,3L,32);
        GamesPlayed gamesPlayed2 = new GamesPlayed(2L,1L,3L,36);
        GamesPlayed gamesPlayed3 = new GamesPlayed(3L,4L,3L,34);
        List<GamesPlayed> resultGamesPlayed = new ArrayList<>(Arrays.asList(gamesPlayed1,gamesPlayed2,gamesPlayed3));
        when(gamesPlayedRepository.findByGameId(3L)).thenReturn(resultGamesPlayed);
        List<GamesPlayed> retunedGamesPlayed = gamesPlayedService.getAllPlayerByGameId(3L);
        Assertions.assertNotNull(retunedGamesPlayed);
        Assertions.assertEquals(retunedGamesPlayed.size(),resultGamesPlayed.size());
    }

    @Test
    public void testGetAllGameForPlayerId() throws Exception {
        Long playerID = 2L;
        GamesPlayed gamesPlayed1 = new GamesPlayed(1L,playerID,3L,32);
        GamesPlayed gamesPlayed2 = new GamesPlayed(2L,playerID,3L,32);
        GamesPlayed gamesPlayed3 = new GamesPlayed(3L,4L,5L,45);
        List<GamesPlayed> gamesPlayedList = new ArrayList<>(Arrays.asList(gamesPlayed1,gamesPlayed2));
        when(gamesPlayedRepository.findByPlayerId(playerID)).thenReturn(gamesPlayedList);
        List<GamesPlayed> resultGamesPlayed = gamesPlayedService.getAllGameForPlayerId(playerID);
        Assertions.assertNotNull(resultGamesPlayed);
        Assertions.assertEquals(gamesPlayedList.size(),resultGamesPlayed.size());
        Assertions.assertEquals(gamesPlayedList,resultGamesPlayed);
    }

    @Test
    public void testAddNewGamePlayed() throws Exception {
        GamesPlayed gamesPlayed = new GamesPlayed(1L,1L,2L,32);
        when(gamesPlayedRepository.saveAndFlush(gamesPlayed)).thenReturn(gamesPlayed);
        when(playerRepository.findById(1L)).thenReturn(Optional.of(new Player(1L, "Sahithi")));
        when(gameRepository.findById(2L)).thenReturn(Optional.of(new Game(1L, "PUBG", "Don't play its bad")));
        GamesPlayed resultGamesPlayed = gamesPlayedService.addNewGamePlayed(gamesPlayed);
        Assertions.assertNotNull(resultGamesPlayed);
        Assertions.assertEquals(gamesPlayed.getGameId(),resultGamesPlayed.getGameId());
        Assertions.assertEquals(gamesPlayed.getPlayerId(),resultGamesPlayed.getPlayerId());
        Assertions.assertEquals(gamesPlayed.getScore(),resultGamesPlayed.getScore());
    }

    @Test
    public void testUpdateScoreByPlayerId() throws Exception {
        GamesPlayed gamesPlayed = new GamesPlayed(1L,1L,2L,32);
        when(gamesPlayedRepository.findById(1L)).thenReturn(Optional.of(gamesPlayed));
        when(gamesPlayedRepository.saveAndFlush(gamesPlayed)).thenReturn(gamesPlayed);
        GamesPlayed resultGamesPlayed = gamesPlayedService.updateScoreByPlayerId(gamesPlayed);
        Assertions.assertNotNull(resultGamesPlayed);
        Assertions.assertEquals(resultGamesPlayed.getPlayerId(), gamesPlayed.getPlayerId());
        Assertions.assertEquals(resultGamesPlayed.getGameId(), gamesPlayed.getGameId());
        Assertions.assertEquals(resultGamesPlayed.getScore(), gamesPlayed.getScore());
    }

    @Test
    public void testGetTop5PlayerData() throws Exception {
        GamesPlayed gamesPlayed1 = new GamesPlayed(1L,2L,3L,32);
        GamesPlayed gamesPlayed2 = new GamesPlayed(2L,3L,3L,33);
        GamesPlayed gamesPlayed3 = new GamesPlayed(3L,4L,3L,34);
        GamesPlayed gamesPlayed4 = new GamesPlayed(4L,5L,3L,35);
        GamesPlayed gamesPlayed5 = new GamesPlayed(5L,6L,3L,36);
        GamesPlayed gamesPlayed6 = new GamesPlayed(6L,7L,3L,30);
        PlayerList playerList1 = new PlayerList("Sahithi",32);
        PlayerList playerList2 = new PlayerList("Supriya",45);
        PlayerList playerList3 = new PlayerList("Rohit",55);
        PlayerList playerList4 = new PlayerList("laddu",65);
        PlayerList playerList5 = new PlayerList("Harish",75);
        PlayerList playerList6 = new PlayerList("Suguna",85);
        List<GamesPlayed> allPlayerSameGame = new ArrayList<>(Arrays.asList(gamesPlayed1,gamesPlayed2,gamesPlayed3,gamesPlayed4,gamesPlayed5, gamesPlayed6));
        List<PlayerList> top5PlayerData = new ArrayList<>(Arrays.asList(playerList1,playerList2,playerList3,playerList4,playerList5));
        when(gamesPlayedRepository.findByGameId(anyLong())).thenReturn(allPlayerSameGame);
        when(gamesPlayedRepository.findAllByPlayerId(any(),any())).thenReturn(top5PlayerData);
        List<PlayerList> resultTop5Players = gamesPlayedService.getTopFiveForGivenGame(3L);
        Assertions.assertNotNull(resultTop5Players);
        Assertions.assertEquals(resultTop5Players.size(), top5PlayerData.size());
    }
}
