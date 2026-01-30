package regex;

import java.util.*;
import java.util.regex.*;

public class ValidateUsername {
	
	public static boolean validateUsername(String username) {
		String regex = "^([a-zA-Z])[a-zA-Z0-9_]{5,15}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(username);
		
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the username: ");
		String username = input.nextLine();

		if(validateUsername(username)) {
			System.out.println("Valid");
		}else {
			System.out.println("Invalid");
		}
		input.close();
	}

}
