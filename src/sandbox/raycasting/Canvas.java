package sandbox.raycasting;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import sandbox.geometry.Line;
import sandbox.geometry.Position;

public class Canvas extends JPanel {
	
	private Frame frame;
	private Entity entity;
	
	public Canvas(Frame f, Entity e) {
		frame = f;
		entity = e;
		
		setBackground(Color.BLACK);
		setCursor( getToolkit().createCustomCursor(
                new BufferedImage( 1, 1, BufferedImage.TYPE_INT_ARGB ),
                new Point(),
                null ) );	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
	
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setStroke(new BasicStroke(1));

		//g2d.setColor(Color.WHITE);
		for(Ray ray : entity.getRays()) {
			Position savedPosition = null;
			
			for(Line line : frame.getLines()) {
				Position intersection = ray.cast(line);
				if(savedPosition != null){
					if(intersection != null) {
						if(	entity.getPos().distanceBetween(savedPosition) > 
							entity.getPos().distanceBetween(intersection)) {
							savedPosition = intersection;
						}
					}
				}else {
					savedPosition = intersection;
				}
			}
			
			if(savedPosition != null) {
				Color startColor = Color.white;
				
				double distance = (entity.getPos().distanceBetween(savedPosition));
				
				Color endColor = new Color(	startColor.getRed(),
											startColor.getGreen(),
											startColor.getBlue(),
											0);
				
				GradientPaint gradient = new GradientPaint( (int)entity.getPos().getX(), (int)entity.getPos().getY(), startColor, 
															(int)(entity.getPos().getX() - ray.getLength().getSource().getX()),(int)(entity.getPos().getY() + ray.getLength().getSource().getY()), endColor);
			    g2d.setPaint(gradient);
				
				
				//g2d.setColor(Color.WHITE);
				g2d.drawLine((int)entity.getPos().getX(), (int)entity.getPos().getY(), (int)savedPosition.getX(),(int) savedPosition.getY());
			}
		}
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(3));
		for(Line line : frame.getLines()) {
			g2d.drawLine((int)line.getX1(), (int)line.getY1(), (int)line.getX2(), (int)line.getY2());
		}
	}
}
