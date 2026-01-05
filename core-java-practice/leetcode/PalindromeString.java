// Problem no. 125 : Check if String is Palindrome

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = input.nextLine().toLowerCase();

        int i = 0, j = s.length() - 1;
        boolean isPalindrome = true;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        System.out.println(isPalindrome ? "Palindrome" : "Not Palindrome");
    }
}
