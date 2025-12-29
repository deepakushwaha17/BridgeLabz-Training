/*An athlete runs in a triangular park with sides provided as input by the user in meters. 
If the athlete wants to complete a 5 km run, then how many rounds must the athlete complete */

import java.util.Scanner;

public class TriangularParkRun {

    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;   // in meters
        double totalDistance = 5000;                 // 5 km = 5000 meters
        return totalDistance / perimeter;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side 1(in meters): ");
        double side1 = input.nextDouble();
        System.out.print("Enter side 2(in meters): ");
        double side2 = input.nextDouble();
        System.out.print("Enter side 3(in meters): ");
        double side3 = input.nextDouble();

        double rounds = calculateRounds(side1, side2, side3);
        System.out.println("The athlete must complete " + rounds + " rounds to run 5 km.");
        input.close();
    }
}
