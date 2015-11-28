package drawing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DuplicateButtonListener implements ActionListener {
	Drawing drawing;
	CounterShape cpt;
	Shape shape;
	
	public DuplicateButtonListener(Drawing drawing, CounterShape cpt) {
		this.drawing = drawing;
		this.cpt = cpt;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		drawing.duplication();
		String command = arg0.getActionCommand();
		if(command == "Duplicate") {
			cpt.incrementRectangle();
			cpt.incrementCircle();
		}
	}
}
