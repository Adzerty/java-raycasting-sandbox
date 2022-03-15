package sandbox.raycasting;

import sandbox.geometry.Line;
import sandbox.geometry.Position;
import sandbox.geometry.Vector;

public class Ray {
	public static final double EPSILON = 0.00001;
	public static final double MAX_DISTANCE = 300.0;

	private Position position;
	private Vector direction;
	private Vector length;
	
	public Ray(Position pos, double angle) {
		position = pos;
		direction = new Vector(angle);
		length = new Vector(angle, MAX_DISTANCE);
	}
	
	public Vector getLength() {
		return length;
	}
	
	public Position cast(Line l) {
		double x1 = l.getX1();
		double y1 = l.getY1();
		double x2 = l.getX2();
		double y2 = l.getY2();
		
		double x3 = position.getX();
		double y3 = position.getY();
		double x4 = position.getX() + direction.getSource().getX();
		double y4 = position.getY() + direction.getSource().getY();
		
		double denominator = (x1 - x2)*(y3-y4)-(y1-y2)*(x3-x4);
		
		if(Math.abs(denominator) <= EPSILON) return null;
		
		double t = ( (x1 - x3)*(y3-y4)-(y1-y3)*(x3-x4) ) / denominator;
		double u = -( (x1 - x3)*(y1-y2)-(y1-y3)*(x1-x2) ) / denominator;
		
		if(t > 0 && t < 1 && u > 0) {
			return new Position(x1 + t * (x2 - x1), y1 + t * (y2 - y1));
		}
		
		return null;
		
	}
}
