//Create a program to count the number of digits in an integer.

import java.util.Scanner;

public class CountNumberOfDigits{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a 3-digit number : ");
		int number = input.nextInt();
		
		int count = 0;
		while(number != 0){
			count++ ;
			number /= 10;
		}
		System.out.println("Number of digits is " + count);
		input.close();
	}
}