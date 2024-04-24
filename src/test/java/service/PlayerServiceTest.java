package service;

public class PlayerServiceTest {

//    private PlayerRepository playerRepository;
//    PlayerService playerService;
//
//    @BeforeEach
//    public void setup(){
//        playerRepository = mock(PlayerRepository.class);
//        playerService = new PlayerServiceImpl(playerRepository);
//    }
//
//    @Test
//    public void testAddPlayer() throws Exception{
//        Player player = new Player(1L,"Sahiti");
//        when(playerRepository.saveAndFlush(player)).thenReturn(player);
//        Player resultPlayer = playerService.addPlayer(player);
//        Assertions.assertNotNull(resultPlayer);
//        Assertions.assertEquals(resultPlayer.getPlayerId(),player.getPlayerId());
//        Assertions.assertEquals(resultPlayer.getName(),player.getName());
//    }
//
//    @Test
//    public void testGetAllPlayers() throws Exception {
//        Player player1 = new Player(1L,"Sahiti");
//        Player player2 = new Player(2L,"Supriya");
//        List<Player> playerList = new ArrayList<>(Arrays.asList(player1,player2));
//        when(playerRepository.findAll()).thenReturn(playerList);
//        List<Player> resultPlayerList = playerService.getAllPlayers();
//        Assertions.assertNotNull(resultPlayerList);
//        Assertions.assertEquals(playerList.size(),resultPlayerList.size());
//        Assertions.assertEquals(playerList,resultPlayerList);
//    }
//
//    @Test
//    public void testPlayerDataById() throws Exception {
//        Long playerId = 1L;
//        Player player = new Player(playerId,"Sahiti");
//        when(playerRepository.findById(playerId)).thenReturn(Optional.of(player));
//        Player resultPlayer = playerService.getPlayerById(playerId);
//        Assertions.assertNotNull(resultPlayer);
//        Assertions.assertEquals(player.getPlayerId(),resultPlayer.getPlayerId());
//        Assertions.assertEquals(player.getName(),resultPlayer.getName());
//    }
//
//    @Test
//    public void testDeletePlayer() {
//        long playerId = 1L;
//        playerService.deletePlayer(playerId);
//        verify(playerRepository).deleteById(playerId);
//    }
//
////    @Test
////    public void testTopFivePlayers() throws Exception {
////        Player player1 = new Player(1L,"Sahiti", 3);
////        Player player2 = new Player(2L,"Supriya", 24);
////        Player player3 = new Player(3L,"Indu", 35);
////        Player player4 = new Player(4L,"Preethi", 37);
////        Player player5 = new Player(5L,"Dharani", 38);
////        Player player6 = new Player(6L,"Vaishu", 39);
////        List<Player> allPlayers = new ArrayList<>(Arrays.asList(player1,player2,player3,player4,player5,player6));
////        List<Player> topFivePlayers = new ArrayList<>(Arrays.asList(player6,player5,player4,player3,player1));
////        when(playerRepository.findAll()).thenReturn(allPlayers);
////        List<Player> resultTopFivePlayers = gameServiceImpl.getTopFivePlayers();
////        Assertions.assertNotNull(resultTopFivePlayers);
////        Assertions.assertEquals(resultTopFivePlayers.size(), 5);
////        Assertions.assertEquals(resultTopFivePlayers, topFivePlayers);
////    }
}
