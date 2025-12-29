//Write a Java program to check if a given string is a palindrome (a string that reads the same forward and backward).

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args){
	
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String text = input.next();

        String reverseString = "";
		for(int i = text.length()-1; i >= 0; i--){
			reverseString += text.charAt(i);
		}
		
		if(text.equals(reverseString)){
			System.out.println(text + " is a palindrome string");
		} else{
			System.out.println(text + " is not a palindrome string");
		}

        input.close();

    }   
}