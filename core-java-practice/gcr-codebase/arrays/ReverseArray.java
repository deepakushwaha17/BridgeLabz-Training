/*Create a program to take a number as input and reverse the number. To do this, store the digits 
of the number in an array and display the array in reverse order */

import java.util.Scanner;

public class ReverseArray {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number : ");
        int number = input.nextInt();
        int temp = number, count = 0;

        while (temp != 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        int[] reverse = new int[count];

       for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        System.out.println("Reversed number is ");
        for (int i = 0; i < count; i++) {
            reverse[i] = digits[count-1-i];
            System.out.print(reverse[i]);
        }
        input.close();
    }
    
}
