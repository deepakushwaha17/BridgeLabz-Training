//Write a program to calculate the perimeter of a rectangle. Take the length and width as inputs and use the formula

import java.util.Scanner;

class PerimeterOfRectangle {
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
        System.out.print("Enter length: ");
        double length = input.nextDouble();
        System.out.print("Enter width: ");
        double width = input.nextDouble();
        double perimeter = 2 * (length + width);
        System.out.println("Perimeter of Rectangle is " + perimeter);
		input.close();
    }
}
