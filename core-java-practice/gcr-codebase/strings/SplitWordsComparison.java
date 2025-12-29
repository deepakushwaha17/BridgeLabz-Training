//Write a program to split the text into words, compare the result with the split() method and display the result 

import java.util.Scanner;

public class SplitWordsComparison {

	 public static int getLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count); 
                count++;
            } catch (Exception e) {
                break; 
            }
        }
        return count;
    }
	
	public static String[] splitWords(String text){
		int wordCount = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' '){
				wordCount++;
			}
        }

        String[] wordArray = new String[wordCount];
        int start = 0, index = 0;

        for (int i = 0; i <= text.length(); i++) {
            if (i == text.length() || text.charAt(i) == ' ') {
                String word = "";
                for (int j = start; j < i; j++) {
                    word += text.charAt(j);
                }
                wordArray[index++] = word;
                start = i + 1;
            }
        }
        return wordArray;
    }
	
	public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
			return false;
		}
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])){
				return false;
			}
        }
        return true;
    }
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
        System.out.print("Enter a sentence : ");
        String text = input.nextLine();

        String[] customWords = splitWords(text);
        String[] builtInWords = text.split(" ");

        System.out.print("Custom split : ");
        for (String w : customWords) {
			System.out.print(w + " ");
		}

        System.out.print("\nBuilt-in split : ");
        for (String w : builtInWords){
			System.out.print(w + " ");
		}
        System.out.println("\nAre both splits equal? " + compareArrays(customWords, builtInWords));
	}
}
