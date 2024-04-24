package service;

import com.intuit.entity.Player;
import com.intuit.repository.PlayerRepository;
import com.intuit.service.PlayerService;
import com.intuit.service.PlayerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class PlayerServiceTest {

    private PlayerRepository playerRepository;
    PlayerService playerService;

    @BeforeEach
    public void setup(){
        playerRepository = mock(PlayerRepository.class);
        playerService = new PlayerServiceImpl(playerRepository);
    }

    @Test
    public void testAddPlayer() throws Exception{
        Player player = new Player(1L,"Sahiti");
        when(playerRepository.saveAndFlush(player)).thenReturn(player);
        Player resultPlayer = playerService.addPlayer(player);
        Assertions.assertNotNull(resultPlayer);
        Assertions.assertEquals(resultPlayer.getPlayerId(),player.getPlayerId());
        Assertions.assertEquals(resultPlayer.getName(),player.getName());
    }

    @Test
    public void testGetAllPlayers() throws Exception {
        Player player1 = new Player(1L,"Sahiti");
        Player player2 = new Player(2L,"Supriya");
        List<Player> playerList = new ArrayList<>(Arrays.asList(player1,player2));
        when(playerRepository.findAll()).thenReturn(playerList);
        List<Player> resultPlayerList = playerService.getAllPlayers();
        Assertions.assertNotNull(resultPlayerList);
        Assertions.assertEquals(playerList.size(),resultPlayerList.size());
        Assertions.assertEquals(playerList,resultPlayerList);
    }

    @Test
    public void testPlayerDataById() throws Exception {
        Long playerId = 1L;
        Player player = new Player(playerId,"Sahiti");
        when(playerRepository.findById(playerId)).thenReturn(Optional.of(player));
        Player resultPlayer = playerService.getPlayerById(playerId);
        Assertions.assertNotNull(resultPlayer);
        Assertions.assertEquals(player.getPlayerId(),resultPlayer.getPlayerId());
        Assertions.assertEquals(player.getName(),resultPlayer.getName());
    }

    @Test
    public void testDeletePlayer() {
        long playerId = 1L;
        playerService.deletePlayer(playerId);
        verify(playerRepository).deleteById(playerId);
    }

    @Test
    public void testModifyPlayerData() throws Exception {
        Player player = new Player(1L,"Sahiti");
        Player updatedPlayer = new Player(1L,"Supriya");
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player));
        when(playerRepository.save(player)).thenReturn(updatedPlayer);
        Player resultGame = playerService.modifyPlayer(updatedPlayer);
        Assertions.assertNotNull(resultGame);
        Assertions.assertEquals(resultGame.getName(), updatedPlayer.getName());
        Assertions.assertEquals(resultGame.getPlayerId(), updatedPlayer.getPlayerId());
    }
}
