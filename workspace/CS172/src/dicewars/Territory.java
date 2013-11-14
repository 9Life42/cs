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
		this.dice += dice;
	}
	
	public void setDice(int dice) {
		this.dice = dice;
	}
	
	public boolean equals(Player player) {
		if (player == owner)
			return true;
		return false;
	}

}
