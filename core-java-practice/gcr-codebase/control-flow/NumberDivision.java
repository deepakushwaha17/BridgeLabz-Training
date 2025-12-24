//Write a program to check if a number is divisible by 5

import java.util.Scanner;

public class NumberDivision{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int number = input.nextInt();
		boolean isDivisible = (number % 5) == 0;
		System.out.println("Is the number " + number + " divisible by 5? " + isDivisible);
		input.close();
	}
}	
