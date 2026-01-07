/*Online Banking System : Key Features (CRUD)
Real Scenario
Users perform transactions, check balance, and transfer money concurrently.Key Features
  - Account creation
  - Balance check
  - Fund transfer
  - Transaction history*/

package classandobject;

import java.util.ArrayList;
import java.util.HashMap;

public class OnlineBankingSystem {
	public static void main(String[] args) {

        Bank bank = new Bank();

        // Predefined accounts
        Account acc1 = bank.createAccount("Alice", "Savings", 1000);
        Account acc2 = bank.createAccount("Bob", "Current", 500);
        Account acc3 = bank.createAccount("Charlie", "Savings", 700);

        System.out.println("\n--- Starting Transactions ---\n");

        // Multiple threads withdrawing/depositing at the same time
        Thread t1 = new Thread(() -> {
            try { acc1.withdraw(700); } catch (InsufficientBalanceException e) { System.out.println(e.getMessage()); }
        });

        Thread t2 = new Thread(() -> {
            try { acc1.withdraw(500); } catch (InsufficientBalanceException e) { System.out.println(e.getMessage()); }
        });

        Thread t3 = new Thread(() -> bank.transferFunds(acc2, acc3, 300));

        Thread t4 = new Thread(() -> acc3.deposit(200));

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("\n--- Final Account Balances ---");
        System.out.println(acc1.getAccountHolder() + ": ₹" + acc1.checkBalance());
        System.out.println(acc2.getAccountHolder() + ": ₹" + acc2.checkBalance());
        System.out.println(acc3.getAccountHolder() + ": ₹" + acc3.checkBalance());

        System.out.println("\n--- Transaction Histories ---\n");
        acc1.printTransactionHistory();
        acc2.printTransactionHistory();
        acc3.printTransactionHistory();
    }

}

// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception{
	public InsufficientBalanceException(String message) {
		super(message);
	}
}

// BankService interface for abstraction
interface BankService{
	void deposit(double amount);
	void withdraw(double amount) throws InsufficientBalanceException;
	double checkBalance();
}

//Base class Account
abstract class Account implements BankService{
	protected double balance;
	private int accountNumber;
	private String accountHolder;
	private ArrayList<String> transactionHistory = new ArrayList<>();
	
	//constructor
	public Account(int accountNumber , String accountHolder , double balance) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}
	
	// public getter for account number
	public int getAccountNumber() {
		return accountNumber;
	}
	
	// public getter for account holder
	public String getAccountHolder() {
		return accountHolder;
	}
	
	// Deposit amount
	public void deposit(double amount) {
		balance += amount;
		transactionHistory.add("Deposited : $" +amount);
	}
	
	// Withdraw amount
	public void withdraw(double amount)throws InsufficientBalanceException {
		if(amount > balance) {
			throw new InsufficientBalanceException("Insufficient balance in account " + accountNumber);
		}
		balance -= amount;
		transactionHistory.add("Withdrawn : $" +amount);
	}
	
	// Check balance
	public double checkBalance() {
		return balance;
	}
	
	public void addTransaction(String record) {
		transactionHistory.add(record);
	}
	
	public void printTransactionHistory() {
		if(transactionHistory.isEmpty()) {
			System.out.println("No transaction yet performed!");
			return;
		}
		System.out.println("Transaction History for Account "+accountNumber);
		for(String transaction : transactionHistory) {
			System.out.println(transaction);
		}
	}
	
	// abstract method to calculate interest
	public abstract double calculateInterest();
}

// Account subclass - SavingsAccount class
class SavingsAccount extends Account{
	
	// constructor
	public SavingsAccount(int accountNumber , String accountHolder , double balance) {
		super(accountNumber, accountHolder , balance);
	}
	
	@Override
	public double calculateInterest() {
		return balance * 0.04 ; // 4% interest
	}
}

// Account subclass - CurrentAccount class
class CurrentAccount extends Account{
	
	// constructor
		public CurrentAccount(int accountNumber , String accountHolder , double balance) {
			super(accountNumber, accountHolder , balance);
		}
		
		@Override
		public double calculateInterest() {
			return balance * 0.02 ; // 2% interest
		}
}

// Bank class for handling account and transfers
class Bank{
	private HashMap<Integer , Account> accounts = new HashMap<>();
	int accountCounter = 10001;
	
	// Method to create account
	public Account createAccount(String accountHolder , String accountType , double balance) {
		int accountNumber = accountCounter++;
		Account account;
		if(accountType.equalsIgnoreCase("Savings")) {
			account = new SavingsAccount(accountNumber, accountHolder , balance);
		}
		else {
			account = new CurrentAccount(accountNumber, accountHolder , balance);
		}
		
		accounts.put(accountNumber, account);
		System.out.println(accountType + " Account created . \nAccount Number : " +accountNumber);
		return account;
	}
	
	//public getter to get account
	public Account getAccount(int accountNumber) {
		return accounts.get(accountNumber);
	}
	
	// Method to transfer funds
	public void transferFunds(Account from , Account to , double amount) {
		try {
			from.withdraw(amount);
			to.deposit(amount);
			from.addTransaction("Transferred $" +amount+ " to Account " +to.getAccountNumber());
			to.addTransaction("Received $" +amount+ " from Account "+from.getAccountNumber());
			System.out.println("Transfer successful!");
		}
		catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Method to view all accounts
	public void viewAllAccounts() {
		for(Account acc : accounts.values()) {
			System.out.println(acc.getAccountNumber() + " - " +acc.getAccountHolder() +  " - Balanace : $" +acc.checkBalance());
		}
	}
}
