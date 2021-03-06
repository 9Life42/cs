package exercises;

public class RecursiveLnFactorial {
	
	public static void main(String[] args){
	System.out.println(lnF(8));
	System.out.println(Math.log(factorial(8)));
	
	}
	
	public static double lnF(int n) {
		if (n == 1) return 0;
		return lnF(n-1) + Math.log(n);
	}

	public static int factorial(int n) {
		if (n == 1) return 1;
		return n * factorial(n-1);
	}
}