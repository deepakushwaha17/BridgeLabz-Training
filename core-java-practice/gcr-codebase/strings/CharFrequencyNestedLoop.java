//Write a program to find the frequency of characters in a string using nested loops and display the result

import java.util.Scanner;

public class CharFrequencyNestedLoop {

    public static String[] charFrequency(String text) {
		// Convert string to char array
        char[] chars = text.toCharArray(); 
        int[] freq = new int[chars.length];

        // Nested loops to find frequency
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                continue;
            }

            freq[i] = 1; 
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // Mark duplicate as counted
                }
            }
        }

        // Creating 1D String array to store characters and their frequencies
        String[] result = new String[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[i] = chars[i] + "\t\t " + freq[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
		
        String[] frequencies = charFrequency(str);

        System.out.println("Character\tFrequency");
        for (String s : frequencies) {
            if (s != null) {
                System.out.println("    " + s);
            }
        }
    }
}
