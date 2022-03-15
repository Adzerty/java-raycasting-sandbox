package sandbox.geometry;

public class Vector {

	private Position source;
	private double angle;
	
	public Vector(Position s, double a) {
		source = s;
		angle  = a;
	}
	
	public Vector(double a) {
		source = new Position(Math.cos(a),Math.sin(a));
		angle = a;

	}
	
	public Vector(double a, double length) {
		source = new Position(length * Math.cos(a), -(length * Math.sin(a)));
		angle = a;
	}
	
	public Position getSource() {
		return source;
	}
}
