package functionalInterface;

interface Payment{
	void pay();
}

class UPI implements Payment{
	@Override
	public void pay() {
		System.out.println("Paying through UPI...");
	}
}

class CreditCard implements Payment{
	@Override
	public void pay() {
		System.out.println("Paying through Credit Card...");
	}
}

class Wallet implements Payment{
	@Override
	public void pay() {
		System.out.println("Paying through Wallet...");
	}
}

public class DigitalPayment {

	public static void main(String[] args) {
		UPI upi = new UPI();
		upi.pay();
		
		CreditCard card = new CreditCard();
		card.pay();
		
		Wallet wallet = new Wallet();
		wallet.pay();
	}
}