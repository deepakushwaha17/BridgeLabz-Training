//Write a program that takes three integer inputs from the user and finds the maximum of the three numbers.

import java.util.Scanner;

public class MaxOfThree {

    public static int inputNumber(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.nextInt();
    }

    public static int findMax(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = inputNumber(sc, "Enter first number: ");
        int num2 = inputNumber(sc, "Enter second number: ");
        int num3 = inputNumber(sc, "Enter third number: ");

        int max = findMax(num1, num2, num3);
        System.out.println("Maximum number is: " + max);
    }
}
