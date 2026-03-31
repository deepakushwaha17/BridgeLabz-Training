package BankAccountHierarchy;

public abstract class BankAccount {

	private final String accountNumber;
	private double balance;
	
	public BankAccount(String accountNumber,double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	
	//abstract method 
	abstract double calculateFee();
	
}