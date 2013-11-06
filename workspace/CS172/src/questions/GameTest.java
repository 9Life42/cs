package questions;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	@Test
	public void testConstructor() {
		assertEquals(
				"Does it have a motor?\n  Does it store information?\n    a hard drive\n    a car\n  a giraffe\n",
				game.toString());
	}

	@Test
	public void testGetRoot() {
		assertEquals("Does it have a motor?", game.getRoot().getKey());
	}

	@Test
	public void testGetCurrentNode() {
		assertSame(game.getRoot(), game.getCurrentNode());
	}

	@Test
	public void testDescend() {
		game.descend(true);
		assertEquals("Does it store information?", game.getCurrentNode()
				.getKey());
		game.descend(false);
		assertEquals("a car", game.getCurrentNode().getKey());
	}

	@Test
	public void testAtLeaf() {
		game.descend(true);
		assertFalse(game.atLeaf());
		game.descend(false);
		assertTrue(game.atLeaf());
	}

	@Test
	public void testReset() {
		game.descend(true);
		game.descend(false);
		game.reset();
		assertSame(game.getRoot(), game.getCurrentNode());
	}

	@Test
	public void testGetQuestion() {
		game.descend(true);
		assertEquals("Does it store information? (y/n)", game.getQuestion());
		game.descend(false);
		assertEquals("Is it a car? (y/n)", game.getQuestion());
	}

	@Test
	public void testGetLearningQuestion() {
		game.descend(false);
		assertEquals(
				"What question would distinguish a fox (y) from a giraffe (n)?",
				game.getLearningQuestion("a fox"));
	}

	@Test
	public void testLearn() {
		game.descend(false);
		game.learn("a lion", "Is it carnivorous?");
		assertEquals(
				"Does it have a motor?\n  Does it store information?\n    a hard drive\n    a car\n  Is it carnivorous?\n    a lion\n    a giraffe\n",
				game.toString());
	}

}
