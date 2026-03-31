package generics.SmartWarehouseSystem;

import java.util.ArrayList;
import java.util.List;

// Generic class (Bounded Type Parameter)
public class Storage<T extends WarehouseItem> {

	private List<T> items = new ArrayList<>();
	
	public void addItem(T item) {
		items.add(item);
		System.out.println(item.getCategory() + " added to storage.");
	}
	
	public List<T> getItems(){
		return items;
	}
}
