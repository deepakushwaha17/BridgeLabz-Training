//Write a program to demonstrate NumberFormatException

import java.util.Scanner;

public class NumberFormatDemo {

    public static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Number is: " + number);
    }

    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text); 
            System.out.println("Number is: " + number);
        } 
		catch (NumberFormatException e) {
            System.out.println("NumberFormatException occurred! Invalid number format: " + e.getMessage());
        } 
		catch (Exception e) {
            System.out.println("Generic Exception! " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text : ");
        String text = input.nextLine();
        try {
            generateException(text);
        } 
		catch (NumberFormatException e) {
			handleException(text);
        }
    }
}
