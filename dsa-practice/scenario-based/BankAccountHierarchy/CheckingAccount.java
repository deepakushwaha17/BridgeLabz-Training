package BankAccountHierarchy;

public class CheckingAccount extends BankAccount{

	public CheckingAccount(String accountNumber,double balance) {
		super(accountNumber,balance);
	}

	@Override
	public double calculateFee() {
		if(super.getBalance() < 1000) {
			return 1.00;
		}
		return 0.00;
	}
}
