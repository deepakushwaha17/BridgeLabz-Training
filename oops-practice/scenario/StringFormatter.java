/*Scenario: A text editing tool receives poorly formatted input from users. Your task is to auto-correct formatting by fixing spacing and capitalizing the first letter of each sentence.
Problem:
Write a method that takes a paragraph as input and returns a corrected version with:
● One space after punctuation,
● Capital letter after period/question/exclamation marks,
● Trimmed extra spaces.*/

package classandobject;

import java.util.Scanner;

public class StringFormatter {

	public static String formatParagraph(String paragraph) {

        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "";
        }

        paragraph = paragraph.trim();
        paragraph = paragraph.replaceAll("\\s*([.!?])\\s*", "$1 ");

        String[] sentences = paragraph.split("(?<=[.!?]) ");

        StringBuilder formattedText = new StringBuilder();

        for (String sentence : sentences) {
            sentence = sentence.trim();
            if (!sentence.isEmpty()) {
                // Capitalize first letter
                formattedText.append(
                        sentence.substring(0, 1).toUpperCase()
                        + sentence.substring(1).toLowerCase()
                ).append(" ");
            }
        }

        return formattedText.toString().trim();
    }

    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
    	System.out.println("Enter the senetence : ");
    	
        String sentence = input.nextLine() ;
        
        System.out.println(formatParagraph(sentence));
        input.close();
    }

}
