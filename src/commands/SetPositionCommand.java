package commands;


import backend.VariableManager;
import coordinate.Coordinate;

public class SetPositionCommand extends AbstractCommand {
	
	private static final Integer NUM_OF_EXPRESSIONS = 2;

	public SetPositionCommand(String instruction, VariableManager manager) {
		super(instruction, manager, NUM_OF_EXPRESSIONS);
	}
	
	public Double calculateValue() {
		return null;//setPosition();
	}

	@Override
	public Double getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double executeCommand() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	private Double setPosition() {
		Double updatedX = (Double) myArguments.get(0);
		Double updatedY = (Double) myArguments.get(1);
		Coordinate coord = new Coordinate(updatedX, updatedY);
		Double distance = calcDistance(coord, new Coordinate(myTurtle.getX(), myTurtle.getY()));
		moveTurtle(coord);
		return distance;
		
	}
	**/

}
