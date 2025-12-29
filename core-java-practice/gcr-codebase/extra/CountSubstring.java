//Write a Java program to count how many times a given substring occurs in a string.

import java.util.Scanner;

public class CountSubstring {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String text = input.nextLine();
		System.out.print("Enter substring to find: ");
        String subtext = input.nextLine();

		int count = 0;
        for (int i = 0; i <= text.length() - subtext.length(); i++) {
            if (text.substring(i, i + subtext.length()).equals(subtext)) {
                count++;
            }
        }
        System.out.println("Substring occurs " + count + " times.");
        input.close();

    }   
}
