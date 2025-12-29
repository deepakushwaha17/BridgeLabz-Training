//Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods

import java.util.Scanner;

public class NumberChecker4 {

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

    // store digits in array
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

    // reverse digits array
    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        int index = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            reversed[index++] = digits[i];
        }
        return reversed;
    }

    // compare two arrays
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // check palindrome number
    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseDigits(digits);
        return compareArrays(digits, reversed);
    }

    // check Duck Number
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d != 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] digits = storeDigits(number);

        System.out.print("\nDigits: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }

        int[] reversed = reverseDigits(digits);
        System.out.print("\nReversed Digits: ");
        for (int d : reversed) {
            System.out.print(d + " ");
        }

        System.out.println("\nArrays Equal: " + compareArrays(digits, reversed));
        System.out.println("Palindrome Number: " + isPalindrome(digits));
        System.out.println("Duck Number: " + isDuckNumber(digits));

        input.close();
    }
}
