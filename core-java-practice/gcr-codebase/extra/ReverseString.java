//Write a Java program to reverse a given string without using any built-in reverse functions.

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String text = input.next();

        String reverseString = "";
		for(int i = text.length()-1; i >= 0; i--){
			reverseString += text.charAt(i);
		}
		
        System.out.println("\nReversed String is " + reverseString);
        input.close();

    }   
}
