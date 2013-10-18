package dicewars;

public class Version1 {

	public static void main(String[] args) {

	}
	// TODO decide if an attack is legal or not
	public static boolean legal(int[][][] board, int attColumn, int attRow, int defColumn, int defRow) {
//		if (attColumn < 0 || defColumn < 0)
//			return false;
//		if (attColumn > 6 || defColumn > 6)
//			return false;
//		if (attRow < 0 || defRow < 0)
//			return false;
//		if (attRow > 6 || defRow > 6)
//			return false;
		
		if (Math.abs(attColumn - defColumn) != 1)
			return false;
		
		if (board[attColumn][attRow][0] == board[defColumn][defRow][0]) // Tests if the color is the same
			return false;
		
		return true;
	}
	
	// TODO determine the winner of a battle
	
	// TODO count the number of adjacent territories owned by each player
	
}
