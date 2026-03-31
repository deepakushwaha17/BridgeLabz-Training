package collections.list;

import java.util.*;

public class ReverseList {

	public static void reverseArrayList(ArrayList<Integer> list) {
		System.out.println("Original array list: "+ list);
		int start = 0;
		int end = list.size() - 1;
		while(start <= end) {
			int temp = list.get(start);
			list.set(start, list.get(end));
			list.set(end, temp);
			start ++;
			end--;
		}
		System.out.println("Reversed array list: "+ list);
	}
	
	public static void reverseLinkedList(LinkedList<Integer> linkedList) {
		System.out.println("\nOriginal linked list: "+ linkedList);
		int start = 0;
		int end = linkedList.size() - 1;
		while(start <= end) {
			int temp = linkedList.get(start);
			linkedList.set(start, linkedList.get(end));
			linkedList.set(end, temp);
			start ++;
			end--;
		}
		System.out.println("Reversed linked list: "+ linkedList);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		reverseArrayList(list);
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(40);
		linkedList.add(50);
		reverseLinkedList(linkedList);
		
	}

}
