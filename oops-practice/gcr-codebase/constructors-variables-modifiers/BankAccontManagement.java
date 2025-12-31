package classandobject;

public class BankAccontManagement {

	public static void main(String[] args) {
		BankAccount b1 = new BankAccount("ACC123", "Deepa", 50000);
        b1.displayAccount();

        b1.setBalance(55000);
        System.out.println("Updated Balance: ₹" + b1.getBalance());

        SavingsAccount s1 = new SavingsAccount("ACC456", "Rohan", 75000, 4.5);
        s1.displaySavingsAccount();
	}

}


class BankAccount {

	 public String accountNumber;
	 protected String accountHolder;
	 private double balance;


	 BankAccount(String accountNumber, String accountHolder, double balance) {
	     this.accountNumber = accountNumber;
	     this.accountHolder = accountHolder;
	     this.balance = balance;
	 }

	 // Public getter for private balance
	 public double getBalance() {
	     return balance;
	 }

	 // Public setter to modify balance
	 public void setBalance(double balance) {
	     if (balance >= 0)
	         this.balance = balance;
	     else
	         System.out.println("Invalid balance.");
	 }
	
	 public void displayAccount() {
	     System.out.println("Account Number: " + accountNumber +
	         ", Account Holder: " + accountHolder + ", Balance: ₹" + balance );
	 }
}

//Subclass to demonstrate access to public and protected members
class SavingsAccount extends BankAccount {

	 double interestRate;

	 SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
	     super(accountNumber, accountHolder, balance);
	     this.interestRate = interestRate;
	 }
	
	 void displaySavingsAccount() {
	     System.out.println("Account Number: " + accountNumber +  ", Account Holder: " + accountHolder +
	         ", Balance: ₹" + getBalance() + ", Interest Rate: " + interestRate + "%");
	 }
}

