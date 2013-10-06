package assignments;
import static edu.princeton.cs.introcs.StdRandom.*;
import static edu.princeton.cs.introcs.StdDraw.*;
import java.io.*;
import java.util.*;

/** A word game. */
public class Hangman {

	/** Returns true if known contains no underscores. */
	public static boolean complete(char[] known) {
		for (int i = 0; i < known.length; i++) {
			if (known[i] == '_') return false; // Just returns false as soon as it finds an underscore
		}
		return true; // If it makes it to this point, then it didn't find any underscores
	}

	/**
	 * Draws the state of the game.
	 */
	public static void draw(int guesses, char[] known, String word) {
		clear();
		line(0.1, 0.3, 0.5, 0.3);
		line(0.3, 0.3, 0.3, 0.8);
		line(0.3, 0.8, 0.5, 0.8);
		line(0.5, 0.8, 0.5, 0.7);
		if (guesses < 6) { // Head
			circle(0.5, 0.65, 0.05);
		}
		if (guesses < 5) { // Torso
			line(0.5, 0.6, 0.5, 0.5);
		}
		if (guesses < 4) { // Left arm
			line(0.5, 0.6, 0.4, 0.6);
		}
		if (guesses < 3) { // Right arm
			line(0.5, 0.6, 0.6, 0.6);
		}
		if (guesses < 2) { // Left leg
			line(0.5, 0.5, 0.4, 0.4);
		}
		if (guesses < 1) { // Right leg
			line(0.5, 0.5, 0.6, 0.4);
		}
		String s = "" + known[0];
		for (int i = 1; i < known.length; i++) {
			s += " " + known[i];
		}
		text(0.5, 0.2, s);
		if (guesses == 0) {
			text(0.5, 0.1, "You lose. The word was '" + word + "'.");
		} else if (complete(known)) {
			text(0.5, 0.1, "You win!");
		} else {
			text(0.5, 0.1, guesses + " guesses left");
		}
		show(0);
	}

	/**
	 * Returns true if letter occurs at least once in word. The corresponding
	 * elements of known are set to letter.
	 */
	public static boolean found(char letter, String word, char[] known) {
		boolean changed = false;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == letter) { // Look for the letter in the string
				known[i] = letter; // Change the corresponding element in the character array
				changed = true; // And indicate that something was changed
			}
		}
		return changed;
	}

	public static void main(String[] args) {
		String[] dictionary = readDictionary();
		String word = randomWord(dictionary);
		int guesses = 6;
		char[] known = new char[word.length()];
		for (int i = 0; i < known.length; i++) {
			known[i] = '_';
		}
		while (guesses > 0 && !complete(known)) {
			draw(guesses, known, word);
			while (!hasNextKeyTyped()) {
				// Wait for keypress
			}
			char letter = nextKeyTyped();
			if (!found(letter, word, known)) {
				guesses--;
			}
		}
		draw(guesses, known, word);
	}

	/** Returns a random word from the dictionary. */
	public static String randomWord(String[] dictionary) {
		int pick = uniform(dictionary.length); // Choose a random number within the bounds of the array
		return dictionary[pick]; // Return the corresponding element
	}

	/** Reads and returns the dictionary. */
	public static String[] readDictionary() {
		try {
			Scanner input = new Scanner(new File("enable1.txt"));
			ArrayList<String> dictionary = new ArrayList<String>();
			while (input.hasNextLine()) {
				String word = input.nextLine();
				if (word.equals(word.toLowerCase())) {
					dictionary.add(word);
				}
			}
			return dictionary.toArray(new String[dictionary.size()]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}

}
