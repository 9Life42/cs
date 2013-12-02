package hex;

import static org.junit.Assert.*;
import static hex.Game.*;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;
	
	protected void setUpProblem(String... diagram) {
		for (int r = 0; r < diagram.length; r++) {
			int c = 0;
			for (char color : diagram[r].toCharArray()) {
				if ((color != ' ') && (color != '\n')) {
					if (color == '#') {
						game.setColor(r, c, BLACK);
					} else if (color == 'O') {
						game.setColor(r, c, WHITE);
					}
					c++;
				}
			}
		}
	}

	@Before
	public void setUp() throws Exception {
		game = new Game(4);
	}

	@Test
	public void testGetWidth() {
		assertEquals(4, game.getWidth());
		game = new Game(10);
		assertEquals(10, game.getWidth());
	}

	@Test
	public void testToString() {
		assertEquals(" 0 1 2 3 \n0 . . . . 0\n 1 . . . . 1\n  2 . . . . 2\n   3 . . . . 3\n      0 1 2 3 \n", game.toString());
	}

	@Test
	public void testSetColor() {
		game.setColor(2, 3, BLACK);
		assertEquals(" 0 1 2 3 \n0 . . . . 0\n 1 . . . . 1\n  2 . . . # 2\n   3 . . . . 3\n      0 1 2 3 \n", game.toString());
	}

	@Test
	public void testSetAndGetColor() {
		assertEquals(VACANT, game.getColor(3, 2));
		game.setColor(3, 2, WHITE);
		assertEquals(WHITE, game.getColor(3, 2));
		game.setColor(3, 2, VACANT);
		assertEquals(VACANT, game.getColor(3, 2));
	}

	@Test
	public void testNeighborWiringInCenter() {
		assertEquals(6, game.getNeighborCount(game.getNode(1, 1)));
		assertTrue(game.neighbors(game.getNode(1, 1), game.getNode(0, 1)));
		assertTrue(game.neighbors(game.getNode(1, 1), game.getNode(0, 2)));
		assertTrue(game.neighbors(game.getNode(1, 1), game.getNode(1, 0)));
		assertTrue(game.neighbors(game.getNode(1, 1), game.getNode(1, 2)));
		assertTrue(game.neighbors(game.getNode(1, 1), game.getNode(2, 0)));
		assertTrue(game.neighbors(game.getNode(1, 1), game.getNode(2, 1)));
	}

	@Test
	public void testNeighborWiringAtEdge() {
		assertEquals(4, game.getNeighborCount(game.getNode(3, 3)));
		assertTrue(game.neighbors(game.getNode(3, 3), game.getNode(3, 2)));
		assertTrue(game.neighbors(game.getNode(3, 3), game.getNode(2, 3)));
		assertTrue(game.neighbors(game.getNode(3, 3), game.getEast()));
		assertTrue(game.neighbors(game.getNode(3, 3), game.getSouth()));
	}
	
	@Test
	public void testSentinelsAreDifferent() {
		assertNotSame(game.getNorth(), game.getSouth());
		assertNotSame(game.getWest(), game.getEast());
	}
	
	@Test
	public void testFindWinner() {
		setUpProblem("# . . .",
					  "# # # #",
					   "O O O .",
					    ". . # O");
		assertEquals(VACANT, game.findWinner());
		game.setColor(2, 3, BLACK);
		assertEquals(BLACK, game.findWinner());
		game.setColor(2, 3, WHITE);
		assertEquals(WHITE, game.findWinner());
	}

	@Test
	public void testGetCurrentPlayer() {
		assertEquals(BLACK, game.getCurrentPlayer());
		game.playAt(1, 2);
		assertEquals(WHITE, game.getCurrentPlayer());
		game.playAt(2, 0);
		assertEquals(BLACK, game.getCurrentPlayer());
	}

}
