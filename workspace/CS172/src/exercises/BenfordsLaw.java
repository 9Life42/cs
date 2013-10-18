package exercises;
import static edu.princeton.cs.introcs.StdOut.*;
import edu.princeton.cs.introcs.In;

public class BenfordsLaw {
	public static void main(String[] args) {
		int[] a = getNumbers();
		int[] digits = new int[10];
		
		for (int i = 0; i < a.length; i++) {
			digits[firstDigit(a[i])]++;
		}
		for (int i = 0; i < a.length; i++) {
			println(i + " " + digits[i]);
		}
	}
	
	public static int firstDigit(int n) {
		String s = "" + n;
		int result = Integer.parseInt(s.substring(0, 1));
		return result;
	}
	
	public static int[] getNumbers() {
		In file = new In("states.txt");
		int[] result = new int[file.readInt()];
		
		for(int i = 0; i < result.length; i++) {
			result[i] = file.readInt();
		}
		
		return result;
	}

}