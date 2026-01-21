package reviews;

public class OnlinePaymentGateway {

	public static void main(String[] args) {
		Payment card = new CreditCard();
		card.pay(50000);
		
		Payment upi = new UPI();
		upi.pay(100000);
		
		Payment wallet = new Wallet();
		wallet.pay(1000);
		
		Payment banking = new NetBanking();
		banking.pay(70000);
	}

}

interface Payment{
	void pay(double amount);
}

class CreditCard implements Payment{
	
	public void pay(double amount) {
		if(amount > 100000) {
			System.out.println("Credit Card limit exceeds.");
			return;
		}
		System.out.println("Credit card payment successfull of amount $" +amount);
	}
}

class UPI implements Payment{
	
	public void pay(double amount) {
		if(amount > 50000) {
			System.out.println("UPI limit exceeds.");
			return;
		}
		System.out.println("UPI payment successfull of amount $" +amount);
	}
}

class Wallet implements Payment{
	
	public void pay(double amount) {
		if(amount > 10000) {
			System.out.println("Wallet limit exceeds.");
			return;
		}
		System.out.println("Wallet payment successfull of amount $" +amount);
	}
}

class NetBanking implements Payment{
	
	public void pay(double amount) {
		if(amount > 10000) {
			System.out.println("Net Banking limit exceeds.");
			return;
		}
		System.out.println("Net banking payment successfull of amount $" +amount);
	}
}