/*Write a program to find the 3 points that are collinear using the slope formulae and area of triangle
 formulae. check  A (2, 4), B (4, 6) and C (6, 8) are Collinear for sampling.  */

 import java.util.Scanner;

public class Collinear {

    // Method using slope formula
    public static boolean isCollinearUsingSlope(
            int x1, int y1, int x2, int y2, int x3, int y3) {

        return (y2 - y1) * (x3 - x2) ==
               (y3 - y2) * (x2 - x1);
    }

    // Method using area of triangle formula
    public static boolean isCollinearUsingArea(
            int x1, int y1, int x2, int y2, int x3, int y3) {

        int area = x1 * (y2 - y3)
                 + x2 * (y3 - y1)
                 + x3 * (y1 - y2);

        return area == 0;
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter x1 y1: ");
        int x1 = input.nextInt();
        int y1 = input.nextInt();

        System.out.print("Enter x2 y2: ");
        int x2 = input.nextInt();
        int y2 = input.nextInt();

        System.out.print("Enter x3 y3: ");
        int x3 = input.nextInt();
        int y3 = input.nextInt();

        boolean slopeResult = isCollinearUsingSlope(x1, y1, x2, y2, x3, y3);
        boolean areaResult  = isCollinearUsingArea(x1, y1, x2, y2, x3, y3);

        System.out.println("\nUsing Slope Formula: " +
                (slopeResult ? "Collinear" : "Not Collinear"));

        System.out.println("Using Area Formula: " +
                (areaResult ? "Collinear" : "Not Collinear"));
    }

}
