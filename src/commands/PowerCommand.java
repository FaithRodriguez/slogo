package commands;

import java.util.List;

import backend.UserMethodManager;
import backend.VariableManager;

public class PowerCommand extends AbstractCommand {

	private static final Integer NUM_OF_EXPRESSIONS = 1;
	
	public PowerCommand(String instruction, VariableManager variables,
			UserMethodManager methods) {
		super(instruction, variables, methods, NUM_OF_EXPRESSIONS);
	}

	@Override
	public Double getValue(List<Object> args) {
		return Math.pow((Double) args.get(0), (Double) args.get(1));
	}
}