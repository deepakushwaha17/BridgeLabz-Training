package functionalInterface;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface SecurityUtils{
	static boolean isValidPassword(String password) {
		String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$]).{8,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}
}
public class PasswordStrengthValidator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the password: ");
		String password = input.nextLine();
		
		if(SecurityUtils.isValidPassword(password)) {
			System.out.println(password + " is valid password.");
		}
		else {
			System.out.println(password + " is not valid password.");
		}
		input.close();
	}
}