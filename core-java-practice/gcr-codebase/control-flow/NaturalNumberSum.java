//Write a program to find the sum of n natural numbers using while loop compare the result with the formulae n*(n+1)/2 and show the result from both computations was correct. 

import java.util.Scanner;

public class NaturalNumberSum {
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
		System.out.print("Enter a number : ");
        int naturalNumber = input.nextInt();

		//checking entered number is natural number or not
        if (naturalNumber <= 0) {
            System.out.println("Not a natural number");
            return;
        }

        int sumUsingWhileLoop = 0;
        int currentNumber = 1;
        while (currentNumber <= naturalNumber) {
            sumUsingWhileLoop += currentNumber;
            currentNumber++;
        }

        int sumUsingFormula = naturalNumber * (naturalNumber + 1) / 2;

		// comparing result obtained formula and while loop
        if (sumUsingWhileLoop == sumUsingFormula) {
            System.out.println("Both computations are correct and sum of numbers is " + sumUsingFormula);
        } else {
            System.out.println("Computation results do not match");
        }
		input.close();
    }
}
