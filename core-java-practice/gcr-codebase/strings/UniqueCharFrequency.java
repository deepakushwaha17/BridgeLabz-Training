//Write a program to find the frequency of characters in a string using unique characters and display the result

import java.util.Scanner;

public class UniqueCharFrequency {

    public static char[] uniqueCharacters(String text) {
        String unique = "";
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean alreadyExists = false;

            for (int j = 0; j < unique.length(); j++) {
                if (unique.charAt(j) == ch) {
                    alreadyExists = true;
                    break;
                }
            }
            if (!alreadyExists) {
                unique += ch;
            }
        }
        return unique.toCharArray();
    }

    public static String[][] charFrequency(String text) {
        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        char[] uniqueChars = uniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            result[i][0] = Character.toString(ch);
            result[i][1] = Integer.toString(freq[ch]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        String[][] frequencies = charFrequency(str);

        System.out.println("Character\tFrequency");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println(frequencies[i][0] + "\t\t" + frequencies[i][1]);
        }
    }
}
