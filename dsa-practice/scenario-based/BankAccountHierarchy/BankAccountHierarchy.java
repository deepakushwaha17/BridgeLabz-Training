package BankAccountHierarchy;
import java.util.Scanner;

public class BankAccountHierarchy {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the account number : ");
		String accountNumber = input.next();
		System.out.print("Enter the balance : ");
		double balance = input.nextDouble();
		System.out.print("Enter 1.Savings / 2.Checking Balance : ");
		int type = input.nextInt();
		
		if(type == 1) {
			BankAccount savings = new SavingsAccount(accountNumber,balance); 
			System.out.println("\n-----Account Details-----");
			System.out.println("BankAccount : " +savings.getAccountNumber());
			System.out.println("Balance : " + savings.getBalance());
			System.out.printf("Savings Transaction Fees : %.2f%n" , savings.calculateFee());
		}
		else if(type == 2) {
			BankAccount checking = new CheckingAccount(accountNumber,balance); 
			System.out.println("\n-----Account Details-----");
			System.out.println("BankAccount : " +checking.getAccountNumber());
			System.out.println("Balance : " + checking.getBalance());
			System.out.printf("Checking Balance Transaction Fees : %.2f%n" , checking.calculateFee());
		}
		else {
			System.out.println("Invalid Type!");

		}
		input.close();
	}
}