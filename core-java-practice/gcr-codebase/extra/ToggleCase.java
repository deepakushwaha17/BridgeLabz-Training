//Write a Java program to toggle the case of each character in a given string. Convert uppercase letters to lowercase and vice versa.//

import java.util.Scanner;

public class ToggleCase {
    public static String toggleCase(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
		
        System.out.println("Toggled case: " + toggleCase(str));
    }
}
