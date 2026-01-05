// Problem no. 387 : Count Occurrence of a Character

import java.util.Scanner;

public class CountCharacter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = input.nextLine();

        System.out.print("Enter character to count: ");
        char ch = input.next().charAt(0);

        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }

        System.out.println("Occurrence = " + count);
    }
}
