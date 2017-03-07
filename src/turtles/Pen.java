package turtles;

public class Pen {
	boolean penDown;
	double penSize;
	double penColor;
	
	public Pen() {
		penDown = true;
		penSize = 1;
		penColor = 0;
	}
	
	public boolean showPen() {
		return penDown;
	}
	
	public void setPen(boolean b) {
		penDown = b;
	}
	
	public double getSize(){
		return penSize;
	}
	
	public void setSize(double d){
		penSize = d;
	}
	
	public double getColor(){
		return penColor;
	}
	
	public void setColor(double d){
		penColor = d;
	}
	
}
