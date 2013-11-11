package dicewars;

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

	public int getDice() {
		return dice;
	}

	public void addDice(int dice) {
		this.dice += dice;
	}

}
