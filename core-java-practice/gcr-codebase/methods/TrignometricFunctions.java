//Write a program to calculate various trigonometric functions using Math class given an angle in degrees

import java.util.Scanner;

public class TrignometricFunctions {

    public static double[] calculateTrigonometricFunctions(double angleInDegrees) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        double sine = Math.sin(angleInRadians);
        double cosine = Math.cos(angleInRadians);
        double tangent = Math.tan(angleInRadians);
        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter angle in degrees : ");
        double angle = input.nextDouble();

        double[] results = calculateTrigonometricFunctions(angle);
        System.out.println("Sine(" + angle + "°) = " + results[0]);
        System.out.println("Cosine(" + angle + "°) = " + results[1]);
        System.out.println("Tangent(" + angle + "°) = " + results[2]);
        input.close();
    }
}
