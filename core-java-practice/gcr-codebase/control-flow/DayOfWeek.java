/*Write a program DayOfWeek that takes a date as input and prints the day of the week that the date falls on. Your program should take 
three command-line arguments: m (month), d (day), and y (year). For m use 1 for January, 2 for February, and so forth. 
For output print 0 for Sunday, 1 for Monday, 2 for Tuesday, and so forth.*/

import java.util.Scanner;

public class DayOfWeek{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the month in number(1-12) : ");
		int month = input.nextInt();
		System.out.print("Enter the date : ");
		int date = input.nextInt();
		System.out.print("Enter the year : ");
		int year = input.nextInt();
		
		int y0 = year - (14 - month) / 12;
		int x = y0 + y0/4 - y0/100 + y0/400;
		int m0 = month + 12 * ((14 - month) / 12) - 2;
		int d0 = (date + x + (31*m0) / 12) % 7;
		
		switch(d0){
			case 0 :
				System.out.println("Day is Sunday");
				break;
			case 1 :
				System.out.println("Day is Monday");
				break;
			case 2 :
				System.out.println("Day is Tuesday");
				break;
			case 3 :
				System.out.println("Day is Wednesday");
				break;
			case 4 :
				System.out.println("Day is Thursday");
				break;
			case 5 :
				System.out.println("Day is Friday");
				break;
			case 6 :
				System.out.println("Day is Saturday");
				break;
			default : 
				System.out.println("Invalid Date");
		}
		input.close();
	}
}