package BankingSystem;

public class BankAccount {
	
	private int balance = 10000;
	
	// race condition occur 
	public boolean withdraw(int amount) {
		if(balance >= amount) {
			System.out.println("Transaction successful: " + Thread.currentThread().getName() +
                    ", Amount: " + amount +
                    ", Balance: " + (balance - amount));
			
            balance -= amount;
            return true;
		}else {
            System.out.println("Transaction failed: " + Thread.currentThread().getName() +
                    ", Amount: " + amount +
                    ", Balance: " + balance);
            return false;
        }
	}

}
