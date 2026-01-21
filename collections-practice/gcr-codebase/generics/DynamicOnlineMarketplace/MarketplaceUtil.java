package generics.DynamicOnlineMarketplace;

public class MarketplaceUtil {

	// Generic method with bounded type parameter
	public static <T extends Product<? extends Category>> void applyDiscount(T product, double percentage) {
		double discountAmount = product.getPrice() * (percentage / 100);
		product.setPrice(product.getPrice() - discountAmount);
		System.out.println("Discount of " + percentage + "% applied to " + product.getName()
		  + ". \nNew Price: $" + product.getPrice());
		
	}
}
