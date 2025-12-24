/*. Maya’s BMI Fitness Tracker 🏃‍♀️
Maya, a fitness coach, wants to record the BMI of her clients.
● Ask for height and weight.
● Use formula BMI = weight / (height * height)
● Print category using if-else: Underweight, Normal, Overweight.
Use clear variable names and comments to maintain code hygiene.*/

import java.util.Scanner;
public class BMIFitnessTracker{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter person weight in km : ");
		double weight = input.nextDouble();
		System.out.print("Enter person height in cm : ");
		double height = input.nextDouble();
		
		// 1m = 100cm
		final double CM_TO_METER = 0.01; 
		double bmiValue = weight/(height * height * CM_TO_METER * CM_TO_METER);
		
		//displaying category based on BMI value 
		if(bmiValue >= 40.0){
			System.out.println("BMI Value is " + bmiValue + "\nStatus is Obese");
		}
		else if(bmiValue >= 25.0){
			System.out.println("BMI Value is " + bmiValue + "\nStatus is Overweight");
		}
		else if(bmiValue >= 18.5){
			System.out.println("BMI Value is " + bmiValue + "\nStatus is Normal");
		}
		else{
			System.out.println("BMI Value is " + bmiValue + "\nStatus is Underweight");
		}
		input.close();
	}
}