package generics.SmartWarehouseSystem;

public class Electronics extends WarehouseItem{

	public Electronics(String name , double price) {
		super(name,price);
	}

	@Override
	public String getCategory() {
		return "Electronics";
	}
}
