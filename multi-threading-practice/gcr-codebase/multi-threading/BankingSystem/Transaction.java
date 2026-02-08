package BankingSystem;

public class Transaction implements Runnable {
	
	private BankAccount account;
	private int amount;
	 
	public Transaction(BankAccount account, int amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "] Attempting to withdraw " + amount);
        account.withdraw( amount);
	}
}
