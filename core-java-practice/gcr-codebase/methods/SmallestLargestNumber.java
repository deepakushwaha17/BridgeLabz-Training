//Write a program to find the smallest and the largest of the 3 numbers.

import java.util.Scanner;

public class SmallestLargestNumber {

    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = number1;
        int largest = number1;

        if (number2 < smallest){
            smallest = number2;
        } else if (number3 < smallest){
            smallest = number3;
        } else if (number2 > largest){
            largest = number2;
        } else if (number3 > largest){
            largest = number3;
        }
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int number1 = input.nextInt();
        System.out.print("Enter second number: ");
        int number2 = input.nextInt();
        System.out.print("Enter third number: ");
        int number3 = input.nextInt();

        int[] result = findSmallestAndLargest(number1, number2, number3);

        System.out.println("Smallest number: " + result[0]);
        System.out.println("Largest number: " + result[1]);
        input.close();
    }
}
