//Rewrite the above program 7 to find the factors of a number using the while loop

import java.util.Scanner;

public class FactorsWhileLoop {
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer : ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Invalid input");
            return;
        }

		System.out.println("Factors of " + number + " are : ");
        int counter = 1;
        while (counter < number) {
            if (number % counter == 0){
                System.out.println(counter);
			}
            counter++;
        }
        input.close();
    }
}
