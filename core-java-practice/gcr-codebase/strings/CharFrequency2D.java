//Write a program to find the frequency of characters in a string using the charAt() method and display the result

import java.util.Scanner;

public class CharFrequency2D {

    public static String[][] charFrequency(String text) {
        int[] freq = new int[256]; 
		
        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Creating 2D array to store characters and their frequencies
        String[][] result = new String[text.length()][2];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] != 0) { 
                result[index][0] = Character.toString(ch);
                result[index][1] = Integer.toString(freq[ch]);
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = input.nextLine();

        String[][] frequencies = charFrequency(str);

        System.out.println("\nCharacter\tFrequency");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println(frequencies[i][0] + "\t\t" + frequencies[i][1]);
        }
    }
}
