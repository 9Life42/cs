package mastermind;

import static edu.princeton.cs.introcs.StdRandom.uniform;

public class Game {

	private final char[] choices = { 'r', 'o', 'y', 'b', 'g', 'v' };

	private String code;

	private String cdeo;

	private String[] guess = new String[10];

	private int guesses = 0;

	public Game() {
		code = "";
		for (int i = 0; i < 4; i++) {
			code += choices[uniform(choices.length)];
		}
		cdeo = sort(code);
	}

	public Game(String code) {
		this.code = code;
		cdeo = sort(code);
	}

	public String sort(String string) {
		char[] a = string.toCharArray();

		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j - 1] > (a[j])) {
					char c = a[j];
					a[j] = a[j - 1];
					a[j - 1] = c;
				}
			}
		}

		String s = "";
		for (int i = 0; i < a.length; i++) {
			s += a[i];
		}

		return s;
	}

	public int getNumberOfBlackPegs(String guess) {
		int black = 0;
		for (int i = 0; i < guess.length(); i++) {
			if (code.charAt(i) == guess.charAt(i)) {
				black++;
			}
		}
		return black;
	}

	public int getNumberOfWhitePegs(String guess) {
		int white = 0;
		String egssu = sort(guess);
		int i = 0;
		int j = 0;
		while (i < cdeo.length() && j < egssu.length()) {
			if (cdeo.charAt(i) == egssu.charAt(j)) {
				white++;
				i++;
				j++;
			} else if (cdeo.charAt(i) > egssu.charAt(j)) {
				j++;
			} else {
				i++;
			}
		}
		
		white -= getNumberOfBlackPegs(guess);
		
		return white;
	}

	public void guess(String guess) {
		this.guess[guesses] = guess;
		guesses++;
	}

	public int getNumberOfGuessesMade() {
		return guesses;
	}

	public String getGuess(int i) {
		return guess[i];
	}

	public boolean isWon() {
		if (guesses > 0 && guess[guesses - 1].equals(code))
			return true;
		return false;
	}

	public boolean isLost() {
		if (!isWon() && guesses > 9)
			return true;
		return false;
	}

	public String getCorrect() {
		return code;
	}

}
