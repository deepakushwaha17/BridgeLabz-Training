package collections.list;
import java.util.*;

public class FindElementsFrequency {
	
	public static void countElements(ArrayList<String> list) {
		HashMap<String,Integer> freqMap = new HashMap<>();
		
		for(int i = 0; i < list.size(); i++) {
			String element = list.get(i);
			int count = 0;
			for(int j = 0; j < list.size(); j++) {
				if(element.equals(list.get(j))) {
					count++;
				}
			}
			freqMap.put(element, count);
		}
		System.out.println("Elements with frequency: " +freqMap);
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("banana");
		list.add("apple");
		list.add("orange");
		countElements(list);
	}

}
