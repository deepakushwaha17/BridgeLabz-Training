//Write a program to take 2 numbers and print their quotient and reminder

import java.util.Scanner;

public class QuotientRemainder{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first number : ");
		int firstNumber = input.nextInt();
		System.out.print("Enter second number  : ");
		int secondNumber = input.nextInt();
		int quotient = firstNumber / secondNumber;
		int reminder = firstNumber % secondNumber;
		System.out.println("The Quotient is " + quotient + " and Reminder is " + reminder + " of two number " + firstNumber + " and " + secondNumber);
		input.close();
	}
}
