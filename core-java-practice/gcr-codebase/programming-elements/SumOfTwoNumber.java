//Write a program that takes two numbers as input from the user and prints their sum.

import java.util.Scanner;
public class SumOfTwoNumber{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first number : ");
		int firstNumber = input.nextInt();
		System.out.print("Enter second number : ");
		int secondNumber = input.nextInt();
		int sum = firstNumber + secondNumber;
		System.out.print("Sum of two number is  " + sum);
		input.close();
	}
}