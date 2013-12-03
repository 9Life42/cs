package focus;

import static focus.Game.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;
	
	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	/** Test some piles in the initial setup. */
	@Test
	public void testGetPile() {
		Deque<Integer> pile = game.getPile(new Location(1, 6));
		assertEquals(1, pile.size());
		assertEquals(new Integer(BLACK), pile.removeFront());
		pile = game.getPile(new Location(3, 3));
		assertEquals(1, pile.size());
		assertEquals(new Integer(WHITE), pile.removeFront());
		// This square is off the board, so has a null pile
		assertNull(game.getPile(new Location(0, 1)));
	}
	
	@Test
	public void testIsOnBoard() {
		assertTrue(game.isOnBoard(new Location(4, 5)));
		assertFalse(game.isOnBoard(new Location(4, 8)));
		assertFalse(game.isOnBoard(new Location(-1, 5)));
		assertFalse(game.isOnBoard(new Location(6, 7)));
	}

	@Test
	public void testIsLegalSource() {
		assertFalse(game.isLegalSource(new Location(0, 1)));
		Location there = new Location(3, 0);
		Deque<Integer> pile = game.getPile(there);
		assertFalse(game.isLegalSource(there));
		pile.addBack(WHITE);
		pile.addBack(WHITE);
		assertFalse(game.isLegalSource(there));
		pile.addBack(BLACK);
		assertTrue(game.isLegalSource(there));		
	}

	@Test
	public void testIsLegalMove() {
		Location source = new Location(2, 3);
		game.getPile(source).addBack(WHITE);
		game.getPile(source).addBack(BLACK);
		// Normal move
		assertTrue(game.isLegalMove(source, new Location(2, 6)));
		// Short move
		assertTrue(game.isLegalMove(source, new Location(2, 6)));
		// Illegal move too far
		assertFalse(game.isLegalMove(source, new Location(6, 3)));		
		// Illegal diagonal move
		assertFalse(game.isLegalMove(source, new Location(3, 4)));
	}

	@Test
	public void testMove() {
		Location source = new Location(2, 2);
		game.getPile(source).addBack(WHITE);
		game.getPile(source).addBack(WHITE);
		game.getPile(source).addBack(BLACK);
		game.getPile(source).addBack(BLACK);
		Location destination = new Location(6, 2);
		game.move(source, destination);
		assertEquals(1, game.getPile(source).size());
		assertEquals(new Integer(WHITE), game.getPile(source).removeBack());
		assertEquals(5, game.getPile(destination).size());
		assertEquals(new Integer(BLACK), game.getPile(destination).removeBack());
		assertEquals(new Integer(BLACK), game.getPile(destination).removeBack());
		assertEquals(new Integer(WHITE), game.getPile(destination).removeBack());
		assertEquals(new Integer(WHITE), game.getPile(destination).removeBack());
		assertEquals(new Integer(WHITE), game.getPile(destination).removeBack());
	}

	@Test
	public void testToggleColorToPlay() {
		assertEquals(BLACK, game.getColorToPlay());
		game.toggleColorToPlay();
		assertEquals(WHITE, game.getColorToPlay());
		game.toggleColorToPlay();
		assertEquals(BLACK, game.getColorToPlay());
	}

	@Test
	public void testCapturesAndReserves() {
		Location source = new Location(4, 2);
		Deque<Integer> s = game.getPile(source);
		s.addBack(BLACK);
		s.addBack(WHITE);
		s.addBack(WHITE);
		s.addBack(BLACK);
		Location destination = new Location(4, 5);
		Deque<Integer> d = game.getPile(destination);
		d.addBack(BLACK);
		d.addBack(WHITE);
		d.addBack(WHITE);
		d.addBack(BLACK);
		assertEquals(0, game.getReserves(BLACK));
		game.move(source, destination);
		assertEquals(5, d.size());
		assertEquals(1, game.getReserves(BLACK));
		assertEquals(0, game.getReserves(WHITE));
	}

	@Test
	public void testReservesAsLegalSource() {
		assertFalse(game.isLegalSource(RESERVES_LOCATIONS[BLACK]));
		testCapturesAndReserves();
		// Make another move to flip the color to play back to black
		game.move(new Location(2, 1), new Location(1, 1));
		assertTrue(game.isLegalSource(RESERVES_LOCATIONS[BLACK]));
		assertFalse(game.isLegalSource(RESERVES_LOCATIONS[WHITE]));
	}

	@Test
	public void testMoveFromReserves() {
		Location d = new Location(2, 6);
		testCapturesAndReserves();
		// Make another move to flip the color to play back to black
		game.move(new Location(2, 1), new Location(1, 1));
		assertTrue(game.isLegalMove(RESERVES_LOCATIONS[BLACK], d));
		game.move(RESERVES_LOCATIONS[BLACK], d);
		assertEquals(2, game.getPile(d).size());
		assertEquals(new Integer(BLACK), game.getPile(d).removeBack());
	}

	@Test
	public void testIsGameOver() {
		assertFalse(game.isGameOver());
		testCapturesAndReserves();
		// Make another move to flip the color to play back to black
		game.move(new Location(2, 1), new Location(1, 1));
		// Add white pieces everywhere
		for (int r = 0; r < BOARD_WIDTH; r++) {
			for (int c = 0; c < BOARD_WIDTH; c++) {
				Location location = new Location(r, c);
				if (game.isOnBoard(location)) {
					game.getPile(location).addBack(WHITE);
				}
			}
		}
		// Black still has a reserve
		assertFalse(game.isGameOver());
		// Play that reserve, then cover it up with a white piece
		game.move(RESERVES_LOCATIONS[BLACK], new Location(6, 1));
		game.move(new Location(6, 2), new Location(6, 1));
		assertTrue(game.isGameOver());
	}

}
