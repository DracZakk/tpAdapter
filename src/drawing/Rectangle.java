package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape {
	
	int width;
	int height;
	Color color;
	String text;
	
	public Rectangle(Point origin, int width, int height, Color color){
		this.origin = origin;
		this.width = width;
		this.height = height;
		this.color = color;
		this.text = null;
	}
	
	public Rectangle(Point origin, int width, int height, Color color, String text){
		this.origin = origin;
		this.width = width;
		this.height = height;
		this.color = color;
		this.text = text;
	}
	
	public boolean isOn(Point p) {
		return(p.x > origin.x && p.x < origin.x+width && p.y > origin.y && p.y < origin.y+height);
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(origin.x, origin.y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(origin.x, origin.y, width, height);
		if (this.text != null) {
			g.drawString(text, (int)origin.x + width/2-70, (int)origin.y + height/2);
		}
	}

	@Override
	public Point origin(){
		return this.origin;
	}

	@Override
	public Shape duplicateShape() {
		return new Rectangle(this.origin,this.width,this.height,this.color);
	}
	
	public String getText() {
		return text;
	}
	
	@Override
	public void setText(String text) {
		this.text = text;
	}
}
