// Problem no. 1768 : Merge Two Strings Alternately

import java.util.Scanner;

public class MergeStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = input.nextLine();

        System.out.print("Enter second string: ");
        String s2 = input.nextLine();

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < s1.length() || i < s2.length()) {
            if (i < s1.length()) result.append(s1.charAt(i));
            if (i < s2.length()) result.append(s2.charAt(i));
            i++;
        }

        System.out.println("Merged String: " + result.toString());
    }
}
