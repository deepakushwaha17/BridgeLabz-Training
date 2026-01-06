package oopsPillars;

public class ECommercePlatform {

	
	public static void printFinalPrice(Product product) {
		double price = product.getPrice();
		double discount = product.calculateDiscount();
		double tax = 0;
		
		if(product instanceof Taxable) {
			Taxable taxable = (Taxable) product;
			tax = taxable.calculateTax();
			System.out.println(taxable.getTaxDetails());
		}
		
		double finalPrice = price + tax - discount;
		
		product.displayProductDetails();
		System.out.println("Discount : $" +discount);
		System.out.println("Tax : $" +tax);
		System.out.println("Final Price : $" +finalPrice);

	}
	
	public static void main(String[] args) {

		Product[] product = new Product[3];
		product[0] = new Electronics("E101" , "Mobile Phone" ,45000.0,5.0,18);
		product[1] = new Clothing("C101" , "Lehenga" , 16000.0,3.0,12);
		product[2] = new Groceries("G101" ,"Tea",45,1,5);
		
		for(Product p : product) {
			printFinalPrice(p);
		}
 	}

}

//abstract class Product
abstract class Product{
	private String productId , name;
	private double price;
	
	//constructor
	Product(String productId , String name , double price){
		this.productId = productId;
		this.name = name;
		setPrice(price);
	}
	
	//public getter for product id 
	public String getProductID() {
		return productId;
	}
	
	//public getter for product name 
	public String getName() {
		return name;
	}
	
	//public getter for product price 
	public double getPrice() {
		return price;
	}
	
	//public setter for price with validation
	public void setPrice(double price) {
		if(price > 0) {
			this.price = price;
		}else {
			System.out.println("Price cannot be negative.");
		}	
	}
	
	//abstract method
	abstract double calculateDiscount();
	
	public void displayProductDetails() {
		System.out.println("Product Id : " +productId);
		System.out.println("Product Name : " +name);
		System.out.println("Product price : " +price);
	}
}

//interface Taxable
interface Taxable{
	double calculateTax();
	String getTaxDetails();
}

//concrete classes
class Electronics extends Product implements Taxable{
	
	double discount , taxRate;
	
	//constructor
	Electronics(String productId , String name , double price, double discount, double taxRate){
		super(productId , name , price);
		this.discount = discount ; 
		this.taxRate = taxRate;
	}
	
	//calculate discount on price
	@Override
	double calculateDiscount() {
		return getPrice() * discount / 100;
	}
	
	//calculate tax on price
	@Override
	public double calculateTax() {
		return getPrice() * taxRate / 100;
	}
	
	//get tax details
	public String getTaxDetails() {
		return "\nTax on Electronics : " +taxRate + "%";
	}
}


class Clothing extends Product implements Taxable{
	
	double discount , taxRate;
	
	//constructor
	Clothing(String productId , String name , double price, double discount, double taxRate){
		super(productId , name , price);
		this.discount = discount ; 
		this.taxRate = taxRate;
	}
	
	//calculate discount on price
	@Override
	double calculateDiscount() {
		return getPrice() * discount / 100;
	}
	
	//calculate tax on price
	@Override
	public double calculateTax() {
		return getPrice() * taxRate / 100;
	}
	
	//get tax details
	public String getTaxDetails() {
		return "\nTax on Clothing : " +taxRate + "%";
	}
}


class Groceries extends Product implements Taxable{
	
	double discount , taxRate;
	
	//constructor
	Groceries(String productId , String name , double price, double discount, double taxRate){
		super(productId , name , price);
		this.discount = discount ; 
		this.taxRate = taxRate;
	}
	
	//calculate discount on price
	@Override
	double calculateDiscount() {
		return getPrice() * discount / 100;
	}
	
	//calculate tax on price
	@Override
	public double calculateTax() {
		return getPrice() * taxRate / 100;
	}
	
	//get tax details
	public String getTaxDetails() {
		return "\nTax on Groceries : " +taxRate + "%";
	}
}