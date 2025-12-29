//Write a program to split the text into words and return the words along with their lengths in a 2D array

import java.util.Scanner;

public class SplitWordsWithLength {

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

    public static String[][] wordsWithLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text : ");
        String text = input.nextLine();

        String[] words = splitWords(text);
        String[][] wordsLength = wordsWithLength(words);

        System.out.println("\nWord\tLength");
        for (int i = 0; i < wordsLength.length; i++) {
            System.out.println(wordsLength[i][0] + "\t" + Integer.parseInt(wordsLength[i][1]));
        }
    }
}
