package sandbox.geometry;

public class Line {

	private Position start;
	private Position end;
	
	public Line(Position s, Position e) {
		start = s;
		end   = e;
	}
	
	public Position getStart() {
		return start;
	}
	
	public Position getEnd() {
		return end;
	}
	
	public double getX1() {
		return start.getX();
	}
	public double getX2() {
		return end.getX();
	}
	
	public double getY1() {
		return start.getY();
	}
	public double getY2() {
		return end.getY();
	}
}
