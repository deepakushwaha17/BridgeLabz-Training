//Write a Java program to count the number of vowels and consonants in a given string.

import java.util.Scanner;

public class CountVowelAndConsonants {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String text = input.next().toLowerCase();

        char[] ch = text.toCharArray();
        int countVowel = 0 , countConsonants = 0;
        for(int i = 0 ; i < ch.length ; i++){
            if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u'){
                countVowel++;
            }
            else{
                countConsonants++;
            }
        }

        System.out.println("\nTotal vowel are " + countVowel);
        System.out.println("Total consonants are " + countConsonants);
        input.close();

    }   
}
