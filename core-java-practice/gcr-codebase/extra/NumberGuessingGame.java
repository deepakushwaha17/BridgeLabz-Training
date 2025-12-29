//Write a Java program where the user thinks of a number between 1 and 100, and the computer tries to guess the number by generating random guesses.

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static int generateGuess(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    public static String getFeedback(int guess, Scanner sc) {
        System.out.println("Is your number " + guess + "? (high/low/correct): ");
        return sc.nextLine().toLowerCase();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = 1, max = 100;
        System.out.println("Think of a number between 1 and 100.");

        while (true) {
            int guess = generateGuess(min, max);
            String feedback = getFeedback(guess, sc);

            if (feedback.equals("correct")) {
                System.out.println("Yay! I guessed your number: " + guess);
                break;
            } else if (feedback.equals("high")) {
                max = guess - 1;
            } else if (feedback.equals("low")) {
                min = guess + 1;
            } else {
                System.out.println("Invalid input! Please type high, low, or correct.");
            }
        }
    }
}
