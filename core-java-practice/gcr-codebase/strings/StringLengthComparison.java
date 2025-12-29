//Write a program to find and return the length of a string without using the length() method 

import java.util.Scanner;

public class StringLengthComparison {

    public static int getLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count); 
                count++;
            } catch (Exception e) {
                break; 
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String text = input.next();

        int customLength = getLength(text);
        int builtInLength = text.length();

        System.out.println("Length without length(): " + customLength);
        System.out.println("Length using length(): " + builtInLength);
        input.close();
    }
}
