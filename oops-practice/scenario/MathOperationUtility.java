/*Scenario: You are tasked with creating a utility class for mathematical operations.
Implement the following functionalities using separate methods:
● A method to calculate the factorial of a number.
● A method to check if a number is prime.
● A method to find the greatest common divisor (GCD) of two numbers.
● A method to find the nth Fibonacci number.
● Test your methods with various inputs, including edge cases like zero, one, and
negative numbers.*/

package classandobject;

import java.util.Scanner;

public class MathOperationUtility {

	// Factorial method
    public static long factorial(int n) {
        if (n < 0) {
            return -1; // invalid input
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Prime check method
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // GCD method
    public static int gcd(int firstNumber, int secondNumber) {
        firstNumber = Math.abs(firstNumber);
        secondNumber = Math.abs(secondNumber);

        while (secondNumber != 0) {
            int temp = secondNumber;
            secondNumber = firstNumber % secondNumber;
            firstNumber = temp;
        }
        return firstNumber;
    }

    // Fibonacci method
    public static int fibonacci(int n) {
        if (n < 0) {
            return -1; // invalid input
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        int firstNumber = 0, secondNumber = 1;
        for (int i = 2; i <= n; i++) {
            int nextNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = nextNumber;
        }
        return secondNumber;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Factorial input
        System.out.print("Enter a number for factorial: ");
        int factNum = input.nextInt();
        long factResult = factorial(factNum);
        if (factResult == -1)
            System.out.println("Factorial not defined for negative numbers.");
        else
            System.out.println("Factorial = " + factResult);

        // Prime input
        System.out.print("\nEnter a number to check prime: ");
        int primeNum = input.nextInt();
        System.out.println(primeNum + " is prime? " + isPrime(primeNum));

        // GCD input
        System.out.print("\nEnter first number for GCD: ");
        int firstNumber = input.nextInt();
        System.out.print("Enter second number for GCD: ");
        int secondNumber = input.nextInt();
        System.out.println("GCD = " + gcd(firstNumber, secondNumber));

        // Fibonacci input
        System.out.print("\nEnter n for Fibonacci: ");
        int fibNum = input.nextInt();
        int fibResult = fibonacci(fibNum);
        if (fibResult == -1)
            System.out.println("Fibonacci not defined for negative numbers.");
        else
            System.out.println("Fibonacci number = " + fibResult);

        input.close();
    }

}
