package dicewars;

import java.awt.Color;
import java.util.ArrayList;

public class Territory {
	
	private Player owner;
	private int dice;
	private boolean counted;
	private ArrayList<Territory> neighbors;
	// The ArrayList method allows me to use random territories in the future that are not laid out in a grid
	
	public Territory(Player owner, int dice) {
		this.owner = owner;
		this.dice = dice;
		neighbors = new ArrayList<Territory>();
	}
	
	public void addNeighbor(Territory t) {
		neighbors.add(t);
	}
	
	public ArrayList<Territory> getNeighbors() {
		return neighbors;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public Color getColor() {
		return owner.getColor();
	}

	public int getDice() {
		return dice;
	}

	public void addDice(int dice) {
		if (this.dice + dice > 8) {
			throw new IllegalArgumentException("You can't have more than eight dice on a territory.");
		}
		this.dice += dice;
	}
	
	public void setDice(int dice) {
		if (dice > 8) {
			throw new IllegalArgumentException("You can't have more than eight dice on a territory.");
		}
		this.dice = dice;
	}
	
	public boolean isOwnedBy(Player player) {
		if (player == owner)
			return true;
		return false;
	}
	
	public void counted(boolean b) {
		counted = b;
	}
	
	public boolean isCounted() {
		return counted;
	}

}
