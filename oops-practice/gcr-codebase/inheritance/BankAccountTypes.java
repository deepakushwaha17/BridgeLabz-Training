package inheritance;

public class BankAccountTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SavingsAccount sAccount = new SavingsAccount();
		sAccount.displayAccountType();
		CheckingAccount cAccount = new CheckingAccount();
		cAccount.displayAccountType();
		FixedDepositAccount fdAccount = new FixedDepositAccount();
		fdAccount.displayAccountType();
		

	}

}

//Base Class
class BankAccount{
	int accountAccount;
	double balance;
	
	void displayAccountType() {
		System.out.println("Generic Account");
	}
	
}

//Subclasses
class SavingsAccount extends BankAccount{
	
	double interestRate;
	
	@Override
	void displayAccountType() {
		System.out.println("Saving Account");
	}
	
}

class CheckingAccount extends BankAccount{
	
	double withdrawalLimit;
	
	@Override
	void displayAccountType() {
		System.out.println("Checking Account");
	}
	
}
class FixedDepositAccount extends BankAccount{
	
	@Override
	void displayAccountType() {
		System.out.println("Fixed Deposit Account");
	}
	
}