//Write a program to calculate the area of a circle. Take the radius as input and use the formula

import java.util.Scanner;

class AreaOfCircle {
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
        System.out.print("Enter radius of circle: ");
        double radius = input.nextDouble();

        double area = 3.14 * radius * radius;
        System.out.println("Area of Circle is " + area);
		input.close();
    }
}
