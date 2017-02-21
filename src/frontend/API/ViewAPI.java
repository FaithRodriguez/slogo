package frontend.API;

import javafx.scene.image.Image;
/**
 * API for View class
 * Serves as communicator between frontend and backend
 * Serves as central hub for front end
 * @author Gordon
 *
 */
public interface ViewAPI {
	// External API
	/**
	 * Returns a Coordinate of the bottom-right most corner of the turtle's area
	 * @return
	 */
	public Coordinate getBounds();
	
	/**
	 * Update the frontend display of variables generated in the environment
	 * @param a
	 * The name of the variable
	 * @param b
	 * The value of the variable
	 */
	public void updateVar(String a, String b);
	
	/**
	 * Display an error with a specific reason
	 * @param a
	 * The specific error
	 */
	public void showError(String a);
	
	/**
	 * Update the frontend display of user defined methods
	 * @param a
	 * The method selected
	 * @param b
	 * The code associated with the method
	 */
	public void updateUMethod(String a, String b);
	
	// Internal API
	/**
	 * Have the backend update a variable changed in the UI
	 * @param a
	 * The name of the variable
	 * @param b
	 * The value of the variable
	 */
	public void changeVariable(String a, String b);
	
	/**
	 * Have the backend run a user method selected in the UI
	 * @param a
	 * The name of the method
	 * @param b
	 * The associated code with the method
	 */
	public void useUMethod(String a, String b);
	
	/**
	 * Change the background color of the turtle's area
	 * @param a
	 * 6 hexadecimal values specifying a color i.e. "FFFFFF"
	 */
	public void changeBackground(String a);
	
	/**
	 * Change the image of the turtle with a specified image
	 * @param a
	 * Image to use
	 */
	public void changeImage(Image a);
	
	/**
	 * Change the color of the pen
	 * @param a
	 * 6 hexadecimal values specifying a color i.e. "FFFFFF"
	 */
	public void changePenColor(String a);
	
	/**
	 * Change the language of the input commands
	 * @param a
	 * Language to be used such as "English"
	 */
	public void changeLanguage(String a);
	
	/**
	 * Have Model run the given string as code
	 * @param a
	 * Text input from user
	 */
	public void runCommand(String a);
	
}