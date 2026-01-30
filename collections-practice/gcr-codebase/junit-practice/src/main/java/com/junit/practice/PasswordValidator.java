package com.junit.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

	public boolean isValid(String password) {
		String regex = "[a-zA-Z0-9]{8,}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}
}
