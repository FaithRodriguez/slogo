package backend;

import java.util.Arrays;
import java.util.List;

import turtles.Turtle;
import turtles.TurtleManager;
import commands.Command;
import javafx.scene.Node;
import interfaces.ModelInterface;

public class Model implements ModelInterface {

	private VariableManager myVariables;
	private UserMethodManager myUserMethods;
	private TurtleManager myTurtles;
	private Parser myParser;
	private CommandHandler myCommandHandler;

	public Model(String[] syntax, VariableManager variables, UserMethodManager methods, TurtleManager turtles) {
		myVariables = variables;
		myUserMethods = methods;
		myTurtles = turtles;
		myParser = new Parser(syntax, this, myVariables, myUserMethods);
		myCommandHandler = new CommandHandler(myTurtles, myVariables);
	}

	@Override
	public void handleInput(String input) {
		List<Command> commands = myParser.parse(input);
		for (Command c : commands) {
			if (c instanceof Command) {
				c.resetCommand();

			}
		}
		myCommandHandler.addCommands(commands);
		// myCommandHandler.executeCommands();
	}

	// The actual call from the simulation to get the next and move the turtle
	@Override
	public Double getNextPos() {
		Double current = myCommandHandler.executeCommands();
		while (current != null) {
			current = myCommandHandler.executeCommands();
		}
		return current;
	}

	@Override
	public void updateVariable(String var, String value) {
		myVariables.addVariable(new Variable(var, Double.parseDouble(value)));
	}

	// USED FOR PARSER
	public Double getVariable(String var) {
		try {
			return myVariables.get(var).getValue();
		} catch (Exception e) {
			return null;
		}
	}
	/*
	 * public Command getMethodVariable(String var) { try { return
	 * myUserMethods.getUserMethodCommand(var); } catch (Exception e) { return
	 * null; } } <<<<<<< HEAD
	 * 
	 * // public void executeCommand(Command c) { // c.executeCommand(myTurtle,
	 * myVariables); // }
	 * 
	 * =======
	 */
}
