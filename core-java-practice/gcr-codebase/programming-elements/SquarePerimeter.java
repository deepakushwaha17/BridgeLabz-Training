//Write a program to find the side of the square whose parameter you read from the user 

import java.util.Scanner;

public class SquarePerimeter{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		System.out.print("Enter square side length : ");
		double squareSide = input.nextDouble();
		double perimeter = squareSide * squareSide * squareSide * squareSide;
		System.out.println("The length of the side is " + squareSide + " whose perimeter is " + perimeter);
	}
}