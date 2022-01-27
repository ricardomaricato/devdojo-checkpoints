package checkpoint.second.validation;

import checkpoint.second.model.Automaker;

public class AutomakerValidation {

	public static boolean isValid(Automaker[] automakers, String name) {
		for (Automaker automaker : automakers) {
			if (!automaker.getName().equalsIgnoreCase(name)) return false;
		}
		return true;
	}
}
