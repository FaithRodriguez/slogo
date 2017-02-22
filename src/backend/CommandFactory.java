package backend;

import commands.Command;

public class CommandFactory {
	
	private static final String COMMAND_PACKAGE = "commands.";
	private PatternParse myPatterns;
	
	public CommandFactory(String syntax) {
		myPatterns = new PatternParse();
		myPatterns.addPattern(syntax);
	}
	
	public Command reflectCommand(String s) {
		String className = myPatterns.getSymbol(s);
		try {
			Class<?> clazz = Class.forName( COMMAND_PACKAGE + className + "Command" );
			return (Command) clazz.getDeclaredConstructor(java.lang.String.class).newInstance(s);
		} catch (Exception e) {
			return null;
		}
	}
	
	

}
