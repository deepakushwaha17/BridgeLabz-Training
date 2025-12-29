//Write a program to find vowels and consonants in a string and display the count of  Vowels and Consonants in the string

import java.util.Scanner;

public class CountVowelsConsonants{
	public static String checkCharacter(char ch){
		if (ch >= 'A' && ch <= 'Z') {
           ch = (char) (ch + 32);
		}
		if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
	}
	
	public static int[] countVowelsConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            String result = checkCharacter(ch);
            if (result.equals("Vowel")) {
                vowels++;
            } else if (result.equals("Consonant")) {
                consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }
	
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.next();

        int[] result = countVowelsConsonants(text);
        System.out.println("\nVowel Count: " + result[0]);
        System.out.println("Consonant Count: " + result[1]);
    }
}