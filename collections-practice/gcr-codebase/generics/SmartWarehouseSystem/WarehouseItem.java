package generics.SmartWarehouseSystem;

public abstract class WarehouseItem {
	private String name;
	private double price;

	public WarehouseItem(String name , double price) {
		this.name = name;
		this.price = price;
	}
	
	public abstract String getCategory();
	
	public String getDetails() {
		return "Item : " + name + ", Price : $" + price + ", Category : " + getCategory();
	}

}
