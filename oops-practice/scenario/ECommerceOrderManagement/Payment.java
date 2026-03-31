package ECommerceOrderManagement;

public interface Payment {

	void pay(double amount)throws PaymentFailedException;
}
