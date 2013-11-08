package dicewars;

import java.awt.Color;

public class Player {
	
	private final Color color;
	
	private int adjacentTerritories;

	public Player(Color color) {
		this.color = color;
		adjacentTerritories = 0;
	}
	
	public int getAdjacentTerritories() {
		return adjacentTerritories;
	}
	
	public void setAdjacentTerritories(int adjacentTerritories) {
		this.adjacentTerritories = adjacentTerritories;
	}
	
	public Color getColor() {
		return color;
	}
	
}
