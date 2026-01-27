package exceptions;

import java.util.Scanner;

public class ThrowVsThrows {

	public static void calculateInterest(double amount, double rate, int years) throws IllegalArgumentException{
		if(amount < 0 || rate < 0) {
			throw new IllegalArgumentException ("Invalid input: Amount and rate must be positive");
		}else {
			double interest = (amount * rate * years) / 100;
			System.out.println("Interest: $" + interest);
		}
	}
	
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter amount: ");
			double amount = input.nextDouble();
			System.out.print("Enter rate: ");
			double rate = input.nextDouble();
			System.out.print("Enter years: ");
			int years = input.nextInt();
			
			calculateInterest(amount, rate, years);
			input.close();
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}