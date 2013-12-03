package focus;

import static focus.Game.*;
import focus.Game;
import static edu.princeton.cs.introcs.StdDraw.*;
import java.awt.Color;

/** Graphic user interface for the Focus game. */
public class Gui {

	/** Color used to draw the squares. */
	public static final Color LIGHT_BLUE = new Color(127, 127, 255);

	public static void main(String[] args) {
		new Gui().run();
	}

	/** The associated game instance. */
	private Game game;

	public Gui() {
		game = new Game();
	}

	/** Draws the state of the game, including instructions. */
	protected void draw(String instructions) {
		clear();
		for (int r = 0; r < BOARD_WIDTH; r++) {
			for (int c = 0; c < BOARD_WIDTH; c++) {
				drawSquare(game.getPile(new Location(r, c)), 1.5 + c, 9.5 - r);
			}
		}
		setPenColor(LIGHT_BLUE);
		filledRectangle(2, 0.5, 2, 0.45);
		filledRectangle(8, 0.5, 2, 0.45);
		setPenColor();
		text(2, 0.5, "Black reserves: " + game.getReserves(Game.BLACK));
		text(8, 0.5, "White reserves: " + game.getReserves(Game.WHITE));
		text(5, 1.5, instructions);
		show(0);
	}

	/** Draws one square (and any pieces piled there) at coordinates x, y. */
	protected void drawSquare(Deque<Integer> pile, double x, double y) {
		if (pile != null) {
			setPenColor(LIGHT_BLUE);
			filledSquare(x, y, 0.45);
			x -= 0.2;
			y -= 0.2;
			for (int c : pile) {
				setPenColor(c == Game.BLACK ? Color.BLACK : Color.WHITE);
				filledEllipse(x, y, 0.2, 0.1);
				setPenColor(c == Game.BLACK ? Color.WHITE : Color.BLACK);
				ellipse(x, y, 0.2, 0.1);
				x += 0.1;
				y += 0.1;
			}
		}
	}

	/**
	 * Returns "Black" or "White" as appropriate.
	 */
	protected String getColorToPlay() {
		return game.getColorToPlay() == Game.BLACK ? "Black" : "White";
	}

	/** Plays the game. */
	public void run() {
		setXscale(0, 10);
		setYscale(0, 10);
		show(0);
		while (!game.isGameOver()) {
			draw(getColorToPlay()
					+ ", click on one of your piles or your reserves.");
			Location source;
			do {
				source = waitForClick();
			} while (source == null || !game.isLegalSource(source));
			draw(getColorToPlay() + ", click on destination square.");
			Location destination;
			do {
				destination = waitForClick();
			} while (destination == null
					|| !game.isLegalMove(source, destination));
			game.move(source, destination);
			game.toggleColorToPlay();
		}
		game.toggleColorToPlay();
		draw(getColorToPlay() + " wins.");
	}

	/**
	 * Waits for the user to click and returns the location where they clicked
	 * (which might be one of Game.RESERVES_LOCATIONS). For invalid locations,
	 * may return null.
	 */
	protected Location waitForClick() {
		while (!mousePressed()) {
			// Wait for mouse press
		}
		double x = mouseX();
		double y = mouseY();
		while (mousePressed()) {
			// Wait for mouse release
		}
		// This catches some clicks on the background as if they were on one of
		// the reserve buttons, but handles valid clicks correctly
		if (y <= 2.0) {
			if (x < 5) {
				return RESERVES_LOCATIONS[Game.BLACK];
			}
			return RESERVES_LOCATIONS[Game.WHITE];
		}
		Location result = new Location((int) (10.0 - y), (int) (x - 1.0));
		if (game.isOnBoard(result)) {
			return result;
		}
		return null;
	}

}
