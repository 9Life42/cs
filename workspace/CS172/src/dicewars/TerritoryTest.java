package dicewars;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static edu.princeton.cs.introcs.StdDraw.*;

public class TerritoryTest {

	private Territory territory;
	private Player player;

	@Before
	public void setUp() throws Exception {
		player = new Player(RED);
		territory = new Territory(player, 3);
	}

	@Test
	public void testIsOwnedBy() {
		assertTrue(territory.isOwnedBy(player));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddDice() {
		territory.addDice(2);
		assertEquals(5, territory.getDice());
		territory.setDice(8);
		territory.addDice(1);
	}

}
