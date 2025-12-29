/*Create a program to find the factors of a number taken as user input, store the factors in an array, and display the factors. 
Also find the sum, sum of square of factors and product of the factors and display the results */

import java.util.Scanner;

public class CalculateFactor {

    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int val : factors) {
            sum += val;
        }
        return sum;
    }

    public static int productOfFactors(int[] factors) {
        int product = 1;
        for (int val : factors) {
            product *= val;
        }
        return product;
    }

    public static int sumOfSquares(int[] factors) {
        int sum = 0;
        for (int val : factors) {
            sum += Math.pow(val, 2);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] factors = findFactors(number);

        System.out.print("Factors: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }
        System.out.println();

        System.out.println("Sum of factors: " + sumOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
        System.out.println("Sum of squares of factors: " + sumOfSquares(factors));
        input.close();
    }
}
