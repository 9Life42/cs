package hex;

import java.awt.Color;
import static edu.princeton.cs.introcs.StdDraw.*;
import static java.lang.Math.*;

/** Graphic user interface for the Hex game. */
public class Gui {

	/** Background color for the board. */
	public static final Color DARK_GREEN = new Color(0, 63, 0);

	/** Edit this to change the board size. */
	public static void main(String[] args) {
		new Gui(8).run();
	}

	/** The game itself. */
	private Game game;

	/** Radius of a hexagon, in pixels. */
	private double radius;

	/** X coordinates of hex centers. */
	private double[][] xs;

	/** Y coordinates of hex centers. */
	private double[][] ys;

	public Gui(int width) {
		game = new Game(width);
		radius = 1.0 / (width * 3);
		xs = new double[width][width];
		ys = new double[width][width];
		double r = radius; // To shorten formulae
		double a = r * cos(PI / 6);
		double b = r * sin(PI / 6);
		for (int row = 0; row < width; row++) {
			for (int column = 0; column < width; column++) {
				xs[row][column] = a * (3 + row + (2 * column));
				ys[row][column] = 1.0 - ((r + b) * (row + (game.getWidth() / 2.0)));
			}
		}
	}

	/** Returns the Euclidean distance between x1, y1 and x2, y2. */
	protected double distance(double x1, double y1, double x2, double y2) {
		double dx = x1 - x2;
		double dy = y1 - y2;
		return sqrt(dx * dx + dy * dy);
	}

	/** Draws the current state of the game. */
	protected void draw() {
		clear(DARK_GREEN);
		int width = game.getWidth();
		for (int r = 0; r < width; r++) {
			for (int c = 0; c < width; c++) {
				Color color;
				if (game.getColor(r, c) == Game.BLACK) {
					color = BLACK;
				} else if (game.getColor(r, c) == Game.WHITE) {
					color = WHITE;
				} else {
					color = GRAY;
				}
				drawHex(color, r, c);
			}
		}
		int winner = game.findWinner();
		if (winner == Game.BLACK) {
			setPenColor(BLACK);
			filledRectangle(0.5, 0.0, 0.5, 0.05);
			filledRectangle(0.5, 1.0, 0.5, 0.05);
		} else if (winner == Game.WHITE) {
			setPenColor(WHITE);
			filledRectangle(0.0, 0.5, 0.05, 0.5);
			filledRectangle(1.0, 0.5, 0.05, 0.5);
		}
		show(0);
	}

	/** Draws a particular hex. */
	protected void drawHex(Color color, int row, int column) {
		double r = radius; // To shorten formulae
		double a = r * cos(PI / 6);
		double b = r * sin(PI / 6);
		double x = xs[row][column];
		double y = ys[row][column];
		// Make hexes slightly smaller to leave borders between them
		a *= 0.9;
		b *= 0.9;
		r *= 0.9;
		double[] cornerXs = { x, x - a, x - a, x, x + a, x + a };
		double[] cornerYs = { y + r, y + b, y - b, y - r, y - b, y + b };
		setPenColor(color);
		filledPolygon(cornerXs, cornerYs);
	}

	/**
	 * Plays the game.
	 */
	public void run() {
		while (game.findWinner() == Game.VACANT) {
			draw();
			while (!mousePressed()) {
				// Wait for mouse click
			}
			// Figure out which hex the user clicked on
			double x = mouseX();
			double y = mouseY();
			double shortest = Double.POSITIVE_INFINITY;
			int bestR = -1;
			int bestC = -1;
			for (int r = 0; r < game.getWidth(); r++) {
				for (int c = 0; c < game.getWidth(); c++) {
					double d = distance(x, y, xs[r][c], ys[r][c]);
					if (d < shortest) {
						shortest = d;
						bestR = r;
						bestC = c;
					}
				}
			}
			// Play the move (if legal)
			if (game.getColor(bestR, bestC) == Game.VACANT) {
				game.playAt(bestR, bestC);
			}
			while (mousePressed()) {
				// Wait for mouse release
			}
		}
		draw();
	}

}
