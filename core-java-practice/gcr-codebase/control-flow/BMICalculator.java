//Create a program to find the BMI of a person

import java.util.Scanner;
public class BMICalculator{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter person weight in km : ");
		double weight = input.nextDouble();
		System.out.print("Enter person height in cm : ");
		double height = input.nextDouble();
		
		final double CM_TO_METER = 0.01; // 1m = 100cm
		double bmiValue = weight/(height * height * CM_TO_METER * CM_TO_METER);
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