package dicewars;

import static edu.princeton.cs.introcs.StdDraw.*;

public class mouseClick {
	
	private double x;
	
	private double y;
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public mouseClick() {
		while (!mousePressed()) { }
		
		x = mouseX();
		y = mouseY();
		
		while (mousePressed()) { }
	}
}
