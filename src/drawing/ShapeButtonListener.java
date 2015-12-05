package drawing;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Classe abstraite (Template Pattern) pour les listeners des boutons de
 * creation de formes.
 */
public abstract class ShapeButtonListener implements ActionListener, MouseListener, Command{

	Drawing drawing;
	Point origin;
	Point destination;
	
	CounterShape cpt;
	
	public ShapeButtonListener(Drawing drawing, CounterShape cpt){
		this.drawing = drawing;
		this.cpt = cpt;
	}
	
	/**
	 * Ajouter un MouseListener pour le type de forme courant
	 */
	public void actionPerformed(ActionEvent e) {
		drawing.addMouseListener(this);
		String command = e.getActionCommand();
		if(command == "Circle"){
			cpt.incrementCircle();
		}
		if(command == "Rectangle"){
			cpt.incrementRectangle();
		}
	}
	
	/**
	 * Une fois la souris relachee, cree la forme a la bonne dimension 
	 * et enleve le MouseListener.
	 * Template Pattern
	 */
	public void mouseReleased(MouseEvent arg0) {
		destination = arg0.getPoint();
		Shape s = createShape();
		drawing.addShape(s);
		drawing.removeMouseListener(this);
	}
	
	/**
	 * Retiens le point d'origine du mouvement de la forme.
	 */
	public void mousePressed(MouseEvent arg0) {
		origin = arg0.getPoint();
	}
	
	/**
	 * Methode de creation de la forme, a redefinir dans les sous classes.
	 * Template Pattern
	 */
	protected  abstract Shape createShape();
	public abstract void execute();
	public abstract void undo();

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}


}
