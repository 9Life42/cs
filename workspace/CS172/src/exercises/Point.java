package exercises;

public class Point {

	private int x;

	private int y;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "<" + this.x + "," + this.y + ">";
	}
	
	public double distanceTo(Point that) {
		int dx = this.x - that.x;
		int dy = this.y - that.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public boolean equals(Object obj) {
		if (this  == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Point that = (Point)obj;
		return (this.x == that.x) && (this.y == that.y);
	}

	public static void main(String[] args) {

		Point a = new Point(2, 2);
		Point b = new Point(3, 7);

		System.out.println(a);
		System.out.println(b.toString());
		System.out.println(b.distanceTo(a));
		System.out.println(a.equals(b));
	}

}
