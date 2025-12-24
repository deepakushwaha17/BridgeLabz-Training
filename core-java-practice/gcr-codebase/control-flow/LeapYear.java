//Write a LeapYear program that takes a year as input and outputs the Year is a Leap Year or not a Leap Year. 

import java.util.Scanner;

public class LeapYear{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year after 1582: ");
		int year = input.nextInt();
		
		if(year >= 1582){
		    if((year % 4 == 0 && year % 100 != 0)|| year % 400 == 0){
				System.out.println(year + " is leap year ");
			}
			else{
			    System.out.println(year + " is not a leap year");
			}
		}
		else{
		    System.out.println("Invalid year");
		}
		input.close();
	}	
}
			    