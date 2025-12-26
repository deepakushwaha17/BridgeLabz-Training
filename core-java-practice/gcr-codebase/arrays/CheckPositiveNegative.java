/*Write a program to take user input for 5 numbers and check whether a number is positive,  negative, or zero. Further for positive 
numbers check if the number is even or odd. Finally compare the first and last elements of the array and display if they equal, greater or less*/

import java.util.Scanner;

public class CheckPositiveNegative{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 5 numbers : ");
		int[] numbers = new int[5];
		
		// for loop to take 5 numbers in array from user
		for(int i = 0; i < numbers.length; i++){
			numbers[i] = input.nextInt();
		}
		
		for(int index = 0; index < numbers.length ; index++){
			if(numbers[index] < 0){
				System.err.println(numbers[index] + " is negative");
			}
			else if(numbers[index] == 0){
				System.out.println(numbers[index] + " is zero");
			}else{
				if(numbers[index] % 2 == 0){
					System.out.println(numbers[index] + " is even");
				}else{
					System.out.println(numbers[index] + " is odd");
				}
			}
		}
		
		//comparing the first and last element of the array
		if(numbers[0] == numbers[4]){
			System.out.println("First and last elements are equal");
		}else if(numbers[0] > numbers[4]){
			System.out.println("First element is greater than last element");
		}else{
			System.out.println("First element is lesser than last element");
		}
			
		input.close();
	}
}
