//Create a program to print a multiplication table of a number.

import java.util.Scanner;

public class MultiplicationTable{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = input.nextInt();

        int[] table = new int[10];

        for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;
        }

        for (int index = 1; index <= 10; index++) {
            System.out.println(number + " * " + index + " = " + table[index - 1]);
        }
		input.close();
    }
}
