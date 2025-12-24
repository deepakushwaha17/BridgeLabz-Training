//Rewrite program 1 to determine Leap Year with single if condition using logical and && and or || operators.

import java.util.Scanner;

public class LeapYearSingleIf{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year after 1582: ");
		int year = input.nextInt();
		
		if((year >= 1582) && ((year % 4 == 0 && year % 100 != 0)|| year % 400 == 0)){
		    System.out.println(year + " is leap year ");
		}
		else{
		    System.out.println(year + " is not a leap year");
		}
		input.close();
	}
}
			    