package drawing;

import java.util.Stack;

public class UndoRedo {
	Stack<Command> undo = new Stack<Command>();
	Stack<Command> redo = new Stack<Command>();
	
	public void undo() {
		assert(undo.size() != 0);
		if (undo.size() != 0) {
			Command command = undo.pop();
			command.undo();
			redo.push(command);
		}
	}
	
	public void redo() {
		assert(redo.size() != 0);
		if (redo.size() != 0) {
			Command command = redo.pop();
			command.execute();
			undo.push(command);
		}
	}
}
