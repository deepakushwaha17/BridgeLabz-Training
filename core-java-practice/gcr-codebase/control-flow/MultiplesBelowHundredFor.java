//Create a program to find all the multiples of a number taken as user input below 100.

import java.util.Scanner;

public class MultiplesBelowHundredFor {
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number less than 100 : ");
        int number = input.nextInt();

        if (number <= 0 || number >= 100) {
            System.out.println("Invalid number");
            return;
        }

        for (int i = 100; i >= 1; i--){
            if (number % i == 0){
                System.out.println(i);
			}
		}
        input.close();
    }
}
