package drawing;

import java.awt.*;

public class Circle extends Shape{
	private Color color;
	private double radius;
	String text;
	
	public Circle(Point origin, double radius, Color color){
		this.origin = origin;
		this.radius = radius;
		this.color = color;
	}
	
	public Circle(Point origin, double radius, Color color, String text){
		this.origin = origin;
		this.radius = radius;
		this.color = color;
		this.text = text;
	}
	
	public void paint(Graphics g){
		g.setColor(color);
		g.fillOval((int)(origin.getX()-radius), (int)(origin.getY()-radius), (int)(2*radius), (int)(2*radius));
		g.setColor(Color.BLACK);
		g.drawOval((int)(origin.getX()-radius), (int)(origin.getY()-radius), (int)(2*radius), (int)(2*radius));
		if (this.text != null) {
			g.drawString(text, (int)(origin.x - (radius /2) - 35), origin.y);
		}
	}
	
	public boolean isOn(Point p) {
		return distanceToCenter(p)<radius;		
	}
	
	private double distanceToCenter(Point p){
		return this.origin.distance(p);
	}

	@Override
	public Point origin(){
		return this.origin;
	}

	@Override
	public Shape duplicateShape() {
		return new Circle(this.origin,this.radius,this.color);
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}
	


}
