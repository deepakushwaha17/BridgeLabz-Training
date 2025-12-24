//Create a program to check if a number is an Abundant Number.

import java.util.Scanner;

public class AbundantNumber{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int number = input.nextInt();
		
		int sumOfDivisor = 0;
		for(int i=1; i < number ; i++){
			if(number % i == 0){
				sumOfDivisor += i;
			}
		}
		
		if(sumOfDivisor > number){
			System.out.println(number + " is a Abundant Number");
		}
		else{
			System.out.println(number + " is not a Abundant Number");
		}
		input.close();
	}
}