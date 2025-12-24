//Create a program to check if a number taken from the user is a Harshad Number.

import java.util.Scanner;

public class HarshadNumber{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int number = input.nextInt();
		
		int sumOfDigit = 0;
		int originalNumber = number;
		while(originalNumber != 0){
			int remainder = originalNumber % 10;
			sumOfDigit += remainder;
			originalNumber /= 10;
		}
		if(number % sumOfDigit == 0){
			System.out.println(number + " is a Harshad Number");
		}
		else{
			System.out.println(number + " is not a Harshad Number");
		}
		input.close();
	}
}