package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButtonListener implements ActionListener {

	Drawing drawing;
	CounterShape cpt;
	
	public ClearButtonListener(Drawing drawing, CounterShape cpt){
		this.drawing = drawing;
		this.cpt = cpt;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		drawing.clear();
		String command = arg0.getActionCommand();
		if(command == "Clear") {
			cpt.clearCounterShape();
		}
	}

}
