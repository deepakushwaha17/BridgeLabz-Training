/*Write a program to take user input for the age of all 10 students in a class and check whether the student can vote 
depending on his/her age is greater or equal to 18.*/

import java.util.Scanner;

public class CheckVoteEligibility{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the age of 10 students : ");
		int[] age = new int[10];
		
		// for loop to take 10 students age in array from user
		for(int i = 0; i < age.length; i++){
			age[i] = input.nextInt();
		}
		
		for(int index = 0; index < age.length ; index++){
			if(age[index] < 0){
				System.err.println("Invalid age");
			}
			else if(age[index] >= 18){
				System.out.println("The student with the age " + age[index] + " can vote");
			}
			else{
				System.out.println("The student with the age " + age[index] + " cannot vote");
			}
		}
		input.close();
	}
}