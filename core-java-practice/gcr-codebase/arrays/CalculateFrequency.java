/*Create a program to take a number as input find the frequency of each digit in the number 
using an array and display the frequency of each digit */

import java.util.Scanner;

public class CalculateFrequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = input.nextInt();
        int temp = number;
        int count = 0;

        while (temp != 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        temp = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        int[] freq = new int[10];
        for (int i = 0; i < count; i++) {
            freq[digits[i]]++;
        }

        System.out.println("Digit\tFrequency");
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println(i + "\t" + freq[i]);
            }
        }
        input.close();
    }
}
