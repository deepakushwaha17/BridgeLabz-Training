package functionalInterface;

import java.util.Scanner;

interface ConversionUtils{
	static double convertKmToMiles(double km) {
		return km * 0.621371;
	}
	static double convertKgToLbs(double kg) {
		return kg * 2.20462;
	}
}

public class UnitConversionTool {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("----Unit Conversion Tool----");
		System.out.println("1. Kg to Miles");
		System.out.println("2. Km to Lbs");
		System.out.print("Enter the choice: ");
		int choice = input.nextInt();
		
		if(choice == 1) {
			System.out.print("Enter value in km: ");
			double km = input.nextDouble();
			System.out.println("Value in miles: " + ConversionUtils.convertKmToMiles(km));
		}else if ( choice == 2) {
			System.out.print("Enter value in kg: ");
			double kg = input.nextDouble();
			System.out.println("Value in lbs: " + ConversionUtils.convertKgToLbs(kg));
		}else {
			System.out.println("Invalid choice.");
		}
		input.close();
	}

}
