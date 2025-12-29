/*Write a program to return all the characters in a string using the user-defined method,  compare the result with the String built-in 
toCharArray() method, and display the result */

import java.util.Scanner;
public class CompareStringCharArray {
    public static char[] getStringChar(String text , int length){
		
		char[] textArray = new char[length];
		for(int i = 0 ; i < length ; i++){
			textArray[i] = text.charAt(i);
		}
		return textArray;

    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the text : ");
        String text = input.next();
		int textLength = text.length();
			
        char[] resultOfCharAt = getStringChar(text, textLength);
        char[] resultOfCharArray = text.toCharArray();
		
		System.out.println("Result using charAt() method: " + String.valueOf(resultOfCharAt));
        System.out.println("Result using toCharArray() method: " + String.valueOf(resultOfCharArray));
		
		boolean result = true;
		for(int i = 0 ; i < textLength ; i++){
			if(resultOfCharAt[i] != resultOfCharArray[i]){
				result = false;
			}
		}

        if(result){
            System.out.println("Both methods gives same result.");
        }else{
            System.out.println("Both methods gives different result.");
        }
    }   
}

