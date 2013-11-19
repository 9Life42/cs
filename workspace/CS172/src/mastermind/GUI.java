package mastermind;

public class GUI {

	public static void main(String[] args) {
		new GUI().run();
	}

	/** Game model associated with this GUI. */
	private Game game;

	/** Question or instructions for the user. */
	private String label;

	/** The text currently being entered by the user. */
	private String textBeingEntered;

	public GUI() {
		game = new Game();
		label = "";
		textBeingEntered = "";
	}

	/** Draws the state of the game. */
	protected void draw() {

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
