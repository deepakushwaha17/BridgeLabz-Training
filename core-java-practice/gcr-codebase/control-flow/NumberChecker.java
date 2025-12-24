//Write a program to check whether a number is positive, negative, or zero.

import java.util.Scanner;

public class NumberChecker{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int number = input.nextInt();
		if(number > 0){
			System.out.println("The number " + number + " is positive number");
		}else if (number < 0){
			System.out.println("The number " + number + " is negative number");
		}else{
			System.out.println("The number " + number + " is zero");
		}
		input.close();
	}
}	