/*Metro Smart Card Fare Deduction 🚇
In Delhi Metro, fare varies by distance.
● Ask the user for distance.
● Calculate fare using ternary operator.
● Deduct from smart card balance.
Loop until balance is exhausted or the user quits.*/

import java.util.Scanner;

public class MetroSmartCard {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		System.out.print("Enter Current Balance :");
        double balance = input.nextDouble() ;

        while (balance > 0) {
            System.out.println("\nCurrent Balance :" + balance);
            System.out.print("Enter distance (0 to quit): ");
            int distance = input.nextInt();

            if (distance == 0) {
				System.out.println("Journey Cancelled by User !");
                break;
            }

            int fare = (distance <= 10) ? 40 : 60;

            if (balance >= fare) {
                balance -= fare;
                System.out.println("Fare deducted: ₹" + fare);
            } else {
                System.out.println("Insufficient balance!");
                break;
            }
        }

        System.out.println("\nThank you for using Delhi Metro");
        input.close();
    }
}
