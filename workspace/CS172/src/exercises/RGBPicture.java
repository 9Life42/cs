package exercises;

import edu.princeton.cs.introcs.*;
import java.awt.Color;

public class RGBPicture {
	
	public static void main(String[] args) {

		Picture r = new Picture("hedgehog.jpg");
		Picture g = new Picture("hedgehog.jpg");
		Picture b = new Picture("hedgehog.jpg");
		
		for (int x = 0; x < r.width(); x++) {
			for (int y = 0; y < r.height(); y++) {
				Color color = r.get(x, y);
				int red = color.getRed();
				color = new Color(red, 0, 0);
				r.set(x, y, color);
			}
		}
		
		r.show();
		
		for (int x = 0; x < g.width(); x++) {
			for (int y = 0; y < g.height(); y++) {
				Color color = g.get(x, y);
				int green = color.getGreen();
				color = new Color(0, green, 0);
				g.set(x, y, color);
			}
		}
		
		g.show();
		
		for (int x = 0; x < b.width(); x++) {
			for (int y = 0; y < b.height(); y++) {
				Color color = b.get(x, y);
				int blue = color.getBlue();
				color = new Color(0, 0, blue);
				b.set(x, y, color);
			}
		}
		
		b.show();
		
	}

}
