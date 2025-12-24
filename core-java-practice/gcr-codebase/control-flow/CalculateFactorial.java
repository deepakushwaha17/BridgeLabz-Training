//Rewrite program 14(FactorialCalculation) using for loop

import java.util.Scanner;

public class CalculateFactorial {
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
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
		System.out.println("Factorial of " + number + " is " + factorial);
		input.close();
    }
}