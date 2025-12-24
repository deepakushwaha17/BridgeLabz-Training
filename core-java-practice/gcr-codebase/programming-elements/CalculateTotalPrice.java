//Write a program to input the unit price of an item and the quantity to be bought. Then, calculate the total price.

import java.util.Scanner;

public class CalculateTotalPrice{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		System.out.print("Enter unit price of item : ");
		int unitPrice = input.nextInt();
		System.out.print("Enter quantity bought : ");
		int quantity = input.nextInt();
		int totalPrice = unitPrice * quantity;
		System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
		input.close();
	}
}
