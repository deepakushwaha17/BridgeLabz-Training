//Create a program to check if a number is armstrong or not.

import java.util.Scanner;

public class ArmstrongNumber{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a 3-digit number : ");
		int number = input.nextInt();
		if(number < 100 && number > 999){
			System.out.print("Invalid input");
			return;
		}
		
		
		int sumOfDigitCube = 0;
		int originalNumber = number;
		while(originalNumber != 0){
			int remainder = originalNumber % 10;
			sumOfDigitCube += remainder * remainder * remainder;
			originalNumber /= 10;
		}
		
		if(sumOfDigitCube == number){
			System.out.println(number + " is Armstrong Number");
		}
		else{
			System.out.println(number + " is not a Armstrong Number");
		}
		input.close();
	}
}