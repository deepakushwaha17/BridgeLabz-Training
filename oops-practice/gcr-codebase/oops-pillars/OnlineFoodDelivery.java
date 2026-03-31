package oopsPillars;

public class OnlineFoodDelivery {
	public static void processOrder(FoodItem[] items) {
        double grandTotal = 0;

        for (FoodItem item : items) {
            item.getItemDetails();

            double totalPrice = item.calculateTotalPrice();
            double discount = 0;

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                discount = d.applyDiscount();
                System.out.println(d.getDiscountDetails());
            }

            double finalPrice = totalPrice - discount;
            System.out.println("Total Price: " + totalPrice);
            System.out.println("Discount: " + discount);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("-------------------------");

            grandTotal += finalPrice;
        }

        System.out.println("Grand Total Amount: " + grandTotal);
    }
	
	public static void main(String[] args) {

        FoodItem[] order = new FoodItem[3];

        order[0] = new VegItem("Paneer Butter Masala", 200, 2, 10);
        order[1] = new NonVegItem("Chicken Biryani", 300, 1, 50, 5);
        order[2] = new VegItem("Veg Fried Rice", 150, 1, 8);

        processOrder(order);
    }

}

//abstract method
abstract class FoodItem {

    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        setPrice(price);
        setQuantity(quantity);
    }

    //public getters for attributes
    public String getItemName() {
    	return itemName;
    }
    public double getPrice() { 
    	return price; 
    }
    public int getQuantity() {
    	return quantity;
    }

    //public setters
    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
        else
            System.out.println("Invalid price");
    }

    public void setQuantity(int quantity) {
        if (quantity > 0)
            this.quantity = quantity;
        else
            System.out.println("Invalid quantity");
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

//interface
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

//subclasses
class VegItem extends FoodItem implements Discountable {

    double discountRate;

    public VegItem(String name, double price, int quantity, double discountRate) {
        super(name, price, quantity);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * discountRate / 100;
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Discount: " + discountRate + "%";
    }
}

class NonVegItem extends FoodItem implements Discountable {

    double extraCharge;   // Non-veg handling charge
    double discountRate;

    public NonVegItem(String name, double price, int quantity,
                      double extraCharge, double discountRate) {
        super(name, price, quantity);
        this.extraCharge = extraCharge;
        this.discountRate = discountRate;
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + extraCharge;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * discountRate / 100;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Discount: " + discountRate + "%";
    }
}

