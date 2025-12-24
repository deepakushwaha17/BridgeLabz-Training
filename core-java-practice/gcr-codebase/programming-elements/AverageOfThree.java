//Write a program that takes three numbers as input from the user and prints their average.
import java.util.Scanner;

class AverageOfThree {
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double first = input.nextDouble();
        System.out.print("Enter second number: ");
        double second = input.nextDouble();
        System.out.print("Enter third number: ");
        double third = input.nextDouble();

        double average = (first + second + third) / 3;
        System.out.println("Average is " + average);
		input.close();
    }
}
