package com.junit.practice;

import java.util.List;

public class ListManager {
	
	// Add element
	public boolean addElement(List<Integer> list, int element) {
		return list.add(element);
	}

	// Remove element
	public boolean removeElement(List<Integer> list, int element) {
		return list.remove(Integer.valueOf(element));
	}
	
	// Get list size
	public int getSize(List<Integer> list) {
		return list.size();
	}
}