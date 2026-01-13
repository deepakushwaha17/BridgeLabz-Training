package ECommerceOrderManagement;

import java.util.Scanner;
import java.util.ArrayList;

public class ECommerceSystem {
	
	static Product[] products = {new Product(101,"Laptop" , 50000),
			new Product(102,"Home Decor" , 4000),new Product(103,"Copper Water Bottle" , 1000),
			new Product(104,"HeadPhones" , 5000),new Product(105,"Gucci Handbag" , 70000)};
	
	static ArrayList<Order> orders = new ArrayList<>();
	
	static int orderCounter = 1; 

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Customer customer = new Customer(201,"Anshul");
		
		while(true) {
			System.out.println("\n------E-Commerce Order Management System------");
			System.out.println("1. View Product Catalog.");
			System.out.println("2. Place order.");
			System.out.println("3. Cancel order.");
			System.out.println("4. Display orders.");
			System.out.println("5. Exit.");
			
			System.out.print("\nEnter choice : ");
			int choice = input.nextInt();
			input.nextLine();
			
			switch(choice) {
				case 1:
					productCatalog();
					break;
				case 2 :
					System.out.print("Enter Product Id : ");
					int productId = input.nextInt();
					input.nextLine();
					System.out.print("Enter Payment Method(1-Card /2-UPI /3-Wallet) : ");
					int paymentChoice = input.nextInt();
					input.nextLine();
					
					Payment payment = null;
					switch(paymentChoice) {
						case 1:
							payment = new CardPayment();
							break;
						case 2:
							payment = new UPIPayment();
							break;
						case 3:
							payment = new WalletPayment();
							break;
						default :
							System.out.println("Invalid payment method");
							break;
					}
					placeOrder(customer , productId , payment);
					break;
				case 3:
					System.out.print("Enter Order Id to cancel :");
					int orderId = input.nextInt();
					input.nextLine();
					cancelOrder(orderId);
					break;
				case 4:
					displayOrders();
					break;
				case 5:
					System.out.println("Thank you for shopping.");
					System.exit(0);
				default :
					System.out.println("Invalid choice!");
			}

		}
		
	}
	
	//product catalog
	public static void productCatalog() {
		System.out.println("------Product Catalog-----");
		for(Product p : products) {
			System.out.println(p.getProductId() + " | " + p.getProductName() + " | $" + p.getPrice());
		}
	}
	//place order
	public static void placeOrder(Customer customer , int productId, Payment payment) {
		for(Product p : products) {
			if(p.getProductId() == productId) {
				try {
					payment.pay(p.getPrice());
					Order order = new Order(orderCounter++ , customer ,p);
					orders.add(order);
					System.out.println("Order placed successfully.");
				}catch(PaymentFailedException e) {
					System.out.println("Payment Failed : " +e.getMessage());
				}
				return;
			}
			
			
		}
		System.out.println("Product not found.");	
	}
	
	//cancel order
	public static void cancelOrder(int orderId) {
		for(Order o : orders) {
			if(o.getOrderId() == orderId) {
				o.cancelOrder();
				System.out.println("Order cancelled successfully.");
				return;
			}
		}
		System.out.println("Order not found.");
	}
	
	//display orders
	public static void displayOrders() {
		if(orders.isEmpty()) {
			System.out.println("No order placed.");
			return;
		}
		for(Order o : orders) {
			o.displayOrder();
		}
	}

}