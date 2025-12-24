//Write a program to find the distance in yards and miles for the distance provided by the user in feet

import java.util.Scanner;

public class FeetToYardMiles{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		System.out.print("Enter distance in feet :");
		double distanceInFeet = input.nextDouble();
		
		// Conversion from feet to yard, 1 yard = 3 feet
		final double FEET_TO_YARD = 1/3.0;
		
		// Conversion from yard to miles, 1 mile = 1760 yards
		final double YARD_TO_MILE = 1/1760.0;
		double distanceInYard = distanceInFeet * FEET_TO_YARD;
		double distanceInMie = distanceInYard * YARD_TO_MILE;
   		System.out.println("The distance in yards is " + distanceInYard + " while the distance in miles is " + distanceInMie);
	}
}