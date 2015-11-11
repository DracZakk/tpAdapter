package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterController implements ActionListener{
	Drawing d;
	
	public CounterController(Drawing d) {
		this.d = d;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		d.addShape(null);
	}

}
