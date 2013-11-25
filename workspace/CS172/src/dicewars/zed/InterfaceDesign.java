package dicewars.zed;

import static edu.princeton.cs.introcs.StdRandom.*;
import static edu.princeton.cs.introcs.StdDraw.*;
import java.awt.Color;

public class InterfaceDesign {
	
	public static final Color PURPLE = new Color(150, 0, 200);
	
	public static final int COLUMNS = 7;
	
	public static final int ROWS = 5;

	public static void main(String[] args) {
		setCanvasSize(768, 768);

		int[][][] board = new int[COLUMNS][ROWS][2]; // The third dimension is for the player color index and number of dice respectively
		Color[] player = { RED, ORANGE, MAGENTA, GREEN, CYAN, BLUE, PURPLE };

		randomizeBoard(board);
		drawBoard(board, player);
		drawPlayers(player);
		drawDiceRolls(uniform(2, 9), uniform(1, 9)); // Just dummy values to
														// test it because we
														// aren't actually able
														// to attack yet

	}

	public static void drawDiceRolls(int attacker, int defender) {
		setPenColor();
		text(0.5, 0.25, "vs.");
		drawAttackerDice(attacker);
		drawDefenderDice(defender);
	}

	private static void drawDefenderDice(int defender) {
		int sum = 0;
		int x = 0;

		while (defender > x) {
			int roll = uniform(1, 7);

			sum += roll;

			setPenColor();
			text(0.45 - x * 0.05, 0.25, "" + roll);

			x++;

			if (defender > x) {
				text(0.475 - x * 0.05, 0.25, "+");
			}
		}

		text(0.475 - x * 0.05, 0.25, "=");
		text(0.45 - x * 0.05, 0.25, "" + sum);
	}

	public static void drawAttackerDice(int attacker) {
		int sum = 0;
		int x = 0;

		while (attacker > x) {
			int roll = uniform(1, 7);

			sum += roll;

			setPenColor();
			text(0.55 + x * 0.05, 0.25, "" + roll);

			x++;

			if (attacker > x) {
				text(0.525 + x * 0.05, 0.25, "+");
			}
		}

		text(0.525 + x * 0.05, 0.25, "=");
		text(0.55 + x * 0.05, 0.25, "" + sum);
	}

	public static void drawPlayers(Color[] player) {
		for (int i = 0; i < 7; i++) {

			int x = i + 1;

			setPenColor(player[i]);
			text(x * 0.125, 0.125, "Player " + x);

		}

		setPenColor();
		rectangle(uniform(1, 8) * 0.125, 0.125, 0.05, 0.02); // A random
																// player's turn
	}

	public static void drawBoard(int[][][] board, Color[] player) {

		setPenColor();

		for (double i = 0; i < 0.625; i += 0.125) {
			line(0.125, 0.875 - i, 0.875, 0.875 - i);
		}

		for (double i = 0; i < 0.875; i += 0.125) {
			line(0.125 + i, 0.875, 0.125 + i, 0.375);
		}

		for (int x = 0; x < COLUMNS; x++) {
			for (int y = 0; y < ROWS; y++) {

				setPenColor(player[board[x][y][0]]);
				filledCircle((x + 1) * 0.125, (y + 3) * 0.125, 0.04);

				setPenColor(WHITE);
				text((x + 1) * 0.125, (y + 3) * 0.125, "" + board[x][y][1]);

			}
		}
	}

	public static void randomizeBoard(int[][][] board) {
		for (int x = 0; x < COLUMNS; x++) {
			for (int y = 0; y < ROWS; y++) {

				board[x][y][0] = uniform(7);
				board[x][y][1] = uniform(1, 7);

			}
		}
	}

}
