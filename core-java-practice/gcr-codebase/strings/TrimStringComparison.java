//Write a program to trim the leading and trailing spaces from a string using the charAt() method 

import java.util.Scanner;

public class TrimStringComparison {

    public static int[] findTrimIndexes(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    public static String createSubstring(String text, int start, int end) {

        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string with spaces: ");
        String text = input.nextLine();

        int[] indexes = findTrimIndexes(text);

        String trimmedByCharAt = createSubstring(text, indexes[0], indexes[1]);

        String trimmedByBuiltIn = text.trim();

        boolean isSame = compareStrings(trimmedByCharAt, trimmedByBuiltIn);

        System.out.println("\nTrimmed String (charAt): '" + trimmedByCharAt + "'");
        System.out.println("Trimmed String (built-in): '" + trimmedByBuiltIn + "'");
        System.out.println("Are both strings equal? " + isSame);
    }
}
