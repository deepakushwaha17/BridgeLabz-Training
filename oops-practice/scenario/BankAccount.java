/*Scenario: A banking app needs to perform operations like deposit, withdraw, and check balance for a user.
● Problem: Design a BankAccount class with:
● Fields/Properties: AccountNumber, Balance.
● Methods: Deposit(double), Withdraw(double), CheckBalance().
● Include logic to prevent overdraft.*/

package classandobject;

import java.util.Scanner;

public class BankAccount {
	
	static String accountNumber;
	double balance;
	
	public void deposit(double depositAmount) {
		if(depositAmount > 0) {
			balance += depositAmount;
			System.out.println("Amount Deposited Rs." +depositAmount);
		}
		else {
			System.out.println("Deposit Amount must be positive.");
		}
	}
	
	public void withdraw(double withdrawAmount) {
		if(withdrawAmount > 0) {
			if(withdrawAmount > balance) {
				System.out.println("Insufficient balance!");
			}
			else {
				balance -= withdrawAmount;
				System.out.println("Amount Withdrawn Rs." +withdrawAmount);
			}
		}
		else {
			System.out.println("Withdraw Amount must be positive.");
		}
	}
	
	public void checkBalance() {
		System.out.println("Current Balance : Rs." +balance);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount bank = new BankAccount();
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the account number : ");
		accountNumber = input.next();
		System.out.print("Enter the balance : ");
		bank.balance = input.nextDouble();
		
		System.out.print("Enter the deposit amount : ");
		double depositAmount = input.nextDouble();
		bank.deposit(depositAmount);
		
		System.out.print("Enter the withdraw amount : ");
		double withdrawAmount = input.nextDouble();
		bank.withdraw(withdrawAmount);
		
		bank.checkBalance();
		
		input.close();
	}

}
