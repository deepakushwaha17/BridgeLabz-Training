package functionalInterface;

import java.util.Scanner;
import java.util.function.Function;

public class StringLengthChecker {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the message: ");
		String message = input.nextLine();
		
		int charLimit = 10;
		Function<String,Integer> checkLimit = s -> s.length();
		
		if(checkLimit.apply(message) > charLimit) {
			System.out.println("Warning: message exceeds character limit!");
		}else {
			System.out.println("Valid message character limit.");
		}
		
		input.close();
	}

}