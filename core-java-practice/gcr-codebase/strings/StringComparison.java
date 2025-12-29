/*Write a program to compare two strings using the charAt() method and check the result 
with the built-in String equals() method */

import java.util.Scanner;
public class StringComparison {
    public static boolean compareStrings(String text1 , String text2){

        if(text1.length() != text2.length()){
            return false;
        }
        for(int i = 0; i < text1.length(); i++){
            if(text1.charAt(i) != text2.charAt(i)){
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first text : ");
        String firstText = input.next();
        System.out.print("Enter the second text : ");
        String secondText = input.next();

        boolean resultOfCharAt = compareStrings(firstText, secondText);
        boolean resultOfEquals = firstText.equals(secondText);
        if(resultOfCharAt == resultOfEquals){
            System.out.println("Both methods gives same result ");
        }else{
            System.out.println("Both methods gives different result ");
        }
    }   
}
