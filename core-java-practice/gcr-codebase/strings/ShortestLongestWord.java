//Write a program to split the text into words and find the shortest and longest strings in a given text

import java.util.Scanner;

public class ShortestLongestWord  {

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
	
    public static String[] findShortestLongest(String[][] wordLengthArr) {
        String shortest = wordLengthArr[0][0];
        String longest = wordLengthArr[0][0];
        int minLen = Integer.parseInt(wordLengthArr[0][1]);
        int maxLen = Integer.parseInt(wordLengthArr[0][1]);

        for (int i = 1; i < wordLengthArr.length; i++) {
            int len = Integer.parseInt(wordLengthArr[i][1]);
            if (len < minLen) {
                minLen = len;
                shortest = wordLengthArr[i][0];
            }
            if (len > maxLen) {
                maxLen = len;
                longest = wordLengthArr[i][0];
            }
        }

        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();

        String[] words = splitWords(text);
		String[][] wordsLength = wordsWithLength(words);

        System.out.println("\nWord\tLength");
        for (int i = 0; i < wordsLength.length; i++) {
            System.out.println(wordsLength[i][0] + "\t" + Integer.parseInt(wordsLength[i][1]));
        }
		
        String[] result = findShortestLongest(wordsLength);
        System.out.println("Shortest word: " + result[0]);
        System.out.println("Longest word: " + result[1]);
    }
}
