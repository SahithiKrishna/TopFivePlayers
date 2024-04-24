package controller;

public class GameControllerTest {

//    private GameService gameService;
//    private GameController gameController;
//
//    @BeforeEach
//    public void setup(){
//        gameService = mock(GameService.class);
//        gameController = new GameController(gameService);
//    }
//
//    @Test
//    public void testNewPlayerEntry() throws Exception {
//        Player player = new Player(1L,"Sahiti", 32);
//        when(gameService.postGameData(player)).thenReturn(new Player(1L,"Sahiti",32));
//        Player resultPlayer = gameController.newPlayerEntry(player);
//        Assertions.assertNotNull(resultPlayer);
//        Assertions.assertEquals(player.getPlayerId(),resultPlayer.getPlayerId());
//        Assertions.assertEquals(player.getName(),resultPlayer.getName());
//        Assertions.assertEquals(player.getScore(),resultPlayer.getScore());
//    }
//
//    @Test
//    public void testGetAllPlayers() throws Exception {
//        Player player1 = new Player(1L,"Sahiti", 32);
//        Player player2 = new Player(2L,"Supriya", 36);
//        List<Player> playerList = new ArrayList<>(Arrays.asList(player1,player2));
//        when(gameService.getAllPlayers()).thenReturn(playerList);
//        List<Player> resultPlayerList = gameController.getAllPlayers();
//        Assertions.assertNotNull(resultPlayerList);
//        Assertions.assertEquals(playerList.size(),resultPlayerList.size());
//        Assertions.assertEquals(playerList,resultPlayerList);
//    }
//
//    @Test
//    public void testPlayerDataById() throws Exception {
//        Long playerId = 1L;
//        Player player = new Player(playerId,"Sahiti", 32);
//        when(gameService.getPlayerById(playerId)).thenReturn(player);
//        Player resultPlayer = gameController.playerDataById(playerId);
//        Assertions.assertNotNull(resultPlayer);
//        Assertions.assertEquals(player.getPlayerId(),resultPlayer.getPlayerId());
//        Assertions.assertEquals(player.getName(),resultPlayer.getName());
//        Assertions.assertEquals(player.getScore(),resultPlayer.getScore());
//    }
//
//    @Test
//    public void testDeletePlayer() throws Exception {
//        long playerId = 1L;
//        gameController.deletePlayer(playerId);
//        verify(gameService).deletePlayer(playerId);
//    }
//
//    @Test
//    public void testTopFivePlayers() throws Exception {
//        Player player1 = new Player(1L,"Sahiti", 32);
//        Player player2 = new Player(2L,"Supriya", 24);
//        Player player3 = new Player(3L,"Indu", 35);
//        Player player4 = new Player(4L,"Preethi", 37);
//        Player player5 = new Player(5L,"Dharani", 38);
//        Player player6 = new Player(6L,"Vaishu", 39);
//        List<Player> topFivePlayers = new ArrayList<>(Arrays.asList(player6,player5,player4,player3,player1));
//        when(gameService.getTopFivePlayers()).thenReturn(topFivePlayers);
//        List<Player> resultTopFivePlayers = gameController.topFivePlayers();
//        Assertions.assertNotNull(resultTopFivePlayers);
//        Assertions.assertEquals(resultTopFivePlayers.size(), 5);
//        Assertions.assertEquals(resultTopFivePlayers, topFivePlayers);
//    }
}
