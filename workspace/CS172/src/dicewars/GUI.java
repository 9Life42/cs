package dicewars;

import static edu.princeton.cs.introcs.StdDraw.*;
import static edu.princeton.cs.introcs.StdRandom.*;

public class GUI {

	public static void main(String[] args) {
		new GUI().run();
	}

	/** Game associated with this GUI. */
	private Game game;
	/** Game associated with this GUI. */
	private Player winner;

	public GUI() {
		setCanvasSize(768, 768);
	}

	public void run() {

		while (true) {

			int size = 7;
			while (true) {
				drawSplash(size);
				
				MouseClick mc = new MouseClick();
				double x = mc.getX();
				double y = mc.getY();
				
				if (mc.onButton()) {
					game = new Game(size);
					break;
				} else if (y < 0.18 && y > 0.12) {
					
					for (int i = 1; i < 8; i++) {
						if (Math.abs(x - ((1 + 2 * i) * 0.0555)) < 0.03)
							size = i + 1;
					}
				}
			}

			clear();
			setPenColor();
			text(0.5, 0.5, "Prepare yourself...");
			show(1500);

			while (game.isGaming()) {
				while (true) {
					if (!game.isGaming()) {
						winner = game.getPlayerUp();
						break;
					}

					drawBoard("Choose one of your territories to attack with.");
					show(0);

					MouseClick mc1 = new MouseClick(game.getMap());
					int attColumn = mc1.getColumn();
					int attRow = mc1.getRow();

					if (mc1.onButton()) {
						drawBoard("");
						endTurn();
						break;
					} else if (mc1.onMap()
							&& game.getTerritory(attColumn, attRow).isOwnedBy(
									game.getPlayerUp())) {
						// If the click is on the map and the correct
						// player is selected, continue
						drawBoard("Now choose an adjacent enemy territory to attack.");
						redrawTerritory(attColumn, attRow);
						show(0);
					} else {
						break;
					}

					MouseClick mc2 = new MouseClick(game.getMap());
					int defColumn = mc2.getColumn();
					int defRow = mc2.getRow();

					if (mc2.onButton()) {
						drawBoard("");
						endTurn();
						break;
					} else if (mc2.onMap()
							&& !game.getTerritory(defColumn, defRow).isOwnedBy(
									game.getPlayerUp())) {
						// If the click is on the map and an enemy is
						// selected, fight

						if (game.legal(attColumn, attRow, defColumn, defRow)) {
							drawBoard("");
							redrawTerritory(attColumn, attRow);
							redrawTerritory(defColumn, defRow);
							show(0);

							attack(attColumn, attRow, defColumn, defRow);

						} else {
							drawBoard("Not a valid territory...");
						}
						show(1500);
					} else {
						break;
					}
				}
			}

			drawEnd(winner);

			while (true) {
				MouseClick mc = new MouseClick();
				if (mc.onButton())
					break;
			}

		}
	}

	public void drawSplash(int size) {
		clear();
		setPenColor();
		text(0.5, 0.975, "DICEWARS!");
		
		textLeft(0.0, 0.9, "Dicewars is a game of strategy.");
		textLeft(0.0, 0.85, "Each territory has between 1 and 8 dice.");
		textLeft(
				0.0,
				0.8,
				"If your territory has more than 1 die on it, you may attack a neighboring territory.");
		textLeft(0.0, 0.75,
				"The winner of an attack is determined by random dice rolls.");
		textLeft(0.0, 0.7, "If you win, all but one of your dice advance.");
		textLeft(0.0, 0.65,
				"If you loose, you lose all but one of your dice on the attacking territory.");
		textLeft(
				0.0,
				0.6,
				"When your turn is over you will get new dice randomly distributed to your territories.");
		textLeft(
				0.0,
				0.55,
				"The number of dice distributed is equivalent to your largest clump of connected territories.");
		textLeft(0.0, 0.5, "To win, you must eliminate all other players...");
		textLeft(0.0, 0.4, "How many players would you like to have?");

		int origin = 1;

		for (int i = 1; i < 8; i++) {
			int x = origin + 2 * i;
			text(x * 0.0555, 0.15, "" + (i + 1));
		}

		origin += (size - 1) * 2;

		setPenColor(RED);
		circle(origin * 0.0555, 0.15, 0.02);
		// Number of players selector

		drawButton("Play!");

		show(0);

	}

	public void drawEnd(Player winner) {
		clear();
		setPenColor(winner.getColor());
		text(0.5, 0.5, "Well done Player " + winner.getNumber() + "! You Won!");

		drawButton("Play Again!");

		show(0);
	}

