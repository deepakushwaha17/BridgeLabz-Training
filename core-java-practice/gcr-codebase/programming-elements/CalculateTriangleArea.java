//Write a program that takes the base and height in cm to find the area of a triangle in square inches and square centimeters

import java.util.Scanner;

public class CalculateTriangleArea{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		System.out.print("Enter traingle base in cm: ");
		double base = input.nextDouble();
		System.out.print("Enter traingle height in cm : ");
		double height = input.nextDouble();
		
		// 1 inches = 2.54 cm
		final double CM_TO_INCHE = 1/2.54;
		double areaInCm = 0.5 * base * height;
		double areaInInches = areaInCm * CM_TO_INCHE * CM_TO_INCHE;
		System.out.println("The Area of the triangle in sq in is " + areaInInches + " and sq cm is " + areaInCm);
		
	}
}		