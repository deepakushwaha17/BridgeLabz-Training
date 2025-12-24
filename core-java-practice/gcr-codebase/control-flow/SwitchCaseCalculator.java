//Write a program to create a calculator using switch...case.

import java.util.Scanner;

public class SwitchCaseCalculator{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first number : ");
		int first = input.nextInt();
		System.out.print("Enter second number : ");
		int second = input.nextInt();
		System.out.print("Enter operation symbol(+ - * /) : ");
		String op = input.next();
		
		switch(op){
			case "+" :
				System.out.println("Addition of " + first + " and " + second + " is " + (first + second));
				break;
			case "-" :
				System.out.println("Subtraction of " + first + " and " + second + " is " + (first - second));
				break;
			case "*" :
				System.out.println("Multiplication of " + first + " and " + second + " is " + (first * second));
				break;
			case "/" :
				System.out.println("Division of " + first + " and " + second + " is " + (first / second));
				break;
			default : 
				System.out.println("Invalid Input");
		}
		input.close();
	}
}