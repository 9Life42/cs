package dicewars;

import static edu.princeton.cs.introcs.StdRandom.*;
import static edu.princeton.cs.introcs.StdDraw.*;
import static java.lang.Math.*;

import java.awt.Color;

public class Version1 {

	public static final Color PURPLE = new Color(150, 0, 200);

	public static final int COLUMNS = 7;

	public static final int ROWS = 5;

	public static final int PLAYERS = 7;

	public static final int PLAYER_INDEX = 0;

	public static final int DICE = 1;

	public static void main(String[] args) {
		setCanvasSize(768, 768);

		int[][][] board = new int[COLUMNS][ROWS][2];
		// The third dimension is for the player color index and number of dice
		// respectively

		Color[] player = { RED, ORANGE, MAGENTA, GREEN, CYAN, BLUE, PURPLE };
		int[] adjTerritories = new int[PLAYERS];

		int playerUp = 0;

		randomizeBoard(board);

		while (true) {

			drawBoard(board, player);
			drawPlayers(player, adjTerritories, playerUp);
			show(0);

			while (true) {

				int attColumn;
				int attRow;
				int defColumn;
				int defRow;

				double inX;
				double inY;

				while (!mousePressed()) {
					// Wait for mouse press
				}

				inX = mouseX();
				inY = mouseY();

				attColumn = getColumn(inX);
				attRow = getRow(inY);

				if (inX > 0.47 && inX < 0.53 && inY > 0.04 && inY < 0.06) {
					// End turn button
					playerUp = next(playerUp);
					
					while (mousePressed()) {
						// Wait for mouse release
					}

					break;

				} else if (attColumn > -1 && attRow > -1
						&& board[attColumn][attRow][PLAYER_INDEX] == playerUp) {
					// If the row and column are on the board and the correct
					// player
					// is selected, continue

					setPenColor(BLACK);
					filledCircle((attColumn + 1) * 0.125, (attRow + 3) * 0.125,
							0.04);

					setPenRadius(0.01);
					setPenColor(player[board[attColumn][attRow][PLAYER_INDEX]]);
					circle((attColumn + 1) * 0.125, (attRow + 3) * 0.125, 0.04);

					setPenRadius();
					setPenColor(WHITE);
					text((attColumn + 1) * 0.125, (attRow + 3) * 0.125, ""
							+ board[attColumn][attRow][DICE]);

					show(0);

				} else {
					break;
				}

				while (mousePressed()) {
					// Wait for mouse release
				}

				while (!mousePressed()) {
					// Wait for mouse press
				}

				inX = mouseX();
				inY = mouseY();

				defColumn = getColumn(inX);
				defRow = getRow(inY);

				if (inX > 0.47 && inX < 0.53 && inY > 0.04 && inY < 0.06) {
					// End turn button
					playerUp = next(playerUp);
					
					while (mousePressed()) {
						// Wait for mouse release
					}

					break;

				} else if (defColumn > -1 && defRow > -1
						&& board[defColumn][defRow][PLAYER_INDEX] != playerUp) {
					// If the row and column are on the board and an enemy is
					// selected, fight

					setPenColor(BLACK);
					filledCircle((defColumn + 1) * 0.125, (defRow + 3) * 0.125,
							0.04);

					setPenRadius(0.01);
					setPenColor(player[board[defColumn][defRow][PLAYER_INDEX]]);
					circle((defColumn + 1) * 0.125, (defRow + 3) * 0.125, 0.04);

					setPenRadius();
					setPenColor(WHITE);
					text((defColumn + 1) * 0.125, (defRow + 3) * 0.125, ""
							+ board[defColumn][defRow][DICE]);

					attack(board, attColumn, attRow, defColumn, defRow);

				} else {
					break;
				}

				while (mousePressed()) {
					// Wait for mouse release
				}
			}
		}
	}

	private static int getColumn(double inX) {
		for (int x = 0; x < COLUMNS; x++) {

			if (inX > (x + 1) * 0.125 - 0.04 && inX < (x + 1) * 0.125 + 0.04)
				return x;

		}

		return -1;
		// If the selection is off the board
	}

