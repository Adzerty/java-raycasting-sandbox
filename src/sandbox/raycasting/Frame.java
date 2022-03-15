package sandbox.raycasting;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import sandbox.geometry.Line;
import sandbox.geometry.Position;

public class Frame extends JFrame{

	public final int HEIGHT = 700;
	public final int WIDTH  = 1000;
	
	private static final Frame instance = new Frame();
	private Entity entity;
	
	private List<Line> lines = new ArrayList<>();
	
	private Canvas canvas;
	
	private Renderer renderer;
	
	private Frame() {
		super("Java Raycasting");
		
		entity = new Entity(WIDTH/2, HEIGHT/2);
		canvas = new Canvas(this, entity);
		
		canvas.addMouseMotionListener(new MouseMotionMoveAdapter());
		
		renderer = new Renderer();

		
		initWalls();

		add(canvas);
		
		Thread t = new Thread(renderer);
		t.start();
		
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		//this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initWalls() {
		//Murs
		lines.add(new Line(new Position(0,0), new Position(0,HEIGHT)));
		lines.add(new Line(new Position(0,HEIGHT), new Position(WIDTH,HEIGHT)));
		lines.add(new Line(new Position(WIDTH,HEIGHT), new Position(WIDTH,0)));
		lines.add(new Line(new Position(WIDTH,0), new Position(0,0)));
		
		for(int i = 0; i < 3; i++) {
			double x1 = Math.random()*WIDTH;
			double x2 = Math.random()*WIDTH;
			double y1 = Math.random()*HEIGHT;
			double y2 = Math.random()*HEIGHT;
			
			lines.add(new Line(new Position(x1,y1), new Position(x2,y2)));
		}

	}
	
	public void draw() {	
		canvas.repaint();
	}
	
	public static Frame getInstance() {
		return instance;
	}
	
	
	public List<Line> getLines(){
		return lines;
	}
	
	private class MouseMotionMoveAdapter extends MouseMotionAdapter{
		public void mouseMoved(MouseEvent me) {
			entity.updatePos(me.getX(), me.getY());
		}
	}
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->Frame.getInstance());
	}
}
