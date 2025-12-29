/*Bus Route Distance Tracker 🚌
Each stop adds distance.
● Ask if the passenger wants to get off at a stop.
● Use a while-loop with a total distance tracker.
● Exit on user confirmation.*/

import java.util.Scanner;

public class BusRouteDistanceTracker {
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
        double totalDistance = 0.0;
        boolean continueJourney = true;

        while (continueJourney) {
            System.out.print("Enter distance to next stop (km): ");
            double distance = input.nextDouble();
            totalDistance += distance;

            System.out.println("Total distance traveled: " + totalDistance + " km");

            System.out.print("Do you want to get off at this stop? (yes/no): ");
            String choice = input.next().toLowerCase();

            if (choice.equals("yes")) {
                System.out.println("Passenger gets off. Journey ends.");
                continueJourney = false;
            }
        }

        System.out.println("Final distance traveled: " + totalDistance + " km");
        input.close();
    }
}
