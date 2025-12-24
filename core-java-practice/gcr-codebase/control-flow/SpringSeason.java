//Write a program SpringSeason that takes two int values month and day from the command line and prints “Its a Spring Season” otherwise prints “Not a Spring Season”. 

import java.util.Scanner;

public class SpringSeason{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		System.out.print("Enter month : ");
		int month = input.nextInt();
		System.out.print("Enter day : ");
		int day = input.nextInt();
		if((month >= 3 && day >=20) && (month <= 6 && day <= 20)){
			System.out.println("Its a Spring Season");
		}else{
			System.out.println("Not a Spring Season");
		}
		input.close();
	}
}	