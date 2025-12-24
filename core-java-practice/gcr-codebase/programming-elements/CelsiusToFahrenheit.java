//Write a program that takes the temperature in Celsius as input and converts it to Fahrenheit using the formula

import java.util.Scanner;

class CelsiusToFahrenheit {
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = input.nextDouble();

        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Temperature in Fahrenheit is " + fahrenheit);
		input.close();
    }
}
