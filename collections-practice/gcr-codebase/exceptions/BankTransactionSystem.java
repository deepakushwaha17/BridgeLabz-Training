package exceptions;

import java.util.Scanner;

public class BankTransactionSystem {
	
	static double balance;
	
	public static void withdraw(double amount) throws InsufficientBalanceException{
		if(amount > balance) {
			throw new InsufficientBalanceException("Insufficient balance!");
		}
		if(amount < 0) {
			throw new IllegalArgumentException("Invalid amount!");
		}
		else {
			balance -= amount;
			System.out.println("Withdrawal successful, new balance: "+balance);
		}
	}

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter balance: ");
			balance = input.nextDouble();
			System.out.print("Enter amount to withdraw: ");
			double amount = input.nextDouble();
			withdraw(amount);
		}
		catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}

// Custom exception
class InsufficientBalanceException extends Exception{
	public InsufficientBalanceException(String message) {
		super(message);
	}
}