package classandobject;

public class Product {
	
	static double discount = 0.0; // static variable
	private String productName ;
	private double price;
	private int quantity;
	final String productID;
	
	public Product(String productID, String productName, double price , int quantity) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	//static method
	public static void updateDiscount(double newDiscount) {
		discount = newDiscount;
		
	}
	
	public double calculateDiscountPrice() {
		return price - (price * discount /100);
		
	}
	
	public void displayProductDetails() {
		if(this instanceof Product) {
			System.out.println("Product ID : " +productID);
			System.out.println("Product Name : " +productName);
			System.out.println("Price : $" +price);
			System.out.println("Qunatity : " +quantity);
			System.out.println("Discount : " +discount+"%");
			System.out.println("Price after Discount : $" +calculateDiscountPrice());
		}
		else {
			System.out.println("Invalid Product instance!");

		}
	}
	public static void main(String[] args) {
		Product product1 = new Product("P001", "Laptop" ,1200.0,5);
		Product product2 = new Product("P002", "Smartphone" ,800.0,10);
		
		updateDiscount(10.0);
		product1.displayProductDetails();
		product2.displayProductDetails();

	}

}
