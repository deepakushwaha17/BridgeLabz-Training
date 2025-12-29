//Write a program to demonstrate StringIndexOutOfBoundsException

import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
	public static void generateException(String text){
		int textLength = text.length();
		System.out.println("Character at index " + textLength + " is " + text.charAt(textLength));
	}
	public static void handleException(String text){
		try{
			int textLength = text.length();
			System.out.println("Character at index " + textLength + " is " + text.charAt(textLength));
		}
		catch(StringIndexOutOfBoundsException e){
			System.out.println("StringIndexOutOfBoundsException occurred : " +e.getMessage());
		}
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the text : ");
		String text = input.next();
		try{
			generateException(text);
		}
		catch(StringIndexOutOfBoundsException e){
			handleException(text);
		}
	}
}