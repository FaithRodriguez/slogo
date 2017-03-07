package commands;

import java.util.List;

import backend.UserMethodManager;
import backend.VariableManager;

public class HeadingCommand extends AbstractCommand {

	private static final Integer NUM_OF_EXPRESSION = 0;
	
	public HeadingCommand(String instruction, VariableManager variables,
			UserMethodManager methods) {
		super(instruction, variables, methods, NUM_OF_EXPRESSION);
		runAllTurtles = true;
	}

	

	public Double getValue(List<Object> args) {
		return myTurtle.getRotate();
	}

}
