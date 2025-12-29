//Write a program to convert the complete text to uppercase and compare the results

import java.util.Scanner;

public class UppercaseConversion {

    public static String toUpperCaseConversion(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }
            result += ch;
        }
        return result;
    }

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) 
		{
			return false;
		}
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) 
			{
				return false;
			}
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();

        String customUpper = toUpperCaseConversion(text);
        String builtInUpper = text.toUpperCase();

        System.out.println("Custom Uppercase: " + customUpper);
        System.out.println("Built-in Uppercase: " + builtInUpper);
        System.out.println("Are both results equal? " + compareStrings(customUpper, builtInUpper));
    }
}
