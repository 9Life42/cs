package dicewars;

import java.awt.Color;

public class Territory {
	
	private Player owner;
	
	private int dice;
	
	public Territory(Player owner, int dice) {
		this.owner = owner;
		this.dice = dice;
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

}
