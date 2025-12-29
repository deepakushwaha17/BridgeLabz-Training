/*Election Booth Manager ️
Design a polling booth system.
● Take age input.
● Use if to check if eligible (>=18).
● Record vote (1, 2, or 3 for candidates).
● Loop for multiple voters, exit on special code.*/

import java.util.Scanner;

public class ElectionBoothManager {
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
        int vote1 = 0, vote2 = 0, vote3 = 0;

        while (true) {
            System.out.print("\nEnter age (0 to exit): ");
            int age = input.nextInt();

            if (age == 0) {
				System.out.println("Election Booth is Closed !");
                break;
            }

            if (age >= 18) {
                System.out.println("You are eligible to vote.");
                System.out.print("Vote for candidate (1 / 2 / 3) : ");
                int vote = input.nextInt();

                if (vote == 1) {
                    vote1++;
                } else if (vote == 2) {
                    vote2++;
                } else if (vote == 3) {
                    vote3++;
                } else {
                    System.out.println("Invalid vote!");
                }
            } else {
                System.out.println("You are NOT eligible to vote.");
            }
        }

        System.out.println("\n--- Voting Result ---");
        System.out.println("Candidate 1 Votes : " + vote1);
        System.out.println("Candidate 2 Votes : " + vote2);
        System.out.println("Candidate 3 Votes : " + vote3);
		System.out.println("\nThank you for your Vote !");
        input.close();
    }
}
