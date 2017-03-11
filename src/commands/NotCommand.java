package commands;

import java.util.List;

import backend.UserMethodManager;
import backend.VariableManager;

public class NotCommand extends AbstractCommand {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1527221261143527933L;
	private static final Integer NUM_OF_EXPRESSIONS = 1;
	
	public NotCommand(String instruction, VariableManager variables,
			UserMethodManager methods) {
		super(instruction, variables, methods, NUM_OF_EXPRESSIONS);
	}

	@Override
	public Double getValue(List<Object> args, VariableManager vars) {
		Double exp1 = (Double) args.get(args.size()-1);
		if (exp1 == 0.0) {
			setValue(1.0);
		} else {
			setValue(0.0);
		}
		return getValue();
	}

}
