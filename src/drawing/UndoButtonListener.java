package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UndoButtonListener implements ActionListener {
	
	Drawing drawing;
	UndoRedo undoRedo;
	
	public UndoButtonListener(Drawing drawing) {
		this.drawing = drawing;
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command == "Undo"){
			undoRedo.undo();
			drawing.repaint();
		}
	}
}
