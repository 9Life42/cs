package exercises;
import static edu.princeton.cs.introcs.StdDraw.*;

public class RecursionFractal {
	public static void main(String[] args) {
		
		setCanvasSize(768,768);
		
		double[] x = {0,1,0.5};
		double[] y = {0,0,1};
		int depth = 10;
		
		fractal(depth, x, y);
		

	}

	public static void fractal(int depth, double[] x, double[] y) {
		if (depth == 1) {
			polygon(x, y);
		} else {
			ll(depth, x, y);
			lr(depth, x, y);
			up(depth, x, y);
		}
		
	}

	public static void ll(int depth, double[] x, double[] y) {
		double[] xx = new double[3];
		double[] yy = new double[3];
				
		xx[0] = x[0];
		xx[1] = (x[0] + x[1])/2;
		xx[2] = (x[0] + x[2])/2;
		
		yy[0] = y[0];
		yy[1] = (y[0] + y[1])/2;
		yy[2] = (y[0] + y[2])/2;
		
		fractal(depth-1, xx, yy);
	}
	
	public static void lr(int depth, double[] x, double[] y) {
		double[] xx = new double[3];
		double[] yy = new double[3];
				
		xx[1] = x[1];
		xx[0] = (x[1] + x[0])/2;
		xx[2] = (x[1] + x[2])/2;
		
		yy[1] = y[1];
		yy[0] = (y[1] + y[0])/2;
		yy[2] = (y[1] + y[2])/2;
		
		fractal(depth-1, xx, yy);
	}
	
	public static void up(int depth, double[] x, double[] y) {
		double[] xx = new double[3];
		double[] yy = new double[3];
				
		xx[2] = x[2];
		xx[1] = (x[2] + x[1])/2;
		xx[0] = (x[2] + x[0])/2;
		
		yy[2] = y[2];
		yy[1] = (y[2] + y[1])/2;
		yy[0] = (y[2] + y[0])/2;
		
		fractal(depth-1, xx, yy);
	}
}
