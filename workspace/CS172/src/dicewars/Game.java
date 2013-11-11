package dicewars;

import java.awt.Color;

public class Game {
	
	/** Define a new player color */
	public static final Color PURPLE = new Color(130, 0, 180);
	
	/** Define a new player color */
	public static final Color RED = new Color(255, 27, 44);
	
	/** Define a new player color */
	public static final Color ORANGE = new Color(255, 115, 0);
	
	/** Define a new player color */
	public static final Color PINK = new Color(252, 90, 170);
	
	/** Define a new player color */
	public static final Color GREEN = new Color(0, 210, 0);
	
	/** Define a new player color */
	public static final Color BLUE = new Color(0, 125, 255);

	/** Define a new player color */
	public static final Color YELLOW = new Color(255, 200, 0);
	
	/** Number of players */
	private int numberOfPlayers;
	
	private Player[] players;
	
	public Game(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
		
		this.players = new Player[numberOfPlayers];
	}

}
