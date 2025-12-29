//Write a program to check if two texts are anagrams and display the result

import java.util.Scanner;

public class AnagramCheck {

    public static boolean Anagrams(String text1, String text2) {
        text1 = text1.toLowerCase();
        text2 = text2.toLowerCase();

        if (text1.length() != text2.length()) {
            return false;
        }

		// Frequency array for 'a' to 'z'
        int[] freq1 = new int[26]; 
        int[] freq2 = new int[26];

        for (int i = 0; i < text1.length(); i++) {
            freq1[text1.charAt(i) - 'a']++;
        }
		
        for (int i = 0; i < text2.length(); i++) {
            freq2[text2.charAt(i) - 'a']++;
        }

        // Compare frequency arrays
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false; 
            }
        }
        return true; 
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first text: ");
        String text1 = input.nextLine();
        System.out.print("Enter second text: ");
        String text2 = input.nextLine();

        if (areAnagrams(text1, text2)) {
            System.out.println("The texts are anagrams.");
        } else {
            System.out.println("The texts are not anagrams.");
        }
    }
}
