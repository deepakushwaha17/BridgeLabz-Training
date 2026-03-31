package ECommerceOrderManagement;

public class CardPayment implements Payment {

	public void pay(double amount)throws PaymentFailedException{
		if(amount <= 0) {
			throw new PaymentFailedException("Card Amount cannot be negative. Payment Failed!");
		}
		System.out.println("Card payment of $" + amount + " is successful.");
	}
}
