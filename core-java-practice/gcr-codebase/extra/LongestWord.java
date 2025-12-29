//Write a Java program that takes a sentence as input and returns the longest word in the sentence.

import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the sentence : ");
        String text = input.nextLine();

		String[] splitWord = text.split(" ");
		String longestWord = "";
		for(String word : splitWord){
			if(longestWord.length() < word.length()){
				longestWord = word ;
			}
		}			
        System.out.println("\nLongest word in the sentence is " + longestWord);
        input.close();

    }   
}