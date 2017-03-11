package commands;

import java.util.ArrayList;
import java.util.List;

import backend.UserMethodManager;
import backend.Variable;
import backend.VariableManager;

public abstract class LoopCommand extends AbstractCommand {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2305722461849866639L;
	private static final Integer NUM_OF_EXPRESSIONS = 2;
	protected Command myListCommand;

	public LoopCommand(String instruction, VariableManager variables, UserMethodManager methods) {
		super(instruction, variables, methods, NUM_OF_EXPRESSIONS);
		setRunAllTurtles(true);
	}

	@Override
	public Double getValue(List<Object> args, VariableManager vars) {
		int k = 0;
		Double returnValue = 0.0;
		while (k < args.size()) {
			myListCommand = (Command) args.get(k + 1);
			returnValue = calculate((List<Object>) args.get(k), vars);
			k += NUM_OF_EXPRESSIONS;
		}
		return returnValue;
	}

	protected abstract Double calculate(List<Object> args, VariableManager vars);

	protected Double runCommands(Double start, Double end, Double increment, Variable var, VariableManager vars,
			Double k) {
		Double returnValue = 0.0;
		for (int i = start.intValue(); i < end.intValue() + 1; i += increment.intValue()) {
			if (var != null) {
				vars.addVariable(new Variable(var.getVariableName(), (double) i));
			}
			myListCommand.resetCommand();
			returnValue = myListCommand.executeCommand(getTurtleManager(), vars, k);
		}
		return returnValue;
	}

	@Override
	protected ArrayList<Object> argumentsToConvert(VariableManager vars) {
		ArrayList<Object> convArgs = new ArrayList<Object>();
		getArguments().stream().forEach(c -> {
			if (getArguments().indexOf(c) % 2 == 0) {
				convArgs.add(c.getAllArguments());
			} else {
				convArgs.add(c);
			}
		});
		return convArgs;
	}
}
