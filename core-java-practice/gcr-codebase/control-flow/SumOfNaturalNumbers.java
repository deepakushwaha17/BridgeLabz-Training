//Write a program to check for the natural number and write the sum of n natural numbers 

import java.util.Scanner;

public class SumOfNaturalNumbers{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int number = input.nextInt();
		if(number > 0){
			int sumOfNumbers = number * (number + 1)/2;
			System.out.println("The sum of " + number + " natural numbers is " + sumOfNumbers);
		}else{
			System.out.println("The number " + number + " is not a natural number");
		}
		input.close();
	}
}	