package sandbox.raycasting;

import java.util.ArrayList;
import java.util.List;

import sandbox.geometry.Position;

public class Entity {

	
	public final int SIZE = 10;
	public final int RAY_AMT = 100;
	
	private Position pos;
	private List<Ray> rays = new ArrayList<>();
	
	public Entity(int x, int y) {
		pos = new Position(x,y);
		
		for(float i = 0; i<360; i+= 360.0/RAY_AMT) {
			rays.add(new Ray(pos, Math.toRadians(i)));
		}
	}
	
	public void updatePos(int x, int y) {
		pos.update(x,y);
	}

	public Position getPos() {
		return pos;
	}
	
	public List<Ray> getRays() {
		return rays;
	}
	
}
