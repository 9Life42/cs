package exercises;

import edu.princeton.cs.introcs.*;

public class L33tsp34k {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		In in = new In("moby.txt");
		Out out = new Out("result.txt");
		while(in.hasNextLine()) {
			out.println(improve(in.readLine()));
		}

	}

	private static String improve(String s) {
		String result = s;
		result = result.replace("ate ", "8 ");
		result = result.replace("e", "3");
		result = result.replace("a", "4");
		result = result.replace("t", "7");
		result = result.replace("l", "1");
		result = result.replace("o", "0");
		result = result.replace("s", "5");
		result = result.replace(".", "!");
		return result;
	}

}
