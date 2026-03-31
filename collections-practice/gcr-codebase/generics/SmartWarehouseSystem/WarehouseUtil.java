package generics.SmartWarehouseSystem;
import java.util.List;

public class WarehouseUtil {

	// Wildcard method to display all items
	public static void displayItems(List<? extends WarehouseItem> items) {
		if(items.isEmpty()) {
			System.out.println("No item in Warehouse.");
			return;
		}
		System.out.println("\n------ Warehouse Items ------");
		for(WarehouseItem item : items) {
			System.out.println(item.getDetails());
		}
		System.out.println("-------------------------------");
	}
}
