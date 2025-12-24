//Write a Program to check if the given number is a prime number or not

import java.util.Scanner;

public class PrimeNumber{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int number = input.nextInt();
		boolean isPrime = true;
		
		for(int i=2; i <= number-1; i++){
			if(number % i == 0){
				isPrime = false;
				break;
			}
		}
		
		if(isPrime){
			System.out.println(number + " is Prime Number");
		}
		else{
			System.out.println(number + " is not a Prime Number");
		}
		input.close();
	}
}