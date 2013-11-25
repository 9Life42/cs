package dicewars;

import java.awt.Color;

public class Player {
	
	private final Color color;
	
	private int adjacentTerritories;
	
	private int territoriesOwned;
	
	private int numberOfDice;
	
	private int backDice;

	public Player(Color color) {
		this.color = color;
		adjacentTerritories = 0;
		territoriesOwned = 0;
		numberOfDice = 0;
		backDice = 0;
	}
	
	public int getAdjacentTerritories() {
		return adjacentTerritories;
	}
	
	public void setAdjacentTerritories(int adjacentTerritories) {
		this.adjacentTerritories = adjacentTerritories;
	}
	
	public int getTerritoriesOwned() {
		return territoriesOwned;
	}
	
	public void setTerritoriesOwned(int territories) {
		territoriesOwned = territories;
	}
	
	public void incrementTerritoriesOwned() {
		territoriesOwned++;
	}
	
	public void deincrementTerritoriesOwned() {
		territoriesOwned--;
	}
	
	public int getNumberOfDice() {
		return numberOfDice;
	}
	
	public void setNumberOfDice(int dice) {
		numberOfDice = dice;
	}
	
	public void addNumberOfDice(int dice) {
		numberOfDice += dice;
	}
	
	public void removeNumberOfDice(int dice) {
		numberOfDice -= dice;
	}
	
	public int getBackDice() {
		return backDice;
	}
	
	public void setBackDice(int dice) {
		backDice = dice;
	}
	
	public Color getColor() {
		return color;
	}
	
}
