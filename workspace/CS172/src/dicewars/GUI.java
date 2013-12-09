package dicewars;

import static edu.princeton.cs.introcs.StdDraw.*;
import static edu.princeton.cs.introcs.StdRandom.*;

public class GUI {
	
	public static void main(String[] args) {
		new GUI().run();
	}
	
	/** Game associated with this GUI. */
	private Game game;
	
	public GUI() {
		setCanvasSize(768, 768);
		game = new Game(7);
	}

	private void run() {
		while (game.isGaming()) {
			while (true) {
				
				drawBoard("Choose one of your territories to attack with.");
				show(0);

				MouseClick mc1 = new MouseClick(game.getMap());
				int attColumn = mc1.getColumn();
				int attRow = mc1.getRow();
				
				if (mc1.onEndTurn()) {
					drawBoard("");
					endTurn();
					break;
				} else if (mc1.onMap()
						&& game.getTerritory(attColumn, attRow).isOwnedBy(game.getPlayerUp())) {
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

				if (mc2.onEndTurn()) {
					drawBoard("");
					endTurn();
					break;
				} else if (mc2.onMap()
						&& !game.getTerritory(defColumn, defRow).isOwnedBy(game.getPlayerUp())) {
					// If the click is on the map and an enemy is
					// selected, fight
					
					if (game.legal(attColumn, attRow, defColumn, defRow)) {
						drawBoard("");
						redrawTerritory(attColumn, attRow);
						redrawTerritory(defColumn, defRow);
						show(0);
						
						attack(attColumn, attRow, defColumn, defRow);
					} else {
						drawBoard("Not a valid territory to attack.");
					}
					show(1500);
				} else {
					break;
				}
			}
		}
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
		text(0.5, 0.975, "DICE WARS!");
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
				text((x + 1) * 0.125, (y + 3) * 0.125, "" + game.getTerritory(x, y).getDice());

			}
		}
	}
	
	public void drawPlayers() {
		Player[] players = game.getPlayers();

		for (int i = 0; i < 7; i++) {
			int x = i + 1;

			setPenColor(players[i].getColor());
			text(x * 0.125, 0.15, "Player " + x);
			text(x * 0.125, 0.1, "" + players[i].getTerritoriesOwned() + ":" + players[i].getNumberOfDice());
			// Temp
		}

		setPenColor();
		rectangle((game.getPlayerNumberUp() + 1) * 0.125, 0.15, 0.05, 0.02);
		// Player up indicator

		filledRectangle(0.5, 0.05, 0.07, 0.02);
		setPenColor(WHITE);
		text(0.5, 0.05, "End Turn");
	}
	
	public void redrawTerritory(int column, int row) {
		setPenColor(BLACK);
		filledCircle((column + 1) * 0.125, (row + 3) * 0.125,
				0.04);

		setPenRadius(0.01);
		setPenColor(game.getTerritory(column, row).getColor());
		circle((column + 1) * 0.125, (row + 3) * 0.125, 0.04);

		setPenRadius();
		setPenColor(WHITE);
		text((column + 1) * 0.125, (row + 3) * 0.125, ""
				+ game.getTerritory(column, row).getDice());
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
			// TODO: More interesting dice
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
		int adj = game.countTerritories();
		int back = game.getPlayerUp().getBackDice();
		int dice = adj + back;
		setPenColor();
		if (back > 0){
			text(0.5, 0.2, "You get " + adj + " and " + back + " back dice.");
		} else {
			text(0.5, 0.2, "You get " + adj + " dice.");
		}
		show();
		
		game.distributeDice(dice);
		game.nextPlayerUp();
		show(1000);
	}
}
