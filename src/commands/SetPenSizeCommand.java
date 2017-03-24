package commands;

import java.util.List;

import backend.UserMethodManager;
import backend.VariableManager;

/**
 * SetPenSizeCommand, a subclass of AbstractCommand
 * @author Yanbo Fang
 * @author Henry Taylor
 */
public class SetPenSizeCommand extends AbstractCommand {

	private static final long serialVersionUID = 3242226893608105750L;
	private static final int NUM_OF_EXPRESSIONS = 1;
	
	public SetPenSizeCommand(String instruction, VariableManager variables,
			UserMethodManager methods) {
		super(instruction, variables, methods, NUM_OF_EXPRESSIONS);
	}

	@Override
	public Double getValue(List<Object> args, VariableManager localVariables) {
		Double value = (Double) args.get(args.size()-1);
		getTurtleManager().setPenSize(value, getTurtle().getID());
		return value;
	}

}
