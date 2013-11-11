package mastermind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game("royr");
	}

	/**
	 * This one is pretty simple. Just count the number of matches between the
	 * guess and the correct answer (which was passed to the Game constructor).
	 */
	@Test
	public void testGetNumberOfBlackPegs() {
		assertEquals(4, game.getNumberOfBlackPegs("royr"));
		assertEquals(2, game.getNumberOfBlackPegs("bogr"));
		assertEquals(1, game.getNumberOfBlackPegs("rroy"));
	}

	/**
	 * Use any sorting algorithm, e.g., insertion sort. Since Strings are
	 * immutable, you'll have to convert the argument to a char[] using the
	 * String method toCharArray(), then convert it back to a String using the
	 * String constructor that takes a char[] as an argument.
	 */
	@Test
	public void testSort() {
		assertEquals("gory", game.sort("royg"));
	}

	/**
	 * This is the difficult one. It is much easier if you first sort the guess
	 * and the correct answer. Be sure to subtract the number of black pegs
	 * before returning the result.
	 */
	@Test
	public void testGetNumberOfWhitePegs() {
		assertEquals(0, game.getNumberOfWhitePegs("royr"));
		assertEquals(2, game.getNumberOfWhitePegs("brgy"));
		assertEquals(3, game.getNumberOfWhitePegs("rroy"));
		game = new Game("rooo");
		assertEquals(1, game.getNumberOfWhitePegs("grrr"));
		game = new Game("oorr");
		assertEquals(2, game.getNumberOfWhitePegs("bboo"));
	}
	
	/**
	 * This tests some getters and the guess() method, which stores a guess.
	 */
	@Test
	public void testGuess() {
		assertEquals(0, game.getNumberOfGuessesMade());
		game.guess("ygbv");
		assertEquals(1, game.getNumberOfGuessesMade());
		game.guess("ovgg");
		assertEquals(2, game.getNumberOfGuessesMade());
		assertEquals("ygbv", game.getGuess(0));
		assertEquals("ovgg", game.getGuess(1));
	}

	/**
	 * The game is won if the last guess was correct.
	 */
	@Test
	public void testIsWon() {
		assertFalse(game.isWon());
		game.guess("royr");
		assertTrue(game.isWon());
	}

	/**
	 * The game is lost if there have been 10 guesses.
	 */
	@Test
	public void testIsLost() {
		assertFalse(game.isLost());
		for (int i = 0; i < 9; i++) {
			game.guess("bvrg");
		}
		assertFalse(game.isLost());
		game.guess("bvrg");
		assertTrue(game.isLost());
	}

	/**
	 * If the 10th guess is correct, the game is still won.
	 */
	@Test
	public void testWinSupersedesLoss() {
		assertFalse(game.isLost());
		for (int i = 0; i < 9; i++) {
			game.guess("bvrg");
		}
		assertFalse(game.isLost());
		game.guess("royr");
		assertFalse(game.isLost());
		assertTrue(game.isWon());
	}

	/**
	 * This tests another getter.
	 */
	@Test
	public void testGetCorrect() {
		assertEquals("royr", game.getCorrect());
	}

	/**
	 * The zero-argument constructor should construct a random 4-character
	 * correct answer, using the letters r, o, y, g, b, and v.
	 */
	@Test
	public void testRandomCorrect() {
		assertFalse(new Game().getCorrect().equals(new Game().getCorrect()));
	}

}
