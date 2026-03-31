package generics.DynamicOnlineMarketplace;

//Generic class Product 
public class Product <T extends Category>{

	private String name;
	private double price;
	private T category;
	
	public Product(String name, double price, T category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public T getCategory() {
		return category;
	}
	
	// Method to display details
	public String getDetails() {
		return "Product: " + name + ", Price: $" + price + ", Category: " + category.getCategoryName();
	}
}
