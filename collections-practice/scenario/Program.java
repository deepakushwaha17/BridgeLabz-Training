package scenario;

import java.util.regex.*;
import java.util.*;

public class Program {
	
	// Method to validate the input
	public String validateInput(String input) {
		//Regex to validate the input
		String regex = "[a-zA-z]{6,}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		
		if(matcher.matches()) {
			return input;
		}
		return "";
		
	}
	
	// Method to remove even ASCII value and reverse remaining word
	public String cleanseAndInvert(String input) {
		Program p = new Program();
		input = p.validateInput(input);
		if(input.isEmpty()) {
			return "";
		}
		
		// Converting the input to lowercase and reversing it 
		StringBuilder sb = new StringBuilder(input.toLowerCase()).reverse();
		String generatedKey = "";
		int index = 0;
		for(int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) % 2 != 0) {
				if(index % 2 == 0) {
					generatedKey += Character.toUpperCase(sb.charAt(i));
				}else {
					generatedKey += sb.charAt(i);
				}
				index++;
			}
		}
		return generatedKey;		
	}

	public static void main(String[] args) {
		Program p = new Program();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the word: ");
		String input = sc.nextLine();
		
		input = p.cleanseAndInvert(input);
		if(input.isEmpty()) {
			System.out.println("Invalid Input !");
		}else {
			System.out.println("The generated key is - " + input);
		}
		
		sc.close();
	}
}