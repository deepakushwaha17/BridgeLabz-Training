package annotations;

import java.util.ArrayList;

public class SuppressUncheckedWarnings {

	@SuppressWarnings("unchecked") 
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		list.add(10);
		list.add("Heelo");
		
		System.out.println(list);
	}
}