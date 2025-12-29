/*Write a Java program that accepts two strings from the user and checks if the two
strings are anagrams of each other (i.e., whether they contain the same characters in any order). */

import java.util.Arrays;
import java.util.Scanner;

public class AnagramCheck {
    public static boolean areAnagrams(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if (str1.length() != str2.length()){
			return false;
		}

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter String 1: ");
        String str1 = input.nextLine();
        System.out.print("Enter String 2: ");
        String str2 = input.nextLine();

        if (areAnagrams(str1, str2)) {
            System.out.println("Strings are anagrams.");
        } else {
            System.out.println("Strings are not anagrams.");
        }
    }
}
