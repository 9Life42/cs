package dicewars;

import static edu.princeton.cs.introcs.StdDraw.*;

public class mouseClick {
	
	private double x;
	
	private double y;
	
	private int column;
	
	private int row;
	
	public mouseClick() {
		while (!mousePressed()) { }
		
		x = mouseX();
		y = mouseY();
		
		while (mousePressed()) { }
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getColumn() {
		return column;
	}
	
	public double getRow() {
		return row;
	}
}
