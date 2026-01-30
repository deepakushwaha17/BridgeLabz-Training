package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHexColorCode {
	public static boolean validateColorCode(String hexColor) {
		String regex = "^([#])[0-9A-Fa-f]{6}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(hexColor);
		
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the hex color code: ");
		String hexColor = input.nextLine();

		if(validateColorCode(hexColor)) {
			System.out.println("Valid");
		}else {
			System.out.println("Invalid");
		}
		input.close();
	}
}
