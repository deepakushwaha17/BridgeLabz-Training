package dsaProblems;

import java.util.Scanner;

public class ReverseString {
	
	public static void reverseString(String text) {
		StringBuilder string = new StringBuilder();
		string.append(text);
		string.reverse();
		System.out.println("Reverse of " + text + " is " +string.toString());
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the text : ");
		String text = input.next();
		
		reverseString(text);
		input.close();

	}
}