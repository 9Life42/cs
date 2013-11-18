package mastermind;

public class Game {
	
	public Game() {
		// TODO Auto-generated constructor stub
	}

	public Game(String string) {
		// TODO Auto-generated constructor stub
	}

	public Object sort(String string) {
		char[] a = string.toCharArray();
		
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j-1] > (a[j])) {
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

	public Object getNumberOfBlackPegs(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void guess(String string) {
		// TODO Auto-generated method stub
		
	}

	public Object getNumberOfGuessesMade() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getGuess(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isWon() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isLost() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getCorrect() {
		// TODO Auto-generated method stub
		return null;
	}

}
