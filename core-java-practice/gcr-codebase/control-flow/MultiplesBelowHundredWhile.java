//Rewrite the program to find all the multiples of a number below 100 using while loop.

import java.util.Scanner;

public class MultiplesBelowHundredWhile {
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number less than 100 : ");
        int number = input.nextInt();

        if (number <= 0 || number >= 100) {
            System.out.println("Invalid number");
            return;
        }

        int counter = 100;
        while (counter >= 1) {
            if (number % counter == 0){
                System.out.println(counter);
			}
            counter--;
        }
        input.close();
    }
}
