package ECommerceOrderManagement;

public class UPIPayment implements Payment{
	
	public void pay(double amount)throws PaymentFailedException{
		if(amount > 100000) {
			throw new PaymentFailedException("UPI limit exceeds. Payment Failed!");
		}
		System.out.println("UPI payment of $" + amount + " is successful.");
	}
}
