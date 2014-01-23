package dicewars;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;
	private Territory[][] map;

	@Before
	public void setUp() throws Exception {
		game = new Game(7);
		map = game.getMap();
	}

	@Test
	public void testConstructor() {
		assertTrue(game.isGaming());
	}

	@Test
	public void testPlayerIndexUp() {
		assertEquals(0, game.getPlayerIndexUp());

		for (int i = 0; i < game.getNumberOfPlayers() - 1; i++) {
			game.nextPlayerUp();
		}

		assertEquals(game.getNumberOfPlayers() - 1, game.getPlayerIndexUp());
		game.nextPlayerUp();
		assertEquals(0, game.getPlayerIndexUp());
	}

	@Test
	public void testLegal() {
		if (game.getTerritory(2, 2).getDice() > 1) {
			assertTrue(game.legal(2, 2, 2, 3));
			assertTrue(game.legal(2, 2, 2, 1));
			assertTrue(game.legal(2, 2, 1, 2));
			assertTrue(game.legal(2, 2, 3, 2));
			assertFalse(game.legal(2, 2, 2, 2));
			assertFalse(game.legal(2, 2, 3, 3));
			assertFalse(game.legal(2, 2, 4, 2));
			assertFalse(game.legal(2, 2, 2, 4));
		}
	}

	@Test
	public void testGetTerritory() {
		for (int c = 0; c < map.length; c++) {
			for (int r = 0; r < map[c].length; r++) {
				assertEquals(map[c][r], game.getTerritory(c, r));
			}
		}
	}

	@Test
	public void testDistributeDice() {
		int sum1 = 0;
		for (int c = 0; c < map.length; c++) {
			for (int r = 0; r < map[c].length; r++) {
				sum1 += map[c][r].getDice();
			}
		}
		game.distributeDice(3);
		int sum2 = 0;
		for (int c = 0; c < map.length; c++) {
			for (int r = 0; r < map[c].length; r++) {
				sum2 += map[c][r].getDice();
			}
		}
		if (sum2 < map.length * map[1].length * 8)
			assertEquals(3, sum2 - sum1);
	}

	@Test
	public void testRemovePlayer() {
		assertEquals(game.getPlayers().length, 7);

		assertEquals(game.getPlayerUp().getNumber(), 1);
		game.removePlayer(2);
		game.nextPlayerUp();
		assertEquals(game.getPlayers().length, 6);

		assertEquals(game.getPlayerUp().getNumber(), 3);
		game.nextPlayerUp();
		assertEquals(game.getPlayerUp().getNumber(), 4);
		game.nextPlayerUp();
		assertEquals(game.getPlayerUp().getNumber(), 5);
		game.nextPlayerUp();
		assertEquals(game.getPlayerUp().getNumber(), 6);
		game.removePlayer(7);
		game.nextPlayerUp();
		assertEquals(game.getPlayers().length, 5);

		assertEquals(game.getPlayerUp().getNumber(), 1);
	}
	
	@Test
	public void testCountTerritories() {
		Player player = game.getPlayerUp();
		
		for (int c = 0; c < map.length; c++) {
			for (int r = 0; r < map[c].length; r++) {
				map[c][r].setOwner(player);
			}
		}
		
		game.countTerritories(player);
		assertEquals(player.getAdjacentTerritories(), 35);
		game.nextPlayerUp();
		
		for (int c = 0; c < map.length; c++) {
			map[c][0].setOwner(game.getPlayerUp());
		}
		
		map[3][3].setOwner(game.getPlayerUp());
		
		game.countTerritories(player);
		assertEquals(player.getAdjacentTerritories(), 27);
		game.countTerritories(game.getPlayerUp());
		assertEquals(game.getPlayerUp().getAdjacentTerritories(), 7);
	}

}