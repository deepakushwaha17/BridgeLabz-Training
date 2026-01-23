package collections.list;
import java.util.*;

public class RotateListElements {
	
	public static void rotateElements(ArrayList<Integer> list,int index) {
		System.out.println("Original list : "+list);
		for(int i = 0 ; i < 2; i++) {
			int j = 0;
			int element = list.remove(j);
			list.add(element);
		}
		System.out.println("Rotated List : " +list);
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		rotateElements(list,2);
	}
}