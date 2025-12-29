//Write a Java program to compare two strings lexicographically (dictionary order) without using built-in compare methods.

import java.util.Scanner;

public class CompareStrings {
    public static void compareStrings(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (str1.charAt(i) < str2.charAt(i)) {
                    System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\"");
                } else {
                    System.out.println("\"" + str1 + "\" comes after \"" + str2 + "\"");
                }
                return;
            }
        }
        if (str1.length() == str2.length()) {
            System.out.println("Both strings are equal.");
        } else if (str1.length() < str2.length()) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\"");
        } else {
            System.out.println("\"" + str1 + "\" comes after \"" + str2 + "\"");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter String 1: ");
        String str1 = input.nextLine();
        System.out.print("Enter String 2: ");
        String str2 = input.nextLine();

        compareStrings(str1, str2);
    }
}
