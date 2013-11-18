package dicewars;

import static edu.princeton.cs.introcs.StdDraw.*;
import static edu.princeton.cs.introcs.StdRandom.uniform;
import static java.lang.Math.abs;

import java.awt.Color;

public class Game {
	
	/** Define a new player color */
	public static final Color PURPLE = new Color(130, 0, 180);
	
	/** Define a new player color */
	public static final Color RED = new Color(255, 27, 44);
	
	/** Define a new player color */
	public static final Color ORANGE = new Color(255, 115, 0);
	
	/** Define a new player color */
	public static final Color PINK = new Color(252, 90, 170);
	
	/** Define a new player color */
	public static final Color GREEN = new Color(0, 210, 0);
	
	/** Define a new player color */
	public static final Color BLUE = new Color(0, 125, 255);

	/** Define a new player color */
	public static final Color YELLOW = new Color(255, 200, 0);
	
	/** true while the game is on */
	private boolean gaming;
	
	/** Number of players */
	private int numberOfPlayers;
	
	/** The array of players */
	private Player[] players;
	
	/** The player who's turn it is */
	private int playerUp;
	
	/** The game map */
	private final Territory[][] map;

	/** The number of columns in the map */
	private final int columns = 7;
	
	/** The number of rows in the map */
	private final int rows = 5;
	
	public Game(int numberOfPlayers) {
		gaming = true;
		this.numberOfPlayers = numberOfPlayers;
		
		players = new Player[numberOfPlayers];
		players[0] = new Player(PURPLE);
		players[1] = new Player(RED);
		players[2] = new Player(ORANGE);
		players[3] = new Player(PINK);
		players[4] = new Player(GREEN);
		players[5] = new Player(BLUE);
		players[6] = new Player(YELLOW);
		
		playerUp = 0;
		
		map = new Territory[columns][rows];
		buildMap();
	}
	
	public boolean getGaming() {
		return gaming;
	}

	public Player[] getPlayers() {
		return players;
	}
	
	public Player getPlayerUpObject() {
		return players[playerUp];
		// Note to self: watch out for when players can be eliminated
	}
	
	public int getPlayerUp() {
		return playerUp;
	}
	
	public Territory getTerritory(int c, int r) {
		return map[c][r];
	}
	
	public Territory[][] getMap() {
		return map;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public int getRows() {
		return rows;
	}

	/**
	 * Randomizes the map
	 */
	private void buildMap() {
		for (int c = 0; c < columns; c++) {
			for (int r = 0; r < rows; r++) {
				map[c][r] = new Territory(players[uniform(players.length)], uniform(1, 7));
			}
		}
	}
	
	/**
	 * Switch to the next player
	 * 
	 * @return Next player
	 */
	public void nextPlayerUp() {
		if (playerUp + 1 == numberOfPlayers)
			playerUp = 0;
		else
		playerUp += 1;
	}
	
	public boolean legal(int attColumn, int attRow, int defColumn, int defRow) {
		
		if (map[attColumn][attRow].getDice() <= 1)
			// If the attacker only has one die
			return false;

		if (abs(attColumn - defColumn) + abs(attRow - defRow) != 1)
			// Test if the territories are touching
			return false;

		if (map[attColumn][attRow] == map[defColumn][defRow])
			// Tests if the color is the same
			return false;

		return true;
	}
	
	public void attack(int attColumn, int attRow, int defColumn, int defRow) {
		if (legal(attColumn, attRow, defColumn, defRow)) {

			setPenColor();
			text(0.5, 0.25, "vs.");

			int att = attackerDice(map[attColumn][attRow].getDice());
			int def = defenderDice(map[defColumn][defRow].getDice());

			if (att > def) {
				text(0.5, 0.2, "Attacker wins!");
			} else {
				text(0.5, 0.2, "Defender wins!");
			}

			show(2000);
		}
	}
	
	/**
	 * Roll and draw the defender's dice (the draw component will be moved to GUI in the following version)
	 * 
	 * @param defender The number of dice on the defender's territory
	 * @return The sum of the defender's dice rolls
	 */
	public int defenderDice(int defender) {
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

	/**
	 * Roll and draw the attacker's dice (the draw component will be moved to GUI in the following version)
	 * 
	 * @param attacker The number of dice on the attacker's territory
	 * @return The sum of the attacker's dice rolls
	 */
	public int attackerDice(int attacker) {
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
	
	public int countAdjacent(Player player) {
		//TODO
		return -1;
	}
		
	public void distributeDice(Player player, int dice) {
		// TODO
	}

}

