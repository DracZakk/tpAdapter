package drawing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

/**
 * Listener pour gerer la souris dans la zone de dessin
 */
public class DrawingMouseListener  extends CounterShape implements MouseMotionListener, MouseListener {

	Drawing drawing;
	Shape currentShape = null;
	
	Vector<Shape> shapeList = new Vector<Shape>();
	
	public DrawingMouseListener(Drawing d){
		drawing = d;
	}
	
	/**
	 * Bouge la forme selectionnee (si une forme est selectionnee)
	 */
	public void mouseDragged(MouseEvent e) {
		if(currentShape != null){
			currentShape.setOrigin(e.getPoint());
			drawing.repaint();
		}
		if(shapeList.size() != 0) {
			for(Shape shape : shapeList) {
				shape.setOrigin(e.getPoint());
				drawing.repaint();
			}
		}
	}
	
	/**
	 * Selectionne la forme sur laquelle l'utilisateur a clique
	 */
	public void mousePressed(MouseEvent e) {
		for(Shape s : drawing){
			if(s.isOn(e.getPoint())){
				currentShape = s;
				break;
			}
		}
	}

	/**
	 * Deselectionne la forme
	 */
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == 3) {
			currentShape = null;
			if (shapeList.size() != 0) {
				shapeList.clear();
				System.out.println("Objet deselectionne de la liste");
				
			}
		}
	}

	public void mouseMoved(MouseEvent e) {
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 1) {
			currentShape = null;
			for(Shape shape : drawing) {
				if (shape.isOn(e.getPoint())) {
					shapeList.add(shape);
					System.out.println("Liste d'objets selectionnes = " + shapeList.size());
				}
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

}