	public void drawButton(String label) {
		setPenColor();
		filledRectangle(0.5, 0.05, 0.07, 0.02);
		setPenColor(WHITE);
		text(0.5, 0.05, label);
	}

	public void drawBoard(String string) {
		clear();
		drawMap();
		drawPlayers();

		setPenColor();
		text(0.5, 0.2, string);
	}

	public void drawMap() {
		clear();
		setPenColor();
		text(0.5, 0.975, "DICEWARS!");
		// May want to change the location of this eventually...

		for (double i = 0; i < 0.625; i += 0.125) {
			line(0.125, 0.875 - i, 0.875, 0.875 - i);
		}

		for (double i = 0; i < 0.875; i += 0.125) {
			line(0.125 + i, 0.875, 0.125 + i, 0.375);
		}

		for (int x = 0; x < game.getColumns(); x++) {
			for (int y = 0; y < game.getRows(); y++) {

				setPenColor(game.getTerritory(x, y).getColor());
				filledCircle((x + 1) * 0.125, (y + 3) * 0.125, 0.04);

				setPenColor(WHITE);
				text((x + 1) * 0.125, (y + 3) * 0.125,
						"" + game.getTerritory(x, y).getDice());

			}
		}
	}

	public void drawPlayers() {
		Player[] players = game.getPlayers();
		int origin = 10 - players.length;

		for (int i = 0; i < players.length; i++) {
			int x = origin + 2 * i;

			setPenColor(players[i].getColor());
			text(x * 0.0555, 0.15, "Player " + players[i].getNumber());
			text(x * 0.0555, 0.1, "" + players[i].getAdjacentTerritories());
			// Temp
		}

		origin += game.getPlayerIndexUp() * 2;

		setPenColor();
		rectangle(origin * 0.0555, 0.15, 0.05, 0.02);
		// Player up indicator

		drawButton("End Turn");
	}

	public void redrawTerritory(int column, int row) {
		setPenColor(BLACK);
		filledCircle((column + 1) * 0.125, (row + 3) * 0.125, 0.04);

		setPenRadius(0.01);
		setPenColor(game.getTerritory(column, row).getColor());
		circle((column + 1) * 0.125, (row + 3) * 0.125, 0.04);

		setPenRadius();
		setPenColor(WHITE);
		text((column + 1) * 0.125, (row + 3) * 0.125,
				"" + game.getTerritory(column, row).getDice());
	}

	public void attack(int attColumn, int attRow, int defColumn, int defRow) {
		int attDice = game.getTerritory(attColumn, attRow).getDice();
		int defDice = game.getTerritory(defColumn, defRow).getDice();

		setPenColor();
		text(0.5, 0.25, "vs");

		int attSum = 0;
		int i = 0;
		int roll;
		for (; i < attDice; i++) {
			roll = uniform(1, 7);
			attSum += roll;
			// More interesting dice to come...
			text(0.55 + i * 0.05, 0.25, "" + roll);
			text(0.575 + i * 0.05, 0.25, "+");
		}
		roll = uniform(1, 7);
		attSum += roll;
		text(0.55 + i * 0.05, 0.25, "" + roll);
		i++;

		text(0.525 + i * 0.05, 0.25, "=");
		text(0.55 + i * 0.05, 0.25, "" + attSum);

		int defSum = 0;
		i = 0;
		for (; i < defDice; i++) {
			roll = uniform(1, 7);
			defSum += roll;
			text(0.45 - i * 0.05, 0.25, "" + roll);
			text(0.425 - i * 0.05, 0.25, "+");
		}
		roll = uniform(1, 7);
		defSum += roll;
		text(0.45 - i * 0.05, 0.25, "" + roll);
		i++;

		text(0.475 - i * 0.05, 0.25, "=");
		text(0.45 - i * 0.05, 0.25, "" + defSum);

		if (attSum > defSum) {
			text(0.5, 0.2, "Attacker wins!");
			game.won(attColumn, attRow, defColumn, defRow);
		} else {
			text(0.5, 0.2, "Defender wins!");
			game.lost(attColumn, attRow, defColumn, defRow);
		}
	}

	public void endTurn() {
		int adj = game.getPlayerUp().getAdjacentTerritories();
		int back = game.getPlayerUp().getBackDice();
		int dice = adj + back;
		setPenColor();
		if (back > 0) {
			text(0.5, 0.2, "You get " + adj + " and " + back + " back dice.");
		} else {
			text(0.5, 0.2, "You get " + adj + " dice.");
		}
		show(0);

		game.distributeDice(dice);
		game.nextPlayerUp();
		show(1000);
	}
}
