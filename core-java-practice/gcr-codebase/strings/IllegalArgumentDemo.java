//Write a program to demonstrate IllegalArgumentException

import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void generateException(String text) {
        System.out.println("Substring: " + text.substring(5, 2));
    }

    public static void handleException(String text) {
        try {
            System.out.println("Substring: " + text.substring(5, 2));
        } 
		catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException occurred : " + e.getMessage());
        } 
		catch (Exception e) {
            System.out.println("Generic Exception occurred : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text : ");
        String text = input.nextLine();
        try {
            generateException(text);
        } 
		catch (IllegalArgumentException e) {
			handleException(text);
        }
		
    }
}
