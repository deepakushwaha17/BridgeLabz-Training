/*Scenario: Create a program that analyzes a given paragraph of text. Implement the following
functionalities:
● Count the number of words in the paragraph.
● Find and display the longest word.
● Replace all occurrences of a specific word with another word (case-insensitive).
● Handle edge cases like empty strings or paragraphs with only spaces.*/

package classandobject;

import java.util.Scanner;

public class ParagraphAnalyzer {

	// Count words
    public static int countWords(String paragraph) {
        if (paragraph == null || paragraph.trim().isEmpty()) {
            return 0;
        }
        return paragraph.trim().split("\\s+").length;
    }

    // Find longest word
    public static String findLongestWord(String paragraph) {
        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "";
        }

        String[] words = paragraph.replaceAll("[^a-zA-Z ]", "").split("\\s+");
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    // Replace word (case-insensitive)
    public static String replaceWord(String paragraph, String oldWord, String newWord) {
        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "";
        }
        return paragraph.replaceAll("(?i)\\b" + oldWord + "\\b", newWord);
    }

    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
    	System.out.println("Enter the paragraph : ");

        String paragraph = input.nextLine();

        System.out.println("Word Count: " + countWords(paragraph));
        System.out.println("Longest Word: " + findLongestWord(paragraph));
        
        System.out.print("Enter the old word to replace :");
        String oldWord = input.nextLine();
        System.out.print("Enter the new word to replace :");
        String newWord = input.nextLine();

        String updatedParagraph = replaceWord(paragraph, oldWord , newWord);
        System.out.println("Updated Paragraph:");
        System.out.println(updatedParagraph);
        
        input.close();
    }

}
