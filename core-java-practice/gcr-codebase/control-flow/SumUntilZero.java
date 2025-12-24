//Write a program to find the sum of numbers until the user enters 0

import java.util.Scanner;

public class SumUntilZero{
    public static void main(String[] args){
	    
		double totalOfNumber = 0.0;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number : ");
		double enteredValue = input.nextDouble();
		while(enteredValue != 0){
			totalOfNumber += enteredValue;
			System.out.print("Enter a number : ");
			enteredValue = input.nextDouble();
		}
		System.out.println("Sum of numbers is " + totalOfNumber);
		input.close();
	}
}	
