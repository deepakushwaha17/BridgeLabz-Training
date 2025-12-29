//Write a Java program to remove all occurrences of a specific character from a string.

import java.util.Scanner;

public class RemoveCharacter {
    public static String removeChar(String str, char ch) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        System.out.print("Enter character to remove: ");
        char ch = input.next().charAt(0);

        System.out.println("Modified String: " + removeChar(str, ch));
    }
}
