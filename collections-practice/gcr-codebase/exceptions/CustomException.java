package exceptions;

import java.util.Scanner;

public class CustomException {

	// Method to validate age
	public static void validateAge(int age) throws InvalidAgeException {
		if(age < 18) {
			throw new InvalidAgeException("Age must be 18 or above");
		}
		else {
			System.out.println("Access granted!");
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the age: ");
		int age = input.nextInt();
		input.close();
		try {
			validateAge(age);
		}catch(InvalidAgeException e) {
			System.out.println("InvalidAgeException occurred: "+e.getMessage());
		}
		
	}
}

class InvalidAgeException extends Exception{
	public InvalidAgeException(String message) {
		super(message);
	}
}