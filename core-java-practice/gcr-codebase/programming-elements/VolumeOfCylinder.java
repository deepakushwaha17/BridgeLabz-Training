//Write a program to calculate the volume of a cylinder. Take the radius and height as inputs and use the formula

import java.util.Scanner;

class VolumeOfCylinder {
    public static void main(String[] args) {
	
        Scanner input = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double radius = input.nextDouble();
        System.out.print("Enter height: ");
        double height = input.nextDouble();
        double volume = 3.14 * radius * radius * height;
        System.out.println("Volume of Cylinder is " + volume);
		input.close();
    }
}
