//Write a Java program to remove all duplicate characters from a given string and return the modified string.

import java.util.Scanner;

public class RemoveDuplicateCharacters {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String text = input.next();

		String newString = "";
        for(int i = 0 ; i < text.length() ; i++){
			char ch = text.charAt(i);
			if(newString.indexOf(ch) == -1){
				newString += ch;
			}
		}
        System.out.println("\nString without duplicate characters is " + newString);
        input.close();

    }   
}