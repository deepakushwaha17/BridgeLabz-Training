/*Write a program for Euclidean distance between two points as well as the equation of the line 
using those two points. Use Math functions Math.pow() and Math.sqrt() */

import java.util.Scanner;

public class EuclideanDistance {
  
    //find Euclidean distance
    public static double findDistance(
            double x1, double y1, double x2, double y2) {

        return Math.sqrt(
                Math.pow(x2 - x1, 2) +
                Math.pow(y2 - y1, 2)
        );
    }

    // Method to find slope and y-intercept
    public static double[] findLineEquation(
        double x1, double y1, double x2, double y2) {

        double[] result = new double[2];

        if (x2 == x1) {
            result[0] = Double.NaN; // slope undefined
            result[1] = Double.NaN;
            return result;
        }

        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - (m * x1);

        result[0] = m; // slope
        result[1] = b; // y-intercept

        return result;
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter x1 y1: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();

        System.out.print("Enter x2 y2: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        double distance = findDistance(x1, y1, x2, y2);
        double[] line = findLineEquation(x1, y1, x2, y2);

        System.out.printf("\nEuclidean Distance = %.2f\n", distance);

        if (Double.isNaN(line[0])) {
            System.out.println("Equation of Line: x = " + x1 + " (Vertical Line)");
        } else {
            System.out.printf("Equation of Line: y = %.2fx + %.2f\n",
                    line[0], line[1]);
        }
    }

}