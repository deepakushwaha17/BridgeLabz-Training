//Write a Java program to find the most frequent character in a string.

import java.util.Scanner;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        
        int[] freq = new int[256]; // ASCII characters
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        int max = 0;
        char mostFrequent = ' ';
        for (int i = 0; i < 256; i++) {
            if (freq[i] > max) {
                max = freq[i];
                mostFrequent = (char)i;
            }
        }
        System.out.println("Most Frequent Character: '" + mostFrequent + "'");
    }
}
