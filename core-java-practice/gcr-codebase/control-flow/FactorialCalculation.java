//Write a Program to find the factorial of an integer entered by the user.

import java.util.Scanner;

public class FactorialCalculation {
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
		System.out.print("Enter a number : ");
        int number = input.nextInt();
		
		//checking entered number is natural number or not
        if (number <= 0) {
            System.out.println("Not a natural number");
            return;
        }

        int factorial = 1;
        int count = 1;
        while (count <= number) {
            factorial *= count;
            count++;
        }
        System.out.println("Factorial of " + number + " is " + factorial);
		input.close();
    }
}
