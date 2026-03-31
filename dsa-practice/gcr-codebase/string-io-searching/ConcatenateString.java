package dsaProblems;

import java.util.Scanner;

public class ConcatenateString {
	
	public static void concatenateString(String[] string) {
		StringBuffer concatString = new StringBuffer();
		for(int i = 0 ; i < string.length ; i++) {
			concatString.append(string[i]+" ");
		}
		System.out.println("Concatenated String is "+ concatString.toString());
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the length of text : ");
		int len = input.nextInt();
		String text[] = new String[len];
		for(int i = 0 ; i < len ; i++) {
			text[i] = input.next();
		}
		
		concatenateString(text);
		input.close();
	}

}
