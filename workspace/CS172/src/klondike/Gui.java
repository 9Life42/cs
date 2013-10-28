package klondike;

import static edu.princeton.cs.introcs.StdDraw.*;
import static java.io.File.separator;
import static java.lang.Math.round;
import java.awt.Color;

/** Graphic user interface for the Klondike solitaire game. */
public class Gui {

	/** Color for the background. */
	public static final Color DARK_GREEN = new Color(0, 63, 0);

	public static void main(String[] args) {
		new Gui().run();
	}

	/** Game model associated with this GUI. */
	private Game game;

	/** True when waiting for a second mouse click. */
	private boolean waitingForSource;

	public Gui() {
		game = new Game();
		waitingForSource = true;
	}

	/**
	 * Displays the current state of the game.
	 */
	public void draw() {
		// Draw background
		clear(DARK_GREEN);
		// Draw cards
		draw(game.getDeck(), 1 / 8.0, 0.9, false);
		draw(game.getDrawPile(), 2 / 8.0, 0.9, false);
		for (int i = 0; i < 4; i++) {
			draw(game.getFoundation(i), (i + 4) / 8.0, 0.9, false);
		}
		for (int i = 0; i < 7; i++) {
			draw(game.getTableau(i), (i + 1) / 8.0, 0.7, true);
		}
		// Draw labels for foundations
		setPenColor(WHITE);
		text(4 / 8.0, 1.0, "C");
		text(5 / 8.0, 1.0, "S");
		text(6 / 8.0, 1.0, "H");
		text(7 / 8.0, 1.0, "D");
		// Draw instructions
		if (waitingForSource) {
			text(0.5, 0.0, "Click on deck, draw pile, or tableau.");
		} else {
			text(0.5, 0.0,
					"Click on destination, or on background to abort move.");
		}
		show(0);
	}

	/**
	 * Draws this deck at x, y. If splayed is false, only the top card is drawn.
	 * Otherwise, the cards appear splayed, with cards closer to the top of the
	 * deck lower on the screen but in front of other cards.
	 */
	public void draw(Deck deck, double x, double y, boolean splayed) {
		if (deck.size() == 0) {
			setPenColor(GRAY);
			filledRectangle(x, y, 0.05, 0.075);
		} else if (splayed) {
			for (int i = 0; i < deck.size(); i++) {
				picture(x, y, imageFilename(deck.get(i)), 0.1, 0.15);
				y -= 0.05;
			}
		} else {
			picture(x, y, imageFilename(deck.get(deck.size() - 1)), 0.1, 0.15);
		}
	}

	/**
	 * Returns the filename of the image for this card. All of the files (from
	 * http://www.jfitz.com/cards/) should be in a directory "card-images".
	 */
	public String imageFilename(Card card) {
		if (!card.isFaceUp()) {
			return "card-images" + separator + "b2fv.png";
		}
		int result = 1 + card.getSuit();
		if (card.getRank() > 1) {
			result += 4 * (14 - card.getRank());
		}
		return "card-images" + separator + result + ".png";
	}

	/** Returns the column of cards in which the mouse is located. */
	public int mouseColumn() {
		return (int) round(mouseX() * 8);
	}

	/** Plays the game. */
	public void run() {
		Deck source = null;
		while (true) {
			draw();
			while (!mousePressed()) {
				// Wait for mouse press
			}
			if (waitingForSource) {
				if (mouseY() > 0.8) { // Clicked above
					Deck drawPile = game.getDrawPile();
					if (mouseColumn() == 1) {
						game.drawNextCard();
					} else if ((mouseColumn() == 2) && (drawPile.size() > 0)) {
						source = drawPile;
						waitingForSource = false;
					}
				} else { // Clicked on tableau
					source = game.getTableau(mouseColumn() - 1);
					if (source.size() > 0) {
						waitingForSource = false;
					}
				}
			} else { // Waiting for destination
				waitingForSource = true;
				if (mouseY() > 0.8) { // Clicked above
					game.moveToFoundation(source, mouseColumn() - 4);
				} else { // Clicked on tableau
					game.moveToTableau(source, mouseColumn() - 1);
				}
			}
			while (mousePressed()) {
				// Wait for mouse release
			}
		}
	}

}
