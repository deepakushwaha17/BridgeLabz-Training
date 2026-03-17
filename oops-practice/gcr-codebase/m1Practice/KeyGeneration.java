package m1Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KeyGeneration {

	public static String generateKey(String input) {
		input = input.toLowerCase();
		
		StringBuilder sb = new StringBuilder();
		for(char c : input.toCharArray()) {
			if(c % 2 != 0) {
				sb.append(c);
			}
		}
		sb.reverse();
		
		StringBuilder result = new StringBuilder();
		for(int i = 0 ; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			if(i % 2 == 0) {
				result.append(Character.toUpperCase(ch));
			}
			else {
				result.append(ch);
			}
		}
		
		return result.toString();
	}
	
	public static void validateInput(String input) {
		if(input.length() < 6) {
			System.out.println("Invalid Input(length < 6)");
			return;
		}
		
		if(input.contains(" ")) {
			System.out.println("Invalid Input(contains space)");
			return;
		}
		
		if(input.matches(".*\\d.*")) {
			System.out.println("Invalid Input(contains digits)");
			return;
		}
		
		if(!input.matches("[a-zA-Z]+")) {
			System.out.println("Invalid Input(contains special character)");
			return;
		}
		
		if(input.length() == 0) {
			System.out.println("Invalid Input(empty string)");
			return;
		}
		
		String key = generateKey(input);
		if(key.length() == 0) {
			System.out.println("Invalid Input(empty string)");
		}else {
			System.out.println("The generated key is - " + key);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n : ");
		int n = sc.nextInt();
		sc.nextLine();
		List<String> inputs = new ArrayList<>();
		
		for(int i = 0 ; i < n; i++) {
			String input = sc.nextLine();
			inputs.add(input);
		}
		for(String s : inputs) {
			validateInput(s);
		}
		sc.close();
	}
}
