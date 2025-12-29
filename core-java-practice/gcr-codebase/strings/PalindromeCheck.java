//Write a program to to check if a text is palindrome and display the result

import java.util.Scanner;

public class PalindromeCheck {

    // Logic 1: Iterative approach
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive approach
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true; //Base case
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false; 
        }
        return isPalindromeRecursive(text, start + 1, end - 1); // Recursive call
    }

    //Logic 3: Using char array and reverse
    public static boolean isPalindromeUsingArray(String text) {
        char[] original = text.toCharArray();
        char[] reverse = new char[original.length];

        // Create reverse array
        for (int i = 0; i < original.length; i++) {
            reverse[i] = text.charAt(text.length() - 1 - i);
        }

        // Compare original and reversed arrays
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = input.nextLine();

        // Logic 1: Iterative check
        boolean result1 = isPalindromeIterative(text);
        System.out.println("\nIs Palindrome check (Iterative): " + result1);

        // Logic 2: Recursive check
        boolean result2 = isPalindromeRecursive(text, 0, text.length() - 1);
        System.out.println("Is Palindrome check (Recursive): " + result2);

        // Logic 3: Using char arrays
        boolean result3 = isPalindromeUsingArray(text);
        System.out.println("Is Palindrome check (Using Char Array): " + result3);
    }
}
