//Problem no. 151 : Reverse Words in a String
package leetcode;

import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        // Remove leading/trailing spaces and split by one space
        String[] words = text.trim().split("\\s+");

        // Reverse the words
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }

        System.out.println("Reversed Words: " + reversed.toString());
        input.close();
    }
}
