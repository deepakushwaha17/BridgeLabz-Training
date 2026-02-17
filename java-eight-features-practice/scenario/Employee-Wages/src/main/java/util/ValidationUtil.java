package util;

import java.util.regex.Pattern;

public class ValidationUtil {
	
	private static final String COMPANY_NAME_PATTERN = "^[A-Z][a-zA-Z0-9]{2,}";
	
	public static boolean isValidCompany(String name) {
		return Pattern.matches(COMPANY_NAME_PATTERN, name) && (name != null);
		
	}

}
