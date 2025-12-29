/*Festival Lucky Draw 🎉
At Diwali mela, each visitor draws a number.
● If the number is divisible by 3 and 5, they win a gift.
● Use if, modulus, and loop for multiple visitors.
● continue if input is invalid.*/

import java.util.Scanner;

public class FestivalLuckyDraw {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean moreVisitors = true;

        while (moreVisitors) {
            System.out.print("Enter your lucky number: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                input.next(); // Skip invalid input
                continue;
            }

            int number = input.nextInt();

            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("Congratulations! You won a gift.");
            } else {
                System.out.println("Sorry! Better luck next time.");
            }

            System.out.print("Is there another visitor? (yes/no): ");
            String another = input.next().toLowerCase();
            if (another.equals("no")) {
                moreVisitors = false;
            }
        }

        System.out.println("Festival draw ended. Happy Diwali!");
        input.close();
    }
}
