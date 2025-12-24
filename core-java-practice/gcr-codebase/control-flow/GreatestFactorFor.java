//Create a program to print the greatest factor of a number beside itself using a loop.

import java.util.Scanner;

public class GreatestFactorFor {
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = input.nextInt();

        int greatestFactor = 1;
        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break;
            }
        }
        System.out.println("Greatest Factor of "+ number + " is " + greatestFactor);
        input.close();
    }
}
