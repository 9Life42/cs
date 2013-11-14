//package dicewars;
//
//import static edu.princeton.cs.introcs.StdDraw.setPenColor;
//import static edu.princeton.cs.introcs.StdDraw.show;
//import static edu.princeton.cs.introcs.StdDraw.text;
//import static edu.princeton.cs.introcs.StdRandom.uniform;
//import static java.lang.Math.abs;
//
//public class Map {
//	
//	private final int columns;
//	
//	private final int rows;
//	
//	private Territory[][] map;
//	
//	public Map(int columns, int rows, Player[] players) {
//		this.columns = columns;
//		this.rows = rows;
//		
//		// Randomize map
//		for (int x = 0; x < columns; x++) {
//			for (int y = 0; y < rows; y++) {
//				map[x][y] = new Territory(players[uniform(players.length)], uniform(1, 7));
//			}
//		}
//	}
//	
//	public Territory[][] getMap() {
//		return map;
//	}
//	
//	public int getColumns() {
//		return columns;
//	}
//	
//	public int getRows() {
//		return rows;
//	}
//	
//	private int countAdjacent(Player player) {
//		//TODO
//		return -1;
//	}
//	
//	public boolean legal(int attColumn, int attRow, int defColumn, int defRow) {
//		
//		if (map[attColumn][attRow].getDice() <= 1)
//			// If the attacker only has one die
//			return false;
//
//		if (abs(attColumn - defColumn) + abs(attRow - defRow) != 1)
//			// Test if the territories are touching
//			return false;
//
//		if (map[attColumn][attRow] == map[defColumn][defRow])
//			// Tests if the color is the same
//			return false;
//
//		return true;
//	}
//	
//	public void attack(int attColumn, int attRow, int defColumn, int defRow) {
//		if (legal(attColumn, attRow, defColumn, defRow)) {
//
//			setPenColor();
//			text(0.5, 0.25, "vs.");
//
//			int att = attackerDice(map[attColumn][attRow].getDice());
//			int def = defenderDice(map[defColumn][defRow].getDice());
//
//			if (att > def) {
//				text(0.5, 0.2, "Attacker wins!");
//			} else {
//				text(0.5, 0.2, "Defender wins!");
//			}
//
//			show(2000);
//	}
//		
//		public void distribute(Player player, int dice) {
//			// TODO
//		}
//
//}
