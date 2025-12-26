/*Write a program to store multiple values in an array up to a maximum of 10 or until the user enters a 0 or a negative number. 
Show all the numbers as well as the sum of all numbers */

import java.util.Scanner;

public class StoreAndSumOfNumbers {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double[] values = new double[10];
        double total = 0.0;
        int index = 0;

        while (true) {
            System.out.print("Enter a number : ");
            double number = input.nextDouble();

            if (number <= 0 || index == 10){
                break;
			}
            values[index] = number;
            index++;
        }

		//accessing the values of the array and adding the numbers
        for (int i = 0; i < index; i++) {
            System.out.println("Value : " + values[i] );
            total += values[i];
        }

        System.out.println("Total Sum is " + total);
    }
}
