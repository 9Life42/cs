package hex;

import java.util.ArrayList;

public class Game {
	
	private class Node {
		private int player;
		private ArrayList<Node> neighbors;
		
		private Node() {
			player = VACANT;
			neighbors = new ArrayList<Node>();
		}
	}

	public static final int VACANT = 2;
	public static final int WHITE = 1;
	public static final int BLACK = 0;
	
	private int width;
	private Node[][] board;
	private Node north;
	private Node east;
	private Node south;
	private Node west;

	public Game(int width) {
		this.width = width;
		board = new Node[width][width];
		
		north = new Node();
		east = new Node();
		south = new Node();
		west = new Node();
		
		for (int r = 0; r < width; r++) {
			for (int c = 0; c < width; c++) {
				board[r][c] = new Node();
			}
		}
		
		for (int r = 1; r < width - 1; r++) {
			for (int c = 1; c < width - 1; c++) {
				board[r][c].neighbors.add(board[r + 1][c + 1]);
				board[r][c].neighbors.add(board[r + 1][c - 1]);
				board[r][c].neighbors.add(board[r - 1][c + 1]);
				board[r][c].neighbors.add(board[r - 1][c - 1]);
				
				board[r][c].neighbors.add(board[r][c - 1]);
				board[r][c].neighbors.add(board[r + 1][c]);
			}
			
			board[r][0].neighbors.add(board[r - 1][0]);
			board[r][0].neighbors.add(board[r + 1][0]);
			board[r][0].neighbors.add(board[r][1]);
			board[r][0].neighbors.add(board[r - 1][1]);
			
			board[r][width - 1].neighbors.add(board[r - 1][0]);
			board[r][width - 1].neighbors.add(board[r + 1][0]);
			board[r][width - 1].neighbors.add(board[r][width -2]);
			board[r][width - 1].neighbors.add(board[r + 1][width - 2]);
			
			board[0][r].neighbors.add(board[0][r + 1]);
			board[0][r].neighbors.add(board[0][r - 1]);
			board[0][r].neighbors.add(board[1][r - 1]);
			board[0][r].neighbors.add(board[1][r]);
			
			board[width - 1][r].neighbors.add(board[width - 1][r + 1]);
			board[width - 1][r].neighbors.add(board[width - 1][r - 1]);
			board[width - 1][r].neighbors.add(board[width - 2][r + 1]);
			board[width - 1][r].neighbors.add(board[width - 2][r]);
			
		}
		
	}

	public int getWidth() {
		return width;
	}

	public int getColor(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setColor(int r, int c, int black2) {
		// TODO Auto-generated method stub
		
	}

	public Node getNode(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean neighbors(Object node, Object node2) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getNeighborCount(Object node) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Node getNorth() {
		// TODO Auto-generated method stub
		return null;
	}

	public Node getEast() {
		// TODO Auto-generated method stub
		return null;
	}

	public Node getSouth() {
		// TODO Auto-generated method stub
		return null;
	}

	public Node getWest() {
		// TODO Auto-generated method stub
		return null;
	}

	public int findWinner() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getCurrentPlayer() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void playAt(int i, int j) {
		// TODO Auto-generated method stub
		
	}

}
