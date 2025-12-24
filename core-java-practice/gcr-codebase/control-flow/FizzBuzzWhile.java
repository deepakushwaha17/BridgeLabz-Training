//Rewrite the program 4 FizzBuzz using the while loop 

import java.util.Scanner;

public class FizzBuzzWhile {
    public static void main(String[] args) {
		
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer : ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Not a positive integer");
            return;
        }

        int counter = 1;
        while (counter <= number) {
            if (counter % 3 == 0 && counter % 5 == 0)
                System.out.println("FizzBuzz");
            else if (counter % 3 == 0)
                System.out.println("Fizz");
            else if (counter % 5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(counter);
            counter++;
        }
        input.close();
    }
}
