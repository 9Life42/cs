package assignments;
import static edu.princeton.cs.introcs.StdIn.*;
import static edu.princeton.cs.introcs.StdOut.*;
import static edu.princeton.cs.introcs.StdRandom.*;

public class Pig {

	public static void main(String[] args) {
		
		int player0score = 0; // Initial scores
		int player1score = 0;
		int playerUp = 0; // The player who's turn it is
		boolean gameOn = true; // Start the game
		
		while (gameOn) { // Check that the game is still going
			
			println("Score: " + player0score + "-" + player1score + "."); // First, print the current score
			
			int points = 0; // The points in this round
			boolean turn = true; // Start the turn
			
			while (turn) { // Check that it's still their turn
				
				int diceRoll = uniform(1,7); // Roll the dice
				
				println("Player " + playerUp + ", you rolled a " + diceRoll + "."); // Print out the dice roll
				
				if (diceRoll > 1) { // Check that the roll was greater than one
					
					points += diceRoll; // Add the dice roll to the points this round
				
					println("You have " + points + " points.");
					print("Keep going (y/n)? ");
					
					if (readLine().equals("n")) turn = false; // Check if the player wants to keep going and end the turn if they don't
					
				} else { // If the number rolled isn't greater than 1 then it must be 1 and the turn is over
					
					points = 0; // Set the points back to zero so they don't get added to the total score
					turn = false; // End the turn
					
				}
			}
			
			if (playerUp == 0) { // If Player 0 is up
				
				player0score += points; // add the points from this round to the total for Player 0
				playerUp = 1; // and then let the other player have their turn
				
			} else { // Else it must be Player 1's turn so we do the same thing, but for Player 1
				
				player1score += points;
				playerUp = 0;
				
			}
			
			println();
			
			if((player0score >= 100)||(player1score >= 100)) gameOn = false; // If one of the players has accumulated 100 points then the game is over
			
		}
		
		println("Game over. Final score: " + player0score + "-" + player1score + "."); // Once the game is over print the final score
		
	}
}
