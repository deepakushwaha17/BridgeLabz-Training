package ECommerceOrderManagement;

public class WalletPayment implements Payment {

	public void pay(double amount)throws PaymentFailedException{
		if(amount > 10000) {
			throw new PaymentFailedException("Insufficient Wallet Balance. Payment Failed!");
		}
		System.out.println("Wallet payment of $" + amount + " is successful.");
	}
}
