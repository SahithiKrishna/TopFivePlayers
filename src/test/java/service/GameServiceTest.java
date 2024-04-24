package service;

public class GameServiceTest {

//    private PlayerRepository playerRepository;
//    GameServiceImpl gameServiceImpl;

//    @BeforeEach
//    public void setup(){
//        playerRepository = mock(PlayerRepository.class);
//        gameServiceImpl = new GameServiceImpl(playerRepository);
//    }
//
//    @Test
//    public void testPostGameData() throws Exception{
//        Player player = new Player("Sahiti", 32);
//        Player resultPlayer = new Player(1L,"Sahiti", 32);
//        when(playerRepository.saveAndFlush(player)).thenReturn(resultPlayer);
//        Player returnPlayer = gameServiceImpl.postGameData(player);
//        Assertions.assertNotNull(returnPlayer);
//        Assertions.assertEquals(resultPlayer.getPlayerId(),returnPlayer.getPlayerId());
//        Assertions.assertEquals(resultPlayer.getName(),returnPlayer.getName());
//        Assertions.assertEquals(resultPlayer.getScore(),returnPlayer.getScore());
//    }
//
//    @Test
//    public void testGetAllPlayers() throws Exception {
//        Player player1 = new Player(1L,"Sahiti", 32);
//        Player player2 = new Player(2L,"Supriya", 36);
//        List<Player> playerList = new ArrayList<>(Arrays.asList(player1,player2));
//        when(playerRepository.findAll()).thenReturn(playerList);
//        List<Player> resultPlayerList = gameServiceImpl.getAllPlayers();
//        Assertions.assertNotNull(resultPlayerList);
//        Assertions.assertEquals(playerList.size(),resultPlayerList.size());
//        Assertions.assertEquals(playerList,resultPlayerList);
//    }
//
//    @Test
//    public void testPlayerDataById() throws Exception {
//        Long playerId = 1L;
//        Player player = new Player(playerId,"Sahiti", 32);
//        when(playerRepository.findById(playerId)).thenReturn(Optional.of(player));
//        Player resultPlayer = gameServiceImpl.getPlayerById(playerId);
//        Assertions.assertNotNull(resultPlayer);
//        Assertions.assertEquals(player.getPlayerId(),resultPlayer.getPlayerId());
//        Assertions.assertEquals(player.getName(),resultPlayer.getName());
//        Assertions.assertEquals(player.getScore(),resultPlayer.getScore());
//    }
//
//    @Test
//    public void testDeletePlayer() {
//        long playerId = 1L;
//        gameServiceImpl.deletePlayer(playerId);
//        verify(playerRepository).deleteById(playerId);
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
//        List<Player> allPlayers = new ArrayList<>(Arrays.asList(player1,player2,player3,player4,player5,player6));
//        List<Player> topFivePlayers = new ArrayList<>(Arrays.asList(player6,player5,player4,player3,player1));
//        when(playerRepository.findAll()).thenReturn(allPlayers);
//        List<Player> resultTopFivePlayers = gameServiceImpl.getTopFivePlayers();
//        Assertions.assertNotNull(resultTopFivePlayers);
//        Assertions.assertEquals(resultTopFivePlayers.size(), 5);
//        Assertions.assertEquals(resultTopFivePlayers, topFivePlayers);
//    }
}
