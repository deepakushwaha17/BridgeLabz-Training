//Problem no. 557 :Reverse Words in a String III
package leetcode;

import java.util.Scanner;

public class ReverseEachWords {

    // Method to reverse words
    public static String reverseWords(String s) {
        String[] words = s.split(" "); // split by space
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reversedWord = new StringBuilder(word).reverse().toString();
            result.append(reversedWord);

            if (i != words.length - 1) {
                result.append(" "); // add space between words
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String output = reverseWords(input);
        System.out.println("Reversed words string: " + output);
    }
}

