package drawing;

import java.awt.Color;

public class RectangleButtonListener extends ShapeButtonListener implements Command {

	public RectangleButtonListener(Drawing drawing, CounterShape cpt){
		super(drawing, cpt);
	}
	
	@Override
	protected Shape createShape() {
		double width = Math.abs(destination.getX()-origin.getX());
		double height = Math.abs(destination.getY()-origin.getY());
		Rectangle r = new Rectangle(origin, (int)width, (int)height, Color.BLUE);
		return r;
	}

	@Override
	public void execute() {
		drawing.clear();
		drawing.addShape(null);
		drawing.removeMouseListener(this);
		drawing.repaint();
	}

	@Override
	public void undo() {
		drawing.remove(drawing.lengthList()-1);
		drawing.repaint();
	}

}
