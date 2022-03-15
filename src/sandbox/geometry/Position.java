package sandbox.geometry;

public class Position {

	private double x;
	private double y;
	
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void update(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public double distanceBetween(Position b) {
		double x2 = (b.x - x)*(b.x - x);
		double y2 = (b.y - y)*(b.y - y);
		return Math.sqrt( x2 + y2);
	}
	
	
	
	
	
}
