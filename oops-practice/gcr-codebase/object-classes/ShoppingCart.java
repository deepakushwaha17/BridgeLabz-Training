package classandobject;

public class ShoppingCart {

	public static void main(String[] args) {
		CartItem cartItem = new CartItem("Laptop" ,999.99 , 1);
		cartItem.display();
		cartItem.addItem(2);
		cartItem.removeItem(1);
		System.out.println("Total cost : $"+cartItem.newPrice);

	}

}

class CartItem{
	private String itemName;
	private double price;
	private int quantity;
	double newPrice;
	
	public CartItem(String itemName,double price,int quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public void addItem(int addquantity) {
		System.out.println("\nAdded "+ addquantity + " of " + itemName + " to the cart.");
		quantity += addquantity;
		newPrice = price *= addquantity;
	}
	public void removeItem(int removequantity) {
		System.out.println("Removed "+ removequantity + " of " + itemName + " from the cart.");	
		quantity -= removequantity;
		newPrice = price *= removequantity;
	}
	public void display() {
		System.out.print("Item : " +itemName);
		System.out.print(" , Price :$ " +price);
		System.out.print(" , Quantity : " +quantity);
	}
}
