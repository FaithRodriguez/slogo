package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

import commands.Command;

public class UserMethodManager extends Observable {

	private HashMap<String, UserMethod> myMethodMap;

	public UserMethodManager() {
		myMethodMap = new HashMap<String, UserMethod>();
	}

	public void add(String key, UserMethod method) {
		myMethodMap.put(key, method);
		setChanged();
		String commands = String.join(",", method.getListOfCommands().toString());
		notifyObservers(new ArrayList<String> (Arrays.asList(key, commands)));
	}

	public UserMethod get(String key) {
		UserMethod method = myMethodMap.get(key);
		return method;
	}
}
