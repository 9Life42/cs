package questions;

import static edu.princeton.cs.introcs.StdDraw.*;

/** GUI for the Questions game. */
public class Gui {

	/** Radius of circles drawn for nodes. */
	public static final double CIRCLE_RADIUS = 0.01;

	public static void main(String[] args) {
		new Gui().run();
	}

	/** Game model associated with this GUI. */
	private Game game;

	/** Question or instructions for the user. */
	private String label;

	/** The text currently being entered by the user. */
	private String textBeingEntered;

	public Gui() {
		game = new Game();
		label = "";
		textBeingEntered = "";
	}

	/** Draws the state of the game. */
	protected void draw() {
		clear();
		text(0.5, 0.9, label);
		text(0.5, 0.8, textBeingEntered);
		double yDecrement = 0.5 / (game.getRoot().height() + 1);
		drawSubtree(game.getRoot(), 0.5 - yDecrement / 2, yDecrement, 0.0, 1.0);
		show(0);
	}

	/**
	 * Draws the subtree rooted at node.
	 * 
	 * @param y
	 *            y coordinate at which to draw node.
	 * @param yDecrement
	 *            amount to decrease y coordinate for each level of the tree.
	 * @param left
	 *            left boundary of drawing space for this subtree.
	 * @param right
	 *            right boundary of drawing space for this subtree.
	 */
	protected void drawSubtree(Node node, double y, double yDecrement,
			double left, double right) {
		// TODO You have to write this.
	}

	/**
	 * Reads a String from the user, displaying it as they type and allowing
	 * backspaces.
	 */
	protected String readString() {
		while (true) {
			draw();
			char pressed = waitForKey();
			if (pressed == '\n') {
				String result = textBeingEntered;
				textBeingEntered = "";
				return result;
			} else if (pressed == '\b') {
				textBeingEntered = textBeingEntered.substring(0,
						textBeingEntered.length() - 1);
			} else {
				textBeingEntered += pressed;
			}
		}
	}

	/** Plays games until the user chooses to quit. */
	public void run() {
		while (true) {
			// Descend through the tree to a leaf
			game.reset();
			while (!game.atLeaf()) {
				label = game.getQuestion();
				draw();
				game.descend(waitForKey() == 'y');
			}
			// Now node is a leaf; handle end of game
			label = game.getQuestion();
			draw();
			if (waitForKey() == 'y') {
				label = "I win! Would you like to play again? (y/n)";
			} else {
				label = "I give up! What was it?";
				String correct = readString();
				label = game.getLearningQuestion(correct);
				String question = readString();
				game.learn(correct, question);
				label = "Would you like to play again? (y/n)";
			}
			draw();
			if (waitForKey() != 'y') {
				System.exit(0);
			}
		}
	}

	/** Waits for the user to press a key, then returns that character. */
	protected char waitForKey() {
		while (!hasNextKeyTyped()) {
			// Wait for keypress
		}
		return nextKeyTyped();
	}

}
