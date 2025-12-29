//Write a program to find the first non-repeating character in a string and show the result

import java.util.Scanner;

public class FirstNonRepeatingChar {

    public static char firstNonRepeating(String text) {
		// Array to store frequency of all ASCII characters
        int[] freq = new int[256]; 

        // Loop to count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Loop to find first non-repeating character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return '\0'; // Return null character if no non-repeating character is found
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.next();

        char result = firstNonRepeating(str);
        if (result != '\0') {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found in the string.");
        }
    }
}
