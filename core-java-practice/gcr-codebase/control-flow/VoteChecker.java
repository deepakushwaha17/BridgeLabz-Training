//Write a program to check whether a person can vote, depending on whether his/her age is greater than or equal to 18.

import java.util.Scanner;

public class VoteChecker{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		System.out.print("Enter person age : ");
		int age = input.nextInt();
		if(age >= 18){
			System.out.println("The person's age is " + age + " and can vote");
		}else{
			System.out.println("The person's age is " + age + " and cannot vote");
		}
		input.close();
	}
}	