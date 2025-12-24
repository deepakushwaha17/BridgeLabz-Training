/*The Coffee Counter Chronicles ☕
Ravi runs a café. Each customer orders different coffee types with quantities. Write a program
that:
● Asks for coffee type (switch)
● Calculates total bill (price * quantity)
● Adds GST using arithmetic operators
Use while to continue for the next customer and break when "exit" is typed.*/

import java.util.Scanner;

public class CoffeeCounterChronicles{
	public static void main(String[] args){
		
		//applying GST 7 %
		final double GST = 0.07;
		while(true){
		
			Scanner input = new Scanner(System.in);
			System.out.print("Enter coffee type (espresso/cappuccino/latte/americano) or exit : ");
			String coffeeType = input.nextLine();
			
			// condition to exit the while loop
			if(coffeeType.equalsIgnoreCase("exit")){
				System.out.print("Cafe is closed ");
				break;
			}
			
			int price = 0;
			
			switch(coffeeType.toLowerCase()){
				case "espresso" :
					price = 150;
					break;
				case "cappuccino" :
					price = 170;
					break;
				case "latte" :
					price = 180;
					break;
				case "americano" :
					price = 160;
					break;
				default:
					System.out.println("Invalid Coffee Type");
					continue;
			}

			System.out.print("Enter the quantity : ");
			int quantity = input.nextInt();
			int totalPrice = quantity * price ;
			double gstAmount = totalPrice * GST;
			double finalBill = totalPrice + gstAmount;
			
			System.out.println("Coffee Type is " + coffeeType + "\nPrice of one coffee is " + price + "\nQuantity is " + quantity +
								"\nTotal Price is " + totalPrice + "\nGST Amount is " + gstAmount + "\nTotal Bill with GST is " + finalBill);
			
		}
	}
}				