	private static int getRow(double inY) {
		for (int y = 0; y < ROWS; y++) {

			if (inY > (y + 3) * 0.125 - 0.04 && inY < (y + 3) * 0.125 + 0.04)
				return y;

		}

		return -1;
		// If the selection is off the board
	}

	private static int next(int playerUp) {
		if (playerUp + 1 == PLAYERS)
			return 0;
		return playerUp + 1;
	}

	public static void drawBoard(int[][][] board, Color[] player) {

		clear();
		setPenColor();
		text(0.5, 0.975, "DICE WARS!");

		for (double i = 0; i < 0.625; i += 0.125) {
			line(0.125, 0.875 - i, 0.875, 0.875 - i);
		}

		for (double i = 0; i < 0.875; i += 0.125) {
			line(0.125 + i, 0.875, 0.125 + i, 0.375);
		}

		for (int x = 0; x < COLUMNS; x++) {
			for (int y = 0; y < ROWS; y++) {

				setPenColor(player[board[x][y][PLAYER_INDEX]]);
				filledCircle((x + 1) * 0.125, (y + 3) * 0.125, 0.04);

				setPenColor(WHITE);
				text((x + 1) * 0.125, (y + 3) * 0.125, "" + board[x][y][DICE]);

			}
		}

		show(0);
	}

	public static void drawPlayers(Color[] player, int[] adjTerritories,
			int playerUp) {

		for (int i = 0; i < 7; i++) {

			int x = i + 1;

			setPenColor(player[i]);
			text(x * 0.125, 0.15, "Player " + x);
			text(x * 0.125, 0.1, "" + adjTerritories[i]);

		}

		setPenColor();
		rectangle((playerUp + 1) * 0.125, 0.15, 0.05, 0.02);
		// Player up indicator

		filledRectangle(0.5, 0.05, 0.07, 0.02);
		setPenColor(WHITE);
		text(0.5, 0.05, "End Turn");

		show(0);

	}

	public static int defenderDice(int defender) {
		int sum = 0;
		int x = 0;

		while (defender > x) {
			int roll = uniform(1, 7);

			sum += roll;

			setPenColor();
			text(0.55 + x * 0.05, 0.25, "" + roll);

			x++;

			if (defender > x) {
				text(0.525 + x * 0.05, 0.25, "+");
			}
		}

		text(0.525 + x * 0.05, 0.25, "=");
		text(0.55 + x * 0.05, 0.25, "" + sum);

		return sum;
	}

	private static int attackerDice(int attacker) {
		int sum = 0;
		int x = 0;

		while (attacker > x) {
			int roll = uniform(1, 7);

			sum += roll;

			setPenColor();
			text(0.45 - x * 0.05, 0.25, "" + roll);

			x++;

			if (attacker > x) {
				text(0.475 - x * 0.05, 0.25, "+");
			}
		}

		text(0.475 - x * 0.05, 0.25, "=");
		text(0.45 - x * 0.05, 0.25, "" + sum);

		return sum;
	}

	public static void randomizeBoard(int[][][] board) {
		for (int x = 0; x < COLUMNS; x++) {
			for (int y = 0; y < ROWS; y++) {

				board[x][y][PLAYER_INDEX] = uniform(PLAYERS);
				// Randomize player Color
				board[x][y][DICE] = uniform(1, 7);
				// Randomize dice

			}
		}
	}

	public static boolean legal(int[][][] board, int attColumn, int attRow,
			int defColumn, int defRow) {

		if (abs(attColumn - defColumn) + abs(attRow - defRow) != 1)
			// Test if the territories are touching
			return false;

		if (board[attColumn][attRow][PLAYER_INDEX] == board[defColumn][defRow][PLAYER_INDEX])
			// Tests if the color is the same
			return false;

		return true;
	}

	public static void attack(int[][][] board, int attColumn, int attRow,
			int defColumn, int defRow) {

		if (legal(board, attColumn, attRow, defColumn, defRow)) {

			setPenColor();
			text(0.5, 0.25, "vs.");

			int att = attackerDice(board[attColumn][attRow][DICE]);
			int def = defenderDice(board[defColumn][defRow][DICE]);

			if (att > def) {
				text(0.5, 0.2, "Attacker wins! Click to continue.");
			} else {
				text(0.5, 0.2, "Defender wins! Click to continue.");
			}

			show(500);

		}
	}
}