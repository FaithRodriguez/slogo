package commands;

import backend.VariableManager;
import coordinate.Coordinate;

public class SetTowardsCommand extends MoveCommand {
	
	private static final Integer NUM_OF_EXPRESSIONS = 2;

	public SetTowardsCommand(String instruction, VariableManager manager) {
		super(instruction, manager, NUM_OF_EXPRESSIONS);
	}
	
	public Double calculateValue() {
		return setTowards();
	}
	
	private Double setTowards() {

		Coordinate newDirection = new Coordinate((Double) myArguments.get(0), 
				(Double) myArguments.get(1));

		Coordinate neutralDirection = new Coordinate(myTurtle.getX(), myTurtle.getY()+10);
		Coordinate currentPosition = new Coordinate(myTurtle.getX(), myTurtle.getY());
		Double turtleToNew = calcDistance(newDirection, currentPosition);
		Double turtleToNeutral = calcDistance(neutralDirection, currentPosition);
		Double newToNeutral = calcDistance(newDirection, neutralDirection);
		Double toRotate = Math.toDegrees(calcRotation(turtleToNew, turtleToNeutral, newToNeutral));
		if (newDirection.getX() < myTurtle.getX()) {
			toRotate += 180;
		}
		Double difference = Math.abs(myTurtle.getRotate() - toRotate);
		myTurtle.setRotate(toRotate);
		return difference;
	}
	
	private Double calcRotation(Double side1, Double side2, Double side3) {
		Double side1Square = side1*side1;
		Double side2Square = side2*side2;
		Double side3Square = side3*side3;
		Double rotationAngle = Math.acos((side1Square + side2Square - side3Square) / (2*side1*side2));
		return rotationAngle;
	}
	
	private Double calcDistance(Coordinate firstCoord, Coordinate secondCoord) {
		Double xDiff = firstCoord.getX() - secondCoord.getX();
		Double yDiff = firstCoord.getY() - secondCoord.getY();
		Double distance = Math.sqrt((xDiff*xDiff) + (yDiff*yDiff));
		return distance;
	}
	
}
