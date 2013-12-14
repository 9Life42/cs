package dicewars;

import static edu.princeton.cs.introcs.StdDraw.*;

public class MouseClick {
	
	private double x;
	private double y;
	private boolean onMap;
	private boolean onButton;
	private int column;
	private int row;
	
	public MouseClick() {
		while (!mousePressed()) { }
		x = mouseX();
		y = mouseY();
		while (mousePressed()) { }
		
		if (x > 0.43 && x < 0.57 && y > 0.03 && y < 0.07) {
			onButton = true;
		}
	}
	
	public MouseClick(Territory[][] map) {
		while (!mousePressed()) { }
		x = mouseX();
		y = mouseY();
		while (mousePressed()) { }
		
		column = -1;
		row = -1;
		
		// Find row
		for (int r = 0; r < map[0].length; r++) {
			if (y > (r + 3) * 0.125 - 0.04 && y < (r + 3) * 0.125 + 0.04)
				row = r;
			// Note to self: watch out for different board sizes/shapes
		}
		
		// Find column
		for (int c = 0; c < map.length; c++) {
			if (x > (c + 1) * 0.125 - 0.04 && x < (c + 1) * 0.125 + 0.04)
				column = c;
			// Note to self: watch out for different board sizes/shapes
		}
		
		if (column > -1 && row > -1) {
			onMap = true;
		}
		
		if (x > 0.43 && x < 0.57 && y > 0.03 && y < 0.07) {
			onButton = true;
		}

	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public boolean onMap() {
		return onMap;
	}
	
	public boolean onButton() {
		return onButton;
	}
	
	public int getColumn() {
		return column;
	}
	
	public int getRow() {
		return row;
	}
	
}
