package functionalInterface;

interface PaymentProcessor {
    
    void pay(double amount);
    
    default void refund(double amount) {
        System.out.println("Refund of $" + amount + " is processed using default method.");
    }
}

class PayPal implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("PayPal processed payment of $" + amount);
    }
}

class Razorpay implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Razorpay processed payment of $" + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Razorpay refunded $" + amount + " successfully!");
    }
}
public class PaymentGatewayIntegration {
	public static void main(String[] args) {
        PaymentProcessor paypal = new PayPal();
        PaymentProcessor razorpay = new Razorpay();

        paypal.pay(100);
        paypal.refund(50);  // calls default method

        razorpay.pay(200);
        razorpay.refund(100); // calls overridden method in razorpay
    }
}
