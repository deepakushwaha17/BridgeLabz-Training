package BankAccountHierarchy;

public class SavingsAccount extends BankAccount {

	public SavingsAccount(String accountNumber,double balance) {
		super(accountNumber,balance);
	}

	@Override
	public double calculateFee() {
		return (super.getBalance() * 0.5)/100;
	}
}
