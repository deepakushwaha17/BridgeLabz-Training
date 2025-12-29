/*Write a program to find the sum of n natural numbers using recursive method and compare the 
result with the formulae n*(n+1)/2 and show the result from both computations is correct.  */

import java.util.Scanner;

public class RecursiveSumOfNumber {

    public static int sumRecursion(int n) {
        if (n == 1) {
            return 1; // Base case
        } 
        return n + sumRecursion(n - 1);
    }

    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = input.nextInt();

        if (n < 1) {
            System.out.println("Invalid input! Please enter a natural number (>=1).");
        } else {
            int sumRec = sumRecursion(n);
            int sumForm = sumFormula(n);

            System.out.println("Sum of first " + n + " natural numbers using recursion: " + sumRec);
            System.out.println("Sum of first " + n + " natural numbers using formula: " + sumForm);

            if (sumRec == sumForm) {
                System.out.println("Both methods give the same result.");
            } else {
                System.out.println("There is a discrepancy between the two methods.");
            }
        }
        input.close();
    }
}
