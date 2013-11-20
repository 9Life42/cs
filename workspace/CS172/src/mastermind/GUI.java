package mastermind;

import static edu.princeton.cs.introcs.StdDraw.*;
import java.awt.Color;

public class GUI {

	public static Color VIOLET = new Color(102, 0, 153);

	public static void main(String[] args) {
		new GUI().run();
	}

	/** Game model associated with this GUI. */
	private Game game;

	/** Question or instructions for the user. */
	private String label;

	public GUI() {
		game = new Game();
		label = "";
	}

	private void drawGuess(Color color, double x, double y) {

		setPenColor(color);
		filledCircle(x, y, 0.03);

	}

	private void drawPins(int black, int white, double y) {

		setPenColor(BLACK);
		filledCircle(.8, y, 0.03);
		setPenColor(WHITE);
		text(.8, y, "" + black);

		setPenColor(BLACK);
		circle(.9, y, 0.03);
		text(.9, y, "" + white);

	}

	/** Waits for the user to press a key, then returns that character. */
	protected char waitForKey() {
		while (!hasNextKeyTyped()) {
			// Wait for keypress
		}
		return nextKeyTyped();
	}

	public void run() {

		double x = 0.1;
		double y = 0.9;
		double dx = 0.075;
		double dy = 0.075;

		label = "Press letter keyes (r, o, y, g, b, v) to guess";

		text(.5, .1, label);

		while (!game.isWon() && !game.isLost()) {

			String guess = "";

			for (int i = 0; i < 4; i++) {

				char key = waitForKey();

				if (key == 'r') {
					guess += key;
					drawGuess(RED, x + i * dx, y);
				} else if (key == 'o') {
					guess += key;
					drawGuess(ORANGE, x + i * dx, y);
				} else if (key == 'y') {
					guess += key;
					drawGuess(YELLOW, x + i * dx, y);
				} else if (key == 'g') {
					guess += key;
					drawGuess(GREEN, x + i * dx, y);
				} else if (key == 'b') {
					guess += key;
					drawGuess(BLUE, x + i * dx, y);
				} else if (key == 'v') {
					guess += key;
					drawGuess(VIOLET, x + i * dx, y);
				} else {
					i--;
				}
			}

			game.guess(guess);
			drawPins(game.getNumberOfBlackPegs(guess),
					game.getNumberOfWhitePegs(guess), y);

			y -= dy;

		}

		setPenColor(WHITE);
		filledRectangle(.5, .1, .5, .075);
		setPenColor(BLACK);

		if (game.isWon()) {
			text(.5, .1, "You won!");
		} else {
			text(.5, .1, "Sorry, you lost. Here is the answer:");
			char[] c = game.getCorrect().toCharArray();
			for (int i = 0; i < c.length; i++) {

				if (c[i] == 'r') {
					drawGuess(RED, x + i * dx, 0);
				} else if (c[i] == 'o') {
					drawGuess(RED, x + i * dx, 0);
				} else if (c[i] == 'y') {
					drawGuess(YELLOW, x + i * dx, 0);
				} else if (c[i] == 'g') {
					drawGuess(GREEN, x + i * dx, 0);
				} else if (c[i] == 'b') {
					drawGuess(BLUE, x + i * dx, 0);
				} else if (c[i] == 'v') {
					drawGuess(VIOLET, x + i * dx, 0);
				} else {
					i--;
				}
			}
		}
	}
}
