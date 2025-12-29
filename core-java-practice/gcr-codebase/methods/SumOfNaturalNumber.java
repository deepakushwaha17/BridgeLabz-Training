//Write a program to find the sum of n natural numbers using loop

import java.util.Scanner;

public class SumOfNaturalNumber {

    public static int findSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = input.nextInt();

        int result = findSum(n);
        System.out.println("Sum of first " + n + " natural numbers is: " + result);
        input.close();
    }
}
