package exercises;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PuzzleTest {
	
	@Before
	public  void setUp() throws Exception {
	}
	
	@Test
	public void testDisplay() {
		int[][] testgrid = {{0,1,2},{3,4,5},{6,-1,7}};
		String correct = ("012\n345\n6.7\n");
		assertEquals(correct, Puzzle.display(testgrid));
	}
	
	@Test
	public void testSolution() {
		String correct = ("012\n345\n67.\n");
		assertEquals(correct, Puzzle.display(Puzzle.solution()));
	}
	
	@Test
	public void testMove() {
		int[][] testgrid = Puzzle.solution();
		Puzzle.north(testgrid);
		String correct = ("012\n34.\n675\n");
		assertEquals(correct, Puzzle.display(testgrid));
	}

}
