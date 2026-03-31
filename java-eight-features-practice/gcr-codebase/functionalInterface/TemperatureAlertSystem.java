package functionalInterface;

import java.util.function.Predicate;

import java.util.Scanner;

public class TemperatureAlertSystem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the temperature: ");
		double temperature = input.nextDouble();
		
		double threshold = 40.0;
		Predicate<Double> isThreshold = n -> n > threshold;
		
		if(isThreshold.test(temperature)) {
			System.out.println("Warning: Temperature exceeded threshold!");
		}else {
			System.out.println("Tempertaure is normal.");
		}
		
		input.close();
	}
}