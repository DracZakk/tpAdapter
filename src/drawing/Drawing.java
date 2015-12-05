package drawing;

import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 * JPanel pouvant afficher des objets de type Shape
 */
public class Drawing extends JPanel implements Iterable<Shape> {

	private static final long serialVersionUID = 1L;
	ArrayList<Shape> shapes;
	ArrayList<Shape> shapesCloneList;
	
	public Drawing(){
		super();
		shapes = new ArrayList<Shape>();
		shapesCloneList = new ArrayList<Shape>();
	}
	
	/**
	 * Implementation de l'interface Iterable<Shape>
	 */
	public Iterator<Shape> iterator(){
		return shapes.iterator();
	}
	
	/**
	 * Ajoute une forme au dessin et redessine
	 */
	public void addShape(Shape s){
		shapes.add(s);
		this.repaint();
	}
	
	/** 
	 * Redefinition de la methode paintComponent() de JComponent
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Shape s : shapes){
			s.paint(g);
		}
		for(Shape s : shapesCloneList){
			s.paint(g);
		}
	}
	
	/**
	 * Enleve toutes les formes et redessine
	 */
	public void clear(){
		shapes.clear();
		shapesCloneList.clear();
		this.repaint();
	}
	
	public void duplication(){
		if (shapes.size() != 0){
			for (Shape shape : shapes){
				Shape clone = shape.duplicateShape();
				Point point = new Point(shape.origin());
				point.y += 120;
				clone.setOrigin(point);
				shapesCloneList.add(clone);
				System.out.println("shape is duplicated");
			}
			this.repaint();
		}
	}
	
	public int lengthList() {
		return shapes.size();
	}
	
	public void textShape(String name) {
		if (shapes.size() != 0) {
			for (Shape shape : shapes) {
				shape.setText(name);
			}
			this.repaint();
		}
		
		if (shapesCloneList.size() != 0) {
			for (Shape shapeClone : shapes) {
				shapeClone.setText(name);
			}
			this.repaint();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
