package assignments;

import static edu.princeton.cs.introcs.StdDraw.*;
import static java.lang.Math.*;
import java.awt.Color;

/** The game also known as The Captain's Mistress. */
public class Connect4 {

	/** Number of columns on the board. */
	public static final int COLUMNS = 7;

	/** Number of rows on the board. */
	public static final int ROWS = 6;

	/**
	 * Returns black's best move.
	 * @param maxDepth Maximum search depth.
	 */
	public static int bestMoveForBlack(Color[][] board, int maxDepth) {
		// TODO You have to write this.
		return -1;
	}

	/** Draws the board. */
	public static void draw(Color[][] board, Color player) {
		clear(BLUE);
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				setPenColor(board[r][c]);
				filledCircle((1.0 / (COLUMNS + 2)) * (c + 1.5),
						(1.0 / (ROWS + 2)) * (r + 2.5), 0.05);
			}
		}
		setPenColor(WHITE);
		if (winner(board) == BLACK) {
			text(0.5, 0.1, "Black wins!");
		} else if (winner(board) == WHITE) {
			text(0.5, 0.1, "White wins!");
		} else if (full(board)) {
			text(0.5, 0.1, "Draw.");
		} else if (player == BLACK) {
			text(0.5, 0.1, "Black to play.");
		} else {
			text(0.5, 0.1, "White to play.");
		}
		show(0);
	}

	/**
	 * Drops a piece of color in column. Modifies board. Assumes the move is
	 * legal.
	 */
	public static void drop(Color[][] board, Color color, int column) {
		for (int i = 0; ; i++) {
			if (board[i][column] == GRAY) {
				board[i][column] = color;
				break;
			}
		}
	}

	/** Returns true if board is full. */
	public static boolean full(Color[][] board) {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				if (board[i][j] == GRAY) return false;
			}
		}
		return true;
	}

	/** Returns true if column is neither off the edge of the board nor full. */
	public static boolean legal(Color[][] board, int column) {
		if (column >= 0 && column < COLUMNS) {
			for (int i = 0; i < ROWS; i++) {
				if (board[i][column] == GRAY) return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Color[][] board = new Color[6][7];
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				board[r][c] = GRAY;
			}
		}
		Color player = BLACK;
		while ((winner(board) == GRAY) && !full(board)) {
			draw(board, player);
			if (player == BLACK) { // Computer turn
				// The second argument to bestMoveForBlack() can be increased
				// for a stronger, slower opponent
				drop(board, BLACK, bestMoveForBlack(board, 5));
				player = opposite(player);
			} else { // Human turn
				while (!mousePressed()) {
					// Wait for mouse press
				}
				int column = (int) (round((mouseX() / (1.0 / (board[0].length + 2))) - 1.5));
				if (legal(board, column)) {
					drop(board, player, column);
					player = opposite(player);
				}
				while (mousePressed()) {
					// Wait for mouse release
				}
			}
		}
		draw(board, player);
	}

	/**
	 * Returns the value of board with black to move: 1 if black can force a
	 * win, -1 if black cannot avoid a loss, 0 otherwise.
	 * 
	 * @param maxDepth Maximum search depth.
	 * @param depth Current search depth.
	 */
	public static int max(Color[][] board, int maxDepth, int depth) {
		Color winner = winner(board);
		if (winner == WHITE) {
			return 1;
		} else if (winner == BLACK) {
			return -1;
		} else if (full(board) || (depth == maxDepth)) {
			return 0;
		} else {
			int bestResult = 2;
			for (int c = 0; c < COLUMNS; c++) {
				if (legal(board, c)) {
					drop(board, BLACK, c);
					int result = min(board, maxDepth, depth + 1);
					undo(board, c);
					if (result <= bestResult) {
						bestResult = result;
					}
				}
			}
			return bestResult;
		}
	}

	/**
	 * Returns the value of board with white to move: 1 if white cannot avoid a
	 * loss, -1 if white can force a win, 0 otherwise.
	 * 
	 * @param maxDepth Maximum search depth.
	 * @param depth Current search depth.
	 */
	public static int min(Color[][] board, int maxDepth, int depth) {
		Color winner = winner(board);
		if (winner == BLACK) {
			return 1;
		} else if (winner == WHITE) {
			return -1;
		} else if (full(board) || (depth == maxDepth)) {
			return 0;
		} else {
			int bestResult = 2;
			for (int c = 0; c < COLUMNS; c++) {
				if (legal(board, c)) {
					drop(board, WHITE, c);
					int result = max(board, maxDepth, depth + 1);
					undo(board, c);
					if (result <= bestResult) {
						bestResult = result;
					}
				}
			}
			return bestResult;
		}
	}

	/**
	 * opposite(BLACK) return WHITE. opposite(WHITE) returns BLACK.
	 */
	public static Color opposite(Color color) {
		if (color == BLACK) return WHITE;
		if (color == WHITE) return BLACK;
		return null;
	}

	/**
	 * Removes the top piece from column. Modifies board. Assumes column is not
	 * empty.
	 */
	public static void undo(Color[][] board, int column) {
		int r;
		for (r = ROWS - 1; board[r][column] == GRAY; r--) {
			// All the work is done in the loop header
		}
		board[r][column] = GRAY;
	}

	/**
	 * Returns the color of the player with four in a row starting at r, c and
	 * advancing rOffset, cOffset each step. For example, if rOffset is 1 and
	 * cOffset is 0, r increases by 1 at each step. Returns GRAY if no player
	 * has four in a row here, or if there aren't four spaces starting here.
	 */
	public static Color winAt(Color[][] board, int r, int c, int rOffset,
			int cOffset) {
		
		Color color = board[r][c];
		int n = 0;
		
//		if (rOffset > 0 && r+4 > ROWS) return GRAY;
//		if (cOffset > 0 && c+4 > ROWS) return GRAY;
//		if (cOffset < 0 && c-4 < 0) return GRAY;
		
		while (board[r][c] == color && board.length < ROWS && board[r].length < COLUMNS) {
			n += 1;
			if (n == 4) return color;
			r += rOffset;
			c += cOffset;
		}
		
		return GRAY;
	}

	/**
	 * Returns BLACK if black has won, WHITE if white has won, GRAY if neither
	 * player has won.
	 */
	public static Color winner(Color[][] board) {
		Color color;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				
				color = winAt(board, i, j, 1, 0);
				if (color != GRAY) return color;
				
				color = winAt(board, i, j, 0, 1);
				if (color != GRAY) return color;
				
				color = winAt(board, i, j, 1, 1);
				if (color != GRAY) return color;
				
				color = winAt(board, i, j, 1, -1);
				if (color != GRAY) return color;
			}
		}
		return GRAY;
	}

}
