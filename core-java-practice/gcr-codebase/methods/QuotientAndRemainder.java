//Write a program to take 2 numbers and print their quotient and reminder

import java.util.Scanner;

public class QuotientAndRemainder {

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int number = input.nextInt();
        System.out.print("Enter the divisor: ");
        int divisor = input.nextInt();

        int[] result = findRemainderAndQuotient(number, divisor);
        System.out.println("Quotient: " + result[0]);
        System.out.println("Remainder: " + result[1]);
        input.close();
    }
}
