package assignments;

import static edu.princeton.cs.introcs.StdDraw.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.Color;

public class Connect4Test {

	public Color[][] emptyBoard() {
		Color[][] result = new Color[6][7];
		for (int r = 0; r < result.length; r++) {
			for (int c = 0; c < result[r].length; c++) {
				result[r][c] = GRAY;
			}
		}	
		return result;
	}

	@Test
	public void testOpposite() {
		assertEquals(WHITE, Connect4.opposite(BLACK));
		assertEquals(BLACK, Connect4.opposite(WHITE));
	}

	@Test
	public void testDrop() {
		Color[][] board = emptyBoard();
		Connect4.drop(board, BLACK, 2);
		assertEquals(BLACK, board[0][2]);
		Connect4.drop(board, WHITE, 2);
		assertEquals(WHITE, board[1][2]);
		assertEquals(BLACK, board[0][2]);
	}

	@Test
	public void testLegal() {
		Color[][] board = emptyBoard();
		assertFalse(Connect4.legal(board, -1));		
		assertFalse(Connect4.legal(board, 7));		
		assertTrue(Connect4.legal(board, 6));		
		Connect4.drop(board, BLACK, 2);
		Connect4.drop(board, WHITE, 2);
		Connect4.drop(board, BLACK, 2);
		Connect4.drop(board, WHITE, 2);
		Connect4.drop(board, BLACK, 2);
		assertTrue(Connect4.legal(board, 2));
		Connect4.drop(board, WHITE, 2);
		assertFalse(Connect4.legal(board, 2));
	}

	@Test
	public void testFull() {
		Color[][] board = emptyBoard();
		for (int r = 0; r < Connect4.ROWS; r++) {
			for (int c = 0; c < Connect4.COLUMNS; c++) {
				assertFalse(Connect4.full(board));
				Connect4.drop(board, BLACK, c);
			}
		}
		assertTrue(Connect4.full(board));
	}

	@Test
	public void testHorizontalWinner() {
		Color[][] board = emptyBoard();
		assertEquals(GRAY, Connect4.winner(board));
		for (int c = 3; c < 7; c++) {
			Connect4.drop(board, BLACK, c);
		}
		assertEquals(BLACK, Connect4.winner(board));
	}
	
	@Test
	public void testVerticalWinner() {
		Color[][] board = emptyBoard();
		for (int i = 0; i < 4; i++) {
			Connect4.drop(board, WHITE, 6);
		}
		assertEquals(WHITE, Connect4.winner(board));
	}
	
	@Test
	public void testDiagonalWinner1() {
		Color[][] board = emptyBoard();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i; j++) {
				Connect4.drop(board, WHITE, i);
			}
			Connect4.drop(board, BLACK, i);
		}
		assertEquals(BLACK, Connect4.winner(board));
	}

	@Test
	public void testDiagonalWinner2() {
		Color[][] board = emptyBoard();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i; j++) {
				Connect4.drop(board, BLACK, 5 - i);
			}
			Connect4.drop(board, WHITE, 5 - i);
		}
		assertEquals(WHITE, Connect4.winner(board));
	}
	
	@Test
	public void testUndo() {
		Color[][] board = emptyBoard();
		Connect4.drop(board, BLACK, 2);
		Connect4.drop(board, WHITE, 2);
		Connect4.undo(board, 2);
		assertEquals(BLACK, board[0][2]);
		assertEquals(GRAY, board[1][2]);
	}

	@Test
	public void testMax0() {
		Color[][] board = emptyBoard();
		for (int i = 0; i < 3; i++) {
			Connect4.drop(board, BLACK, i);
			Connect4.drop(board, WHITE, Connect4.COLUMNS - 1 - i);
		}
		assertEquals(0, Connect4.max(board, 0, 0));
		Connect4.drop(board, BLACK, 3);
		assertEquals(1, Connect4.max(board, 0, 0));
		Connect4.undo(board, 3);
		Connect4.drop(board, WHITE, 3);
		assertEquals(-1, Connect4.max(board, 0, 0));
	}
	
	@Test
	public void testMax1() {
		Color[][] board = emptyBoard();
		// Black cannot win in one move
		assertEquals(0, Connect4.max(board, 1, 0));
		Connect4.drop(board, BLACK, 0);
		Connect4.drop(board, BLACK, 0);
		Connect4.drop(board, BLACK, 0);
		// Now black can win in one move
		assertEquals(1, Connect4.max(board, 1, 0));
	}

	@Test
	public void testMax2() {
		Color[][] board = emptyBoard();
		for (int i = 0; i < 3; i++) {
			Connect4.drop(board, WHITE, i + 2);
		}
		// Black cannot prevent white from winning
		assertEquals(-1, Connect4.max(board, 2, 0));
		Connect4.drop(board, BLACK, 0);
		Connect4.drop(board, BLACK, 0);
		Connect4.drop(board, BLACK, 0);
		// Now black can win in one move
		assertEquals(1, Connect4.max(board, 2, 0));
	}

	@Test
	public void testMin3() {
		Color[][] board = emptyBoard();
		for (int i = 0; i < 2; i++) {
			Connect4.drop(board, WHITE, i + 2);
		}
		// White can win in three moves
		assertEquals(-1, Connect4.min(board, 3, 0));
	}
	
	@Test
	public void testMin4() {
		Color[][] board = emptyBoard();
		Connect4.drop(board, WHITE, 2);
		// White can win in four moves
		assertEquals(-1, Connect4.min(board, 8, 0));
	}
	
	@Test
	public void testBestMoveForBlack() {
		Color[][] board = emptyBoard();
		for (int i = 0; i < 3; i++) {
			Connect4.drop(board, WHITE, 5);
		}
		// Black has to block
		assertEquals(5, Connect4.bestMoveForBlack(board, 3));
	}
	
}
