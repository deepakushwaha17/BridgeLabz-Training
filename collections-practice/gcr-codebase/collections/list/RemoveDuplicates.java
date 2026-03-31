package collections.list;
import java.util.ArrayList;

public class RemoveDuplicates {
	public static void removeDuplicates(ArrayList<Integer> list) {
		System.out.println("Original list : "+list);
		for(int i = 0; i < list.size(); i++) {
			int element = list.get(i);
			for(int j = i+1; j < list.size(); j++) {
				if(element == list.get(j)) {
					list.remove(j);
				}
			}
		}
		System.out.println("List without duplicate elements : " + list);
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(4);
		removeDuplicates(list);

	}

}
