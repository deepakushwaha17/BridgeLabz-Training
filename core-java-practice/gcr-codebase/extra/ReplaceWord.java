//Write a replace method in Java that replaces a given word with another word in a sentence

import java.util.Scanner;

public class ReplaceWord {
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();
        System.out.print("Enter the word to replace: ");
        String oldWord = input.nextLine();
        System.out.print("Enter the new word: ");
        String newWord = input.nextLine();
		
		String newSentence = sentence.replaceAll(oldWord, newWord);

        System.out.println("Modified Sentence: " + newSentence);
    }
}
