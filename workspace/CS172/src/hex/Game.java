package hex;

import java.util.ArrayList;

public class Game {

	private class Node {
		private int color;
		private ArrayList<Node> neighbors;

		private Node() {
			color = VACANT;
			neighbors = new ArrayList<Node>();
		}
	}

	public static final int VACANT = 2;
	public static final int WHITE = 1;
	public static final int BLACK = 0;

	private int currentPlayer;

	private int width;
	private Node[][] board;
	private Node north;
	private Node east;
	private Node south;
	private Node west;

	public Game(int width) {
		currentPlayer = BLACK;

		this.width = width;
		board = new Node[width][width];

		north = new Node();
		north.color = BLACK;
		east = new Node();
		east.color = WHITE;
		south = new Node();
		south.color = BLACK;
		west = new Node();
		west.color = WHITE;

		for (int r = 0; r < width; r++) {
			for (int c = 0; c < width; c++) {
				board[r][c] = new Node();
			}
		}

		// Connect Sentinels
		for (int i = 0; i < width; i++) {
			north.neighbors.add(board[0][i]);
			east.neighbors.add(board[i][width - 1]);
			south.neighbors.add(board[width - 1][i]);
			west.neighbors.add(board[i][0]);
		}

		// Add internal
		for (int r = 1; r < width - 1; r++) {
			for (int c = 1; c < width - 1; c++) {
				// Along axis
				board[r][c].neighbors.add(board[r + 1][c]);
				board[r][c].neighbors.add(board[r + 1][c - 1]);
				board[r][c].neighbors.add(board[r - 1][c]);
				board[r][c].neighbors.add(board[r - 1][c + 1]);
				// Diagonal
				board[r][c].neighbors.add(board[r][c - 1]);
				board[r][c].neighbors.add(board[r][c + 1]);
			}

			// Add Left
			board[r][0].neighbors.add(board[r - 1][0]);
			board[r][0].neighbors.add(board[r + 1][0]);
			board[r][0].neighbors.add(board[r][1]);
			board[r][0].neighbors.add(board[r - 1][1]);
			board[r][0].neighbors.add(west);

			// Add right
			board[r][width - 1].neighbors.add(board[r - 1][width - 1]);
			board[r][width - 1].neighbors.add(board[r + 1][width - 1]);
			board[r][width - 1].neighbors.add(board[r][width - 2]);
			board[r][width - 1].neighbors.add(board[r + 1][width - 2]);
			board[r][width - 1].neighbors.add(east);

			// Add top
			board[0][r].neighbors.add(board[0][r + 1]);
			board[0][r].neighbors.add(board[0][r - 1]);
			board[0][r].neighbors.add(board[1][r - 1]);
			board[0][r].neighbors.add(board[1][r]);
			board[0][r].neighbors.add(north);

			// Add bottom
			board[width - 1][r].neighbors.add(board[width - 1][r + 1]);
			board[width - 1][r].neighbors.add(board[width - 1][r - 1]);
			board[width - 1][r].neighbors.add(board[width - 2][r + 1]);
			board[width - 1][r].neighbors.add(board[width - 2][r]);
			board[width - 1][r].neighbors.add(south);

		}

		// Add corners
		// Top left
		board[0][0].neighbors.add(board[0][1]);
		board[0][0].neighbors.add(board[1][0]);
		board[0][0].neighbors.add(north);
		board[0][0].neighbors.add(west);
		// Top right
		board[0][width - 1].neighbors.add(board[0][width - 2]);
		board[0][width - 1].neighbors.add(board[1][width - 1]);
		board[0][width - 1].neighbors.add(board[1][width - 2]);
		board[0][width - 1].neighbors.add(north);
		board[0][width - 1].neighbors.add(east);
		// Bottom right
		board[width - 1][width - 1].neighbors.add(board[width - 1][width - 2]);
		board[width - 1][width - 1].neighbors.add(board[width - 2][width - 1]);
		board[width - 1][width - 1].neighbors.add(south);
		board[width - 1][width - 1].neighbors.add(east);
		// Bottom left
		board[width - 1][0].neighbors.add(board[width - 1][1]);
		board[width - 1][0].neighbors.add(board[width - 2][0]);
		board[width - 1][0].neighbors.add(board[width - 2][1]);
		board[width - 1][0].neighbors.add(south);
		board[width - 1][0].neighbors.add(west);

	}

	public int getWidth() {
		return width;
	}

	public int getColor(int r, int c) {
		return board[r][c].color;
	}

	public void setColor(int r, int c, int color) {
		board[r][c].color = color;
	}

	public Node getNode(int r, int c) {
		return board[r][c];
	}

	public boolean neighbors(Node node1, Node node2) {
		if (node1.neighbors.contains(node2) && node2.neighbors.contains(node1))
			return true;
		return false;
	}

	public int getNeighborCount(Node node) {
		return node.neighbors.size();
	}

	public Node getNorth() {
		return north;
	}

	public Node getEast() {
		return east;
	}

	public Node getSouth() {
		return south;
	}

	public Node getWest() {
		return west;
	}
	
	public int getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void playAt(int r, int c) {
		board[r][c].color = currentPlayer;
		currentPlayer = currentPlayer + 1 + (-2 * currentPlayer); // ;)
	}

	public boolean rWin(Node here, Node to) {
		int color = here.color;
		here.color = VACANT;
		
		for (Node n: here.neighbors)
			if (n.color == color && (n.neighbors.contains(to) || rWin(n, to))) {
				here.color = color;
				return true;
			}
		
		here.color = color;
		return false;
	}

	public int findWinner() {
		if (rWin(north, south))
			return BLACK;
		else if (rWin(east, west))
			return WHITE;
		else
			return VACANT;
	}

	public String rString(String s, String space, int depth) {
		if (depth == width) {
			return s;
		} else {
			s += space + depth;

			for (int i = 0; i < width; i++) {
				if (board[depth][i].color == BLACK)
					s += " #";
				else if (board[depth][i].color == WHITE)
					s += " O";
				else
					s += " .";
			}

			s += " " + depth + "\n";

			return rString(s, space + " ", depth + 1);
		}
	}

	public String toString() {
		String s = " ";

		for (int i = 0; i < width; i++) {
			s += i + " ";
		}

		s += "\n";
		s += rString("", "", 0);

		for (int i = 0; i < width + 2; i++) {
			s += " ";
		}

		for (int i = 0; i < width; i++) {
			s += i + " ";
		}

		s += "\n";
		return s;
	}

}
