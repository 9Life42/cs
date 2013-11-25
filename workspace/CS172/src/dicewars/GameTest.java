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
	public void testPlayerNumberUp() {
		assertEquals(0, game.getPlayerNumberUp());

		for (int i = 0; i < game.getNumberOfPlayers() - 1; i++) {
			game.nextPlayerUp();
		}

		assertEquals(game.getNumberOfPlayers() - 1, game.getPlayerNumberUp());
		game.nextPlayerUp();
		assertEquals(0, game.getPlayerNumberUp());
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
	public void testWon() {
		// TODO
	}
	
	@Test
	public void testLost() {
		// TODO
	}

}