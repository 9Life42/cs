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
	/** Define a new player color */
	public static final Color LIGHT_BLUE = new Color(0, 225, 255);

	public static final Color[] colors = { PURPLE, RED, ORANGE, PINK, GREEN,
			BLUE, YELLOW, LIGHT_BLUE };

	/** true while the game is on */
	private boolean gaming;
	/** The array of players */
	private Player[] players;
	/** The player who's turn it is */
	private int playerIndexUp;
	/** The game map */
	private final Territory[][] map;
	/** The number of columns in the map */
	private final int columns = 7;
	/** The number of rows in the map */
	private final int rows = 5;

	public Game(int numberOfPlayers) {
		gaming = true;
		players = new Player[numberOfPlayers];

		for (int i = 0; i < numberOfPlayers; i++) {
			players[i] = new Player(i + 1, colors[i]);
		}

		map = new Territory[columns][rows];
		buildMap();
		countTerritories();
	}

	public boolean isGaming() {
		return gaming;
	}

	public Player[] getPlayers() {
		return players;
	}

	public int getNumberOfPlayers() {
		return players.length;
	}

	public Player getPlayerUp() {
		return players[playerIndexUp];
	}

	public int getPlayerIndexUp() {
		return playerIndexUp;
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
	public void buildMap() {
		playerIndexUp = uniform(players.length);
		int open = rows * columns;
		
		while (open > 0) {
			int c = uniform(columns);
			int r = uniform(rows);
			if (map[c][r] == null) {
				int d = uniform(1, 5);
				map[c][r] = new Territory(players[playerIndexUp], d);
				players[playerIndexUp].incrementTerritoriesOwned();
				players[playerIndexUp].addNumberOfDice(d);
				nextPlayerUp();
				open--;
			}
		}
		
		playerIndexUp = 0;
	}

	/**
	 * Switch to the next player
	 * 
	 * @return Next player
	 */
	public void nextPlayerUp() {
		if (playerIndexUp < players.length - 1)
			playerIndexUp += 1;
		else
			playerIndexUp = 0;
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

	public void won(int attColumn, int attRow, int defColumn, int defRow) {
		Territory attacker = map[attColumn][attRow];
		Territory defender = map[defColumn][defRow];

		defender.getOwner().deincrementTerritoriesOwned();
		defender.getOwner().removeNumberOfDice(defender.getDice());
		if (defender.getOwner().getTerritoriesOwned() < 1)
			removePlayer(defender.getOwner().getNumber());

		defender.setOwner(getPlayerUp());
		defender.setDice(attacker.getDice() - 1);
		attacker.setDice(1);
		getPlayerUp().incrementTerritoriesOwned();

		if (players.length < 2)
			gaming = false;
	}

	public void lost(int attColumn, int attRow, int defColumn, int defRow) {
		text(0.5, 0.2, "Defender wins!");
		getPlayerUp().removeNumberOfDice(map[attColumn][attRow].getDice() - 1);
		map[attColumn][attRow].setDice(1);
	}

	public int countTerritories() {
		// return getPlayerUp().getTerritoriesOwned() / 2;
		return 100;
		// Temporary count
	}

	public void distributeDice(int dice) {

		int over = (getPlayerUp().getNumberOfDice() + dice)
				- (getPlayerUp().getTerritoriesOwned() * 8);

		if (over > 0) {
			getPlayerUp().setBackDice(over);
			dice -= over;
		} else {
			getPlayerUp().setBackDice(0);
		}

		getPlayerUp().addNumberOfDice(dice);

		while (dice > 0) {
			int c = uniform(columns);
			int r = uniform(rows);
			if (map[c][r].isOwnedBy(getPlayerUp()) && map[c][r].getDice() < 8) {
				map[c][r].addDice(1);
				dice--;
			}
		}
	}

	public void removePlayer(int player) {
		Player[] temp = new Player[players.length - 1];
		int x = 0;
		for (int i = 0; i < players.length; i++) {
			if (players[i].getNumber() != player) {
				temp[x] = players[i];
				x++;
			}
		}

		players = temp;
	}

}
