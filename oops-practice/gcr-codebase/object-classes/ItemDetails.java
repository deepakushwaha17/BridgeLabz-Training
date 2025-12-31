package classandobject;

public class ItemDetails {

	public static void main(String[] args) {
		Item item1 = new Item("01AA","Water bottle" , 500.0);
		item1.displayDetails();
		Item item2 = new Item("01BB","Rice" , 700.0);
		item2.displayDetails();
		Item item3 = new Item("02AA","Black Board" , 400.0);
		item3.displayDetails();
	}

}

class Item{
	private String itemCode;
	private String itemName;
	private double price;
	
	public Item(String itemCode , String itemName , double price) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.price = price;
	}
	
	public void displayDetails() {
		System.out.println("itemCode : " +itemCode);
		System.out.println("itemPrice : " +price);
		System.out.println("itemName : " +itemName);
		System.out.println("-----------------------");
	}
}
