//Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods

import java.util.Scanner;

public class NumberChecker3 {

    // count digits
    public static int countDigits(int number) {
        int count = 0;
        int temp = number;

        while (temp != 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    // store digits in an array
    public static int[] storeDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];

        int temp = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    // find sum of digits
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    // find sum of squares of digits
    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    // check Harshad number
    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    // find frequency of each digit
    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];

        for (int i = 0; i < 10; i++) {
            freq[i][0] = i; // digit
            freq[i][1] = 0; // frequency
        }

        for (int d : digits) {
            freq[d][1]++;
        }
        return freq;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int count = countDigits(number);
        int[] digits = storeDigits(number);

        System.out.println("\nNumber of digits: " + count);

        System.out.print("Digits: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }

        System.out.println("\nSum of digits: " + sumOfDigits(digits));
        System.out.println("Sum of squares of digits: " + sumOfSquaresOfDigits(digits));
        System.out.println("Harshad Number: " + isHarshadNumber(number, digits));

        int[][] frequency = digitFrequency(digits);
        System.out.println("\nDigit Frequency:");
        System.out.println("Digit\tFrequency");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i][1] > 0) {
                System.out.println(frequency[i][0] + "\t" + frequency[i][1]);
            }
        }

        input.close();
    }
}
