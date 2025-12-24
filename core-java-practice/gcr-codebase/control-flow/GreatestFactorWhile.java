//Rewrite the above program to print the greatest factor of a number beside itself using a while loop.

import java.util.Scanner;

public class GreatestFactorWhile {
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = input.nextInt();

        int greatestFactor = 1;
        int counter = number - 1;

        while (counter >= 1) {
            if (number % counter == 0) {
                greatestFactor = counter;
                break;
            }
            counter--;
        }

        System.out.println("Greatest Factor of "+ number + " is " + greatestFactor);
        input.close();
    }
}
