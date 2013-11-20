package dicewars;

import static edu.princeton.cs.introcs.StdDraw.*;

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
		while (game.getGaming()) {
			while (true) {
				
				clear();
				drawMap();
				drawPlayers();
				show(0);

				MouseClick mc1 = new MouseClick(game.getMap());
				int attColumn = mc1.getColumn();
				int attRow = mc1.getRow();
				
				if (mc1.onEndTurn()) {
					game.nextPlayerUp();
					break;
				} else if (mc1.onMap()
						&& game.getTerritory(attColumn, attRow).isOwnedBy(game.getPlayerUpObject())) {
					// If the click is on the map and the correct
					// player is selected, continue
					redrawTerritory(attColumn, attRow);
				} else {
					break;
				}

				MouseClick mc2 = new MouseClick(game.getMap());
				int defColumn = mc2.getColumn();
				int defRow = mc2.getRow();

				if (mc2.onEndTurn()) {
					game.nextPlayerUp();
					break;
				} else if (mc2.onMap()
						&& !game.getTerritory(defColumn, defRow).isOwnedBy(game.getPlayerUpObject())) {
					// If the click is on the map and an enemy is
					// selected, fight
					redrawTerritory(defColumn, defRow);
					game.attack(attColumn, attRow, defColumn, defRow);
				} else {
					break;
				}
			}
		}
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
			text(x * 0.125, 0.1, "" + players[i].getAdjacentTerritories());
		}

		setPenColor();
		rectangle((game.getPlayerUp() + 1) * 0.125, 0.15, 0.05, 0.02);
		// Player up indicator

		filledRectangle(0.5, 0.05, 0.07, 0.02);
		setPenColor(WHITE);
		text(0.5, 0.05, "End Turn");

		show(0);
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

		show(0);
	}
}
