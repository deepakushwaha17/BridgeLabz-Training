package classandobject;

public class BankAccountDetails {
	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount("Deepa" , "4683637" , 700.0);
		bankAccount.diaplayDetails();
		bankAccount.depositMoney(200.0);
		bankAccount.withdrawMoney(100.0);
		bankAccount.withdrawMoney(900.0);
	}

}

class BankAccount{
	private String accountHolder;
	private String accountNumber;
	private double balance;
	
	public BankAccount(String accountHolder , String accountNumber , double balance) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public void diaplayDetails() {
		System.out.println("Current balance : " +balance);
	}
	public void depositMoney(double depositAmt) {
		System.out.println("Deposited : " + depositAmt);
		balance += depositAmt;
		System.out.println("Current balance : " +balance);
	}
	
	public void withdrawMoney(double withdrawAmt) {
		if(balance >= withdrawAmt) {
			System.out.println("Withdraw amount is : " + withdrawAmt);
			balance -= withdrawAmt;
			System.out.println("Current balance : " +balance);
		}
		else {
			System.out.println("Insufficient balance");
		}
	}
}
