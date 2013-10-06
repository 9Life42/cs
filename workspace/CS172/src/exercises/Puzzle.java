package exercises;

public class Puzzle {
	public static String display(int[][] grid) {
		String numbers = "";
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				
				if (grid[i][j] == -1) {
					numbers += ".";
				} else {
				numbers += grid[i][j];
				}
		}
			numbers += "\n";
		}
		return numbers;
	}

	public static int[][] solution() {
		return new int[][] {{0,1,2},{3,4,5},{6,7,-1}};
	}

	public static void north(int[][] testgrid) {
		for (int i = 0; i < testgrid.length; i++) {
			for (int j = 0; j < testgrid[0].length; j++) {
				if (testgrid[i][j] == -1) {
					testgrid[i][j] = testgrid[i-1][j];
					testgrid[i-1][j] = -1;
				}
					
			}
		}
		
	}
}
