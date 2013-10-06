package exercises;
import static edu.princeton.cs.introcs.StdDraw.*;
import static java.awt.event.KeyEvent.*;

public class Pong {

	public static void main(String[] args) {

		double x = 0.5;
		double y = 0.5;
		double dx = 0.005;
		double p = 0.5;

		while (true) {
			
			if (isKeyPressed(VK_UP)) {
				p += 0.005;
			}
			if (isKeyPressed(VK_DOWN)) {
				p -= 0.005;
			}

			dx = bounce(x, y, dx, p);
			x = moveBall(x, dx);
			drawBall(x, y);
			drawPaddles(p);
			show(10);

		}

	}

	public static double moveBall(double x, double dx) {
		x += dx;
		return x;
	}

	public static double bounce(double x, double y, double dx, double p) {
		if (y < p + 0.1 && y > p - 0.1)
		{
		if (x < 0 || x > 1)
			{
			dx = -dx;
			}
		}
		return dx;
	}

	public static void drawBall(double x, double y) {
		clear();
		filledCircle(x, y, 0.01);
	}

	public static void drawPaddles(double p) {
		setPenRadius(.005);
		line(1, p- 0.1, 1, p + 0.1);
		line(0, p- 0.1, 0, p + 0.1);
	}

}
