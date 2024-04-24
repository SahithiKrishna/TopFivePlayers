package controller;

import com.intuit.controller.PlayerController;
import com.intuit.entity.Player;
import com.intuit.service.PlayerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class PlayerControllerTest {

    private PlayerService playerService;
    private PlayerController playerController;

    @BeforeEach
    public void setup(){
        playerService = mock(PlayerService.class);
        playerController = new PlayerController(playerService);
    }

    @Test
    public void testNewPlayerEntry() throws Exception {
        Player player = new Player(1L,"Sahithi");
        when(playerService.addPlayer(player)).thenReturn(player);
        Player addedPLayer = playerController.newPlayerEntry(player);
        Assertions.assertNotNull(addedPLayer);
        Assertions.assertEquals(player.getPlayerId(),addedPLayer.getPlayerId());
        Assertions.assertEquals(player.getName(),addedPLayer.getName());
    }

    @Test
    public void testGetAllPlayer() throws Exception {
        Player player1 = new Player(1L,"Sahithi");
        Player player2 = new Player(2L,"Supriya");
        List<Player> playerList = new ArrayList<>(Arrays.asList(player1,player2));
        when(playerService.getAllPlayers()).thenReturn(playerList);
        List<Player> resultPlayerList = playerController.getAllPlayers();
        Assertions.assertNotNull(resultPlayerList);
        Assertions.assertEquals(playerList.size(),resultPlayerList.size());
        Assertions.assertEquals(playerList,resultPlayerList);
    }

    @Test
    public void testPlayerDataById() throws Exception {
        Long playerId = 1L;
        Player player = new Player(playerId,"Sahithi");
        when(playerService.getPlayerById(playerId)).thenReturn(player);
        Player resultGame = playerController.playerDataById(playerId);
        Assertions.assertNotNull(resultGame);
        Assertions.assertEquals(player.getName(),resultGame.getName());
        Assertions.assertEquals(player.getPlayerId(),resultGame.getPlayerId());
    }

    @Test
    public void testDeletePlayer() throws Exception {
        long gameId = 1L;
        playerController.deletePlayer(gameId);
        verify(playerService).deletePlayer(gameId);
    }

    @Test
    public void testModifyPlayerData() throws Exception {
        Player updatedPlayer = new Player(1L, "Sahithi");
        when(playerService.modifyPlayer(updatedPlayer)).thenReturn(updatedPlayer);
        Player resultPlayer = playerController.modifyPlayerData(updatedPlayer);
        Assertions.assertNotNull(resultPlayer);
        Assertions.assertEquals(resultPlayer.getPlayerId(), updatedPlayer.getPlayerId());
        Assertions.assertEquals(resultPlayer.getName(), updatedPlayer.getName());
    }
}
