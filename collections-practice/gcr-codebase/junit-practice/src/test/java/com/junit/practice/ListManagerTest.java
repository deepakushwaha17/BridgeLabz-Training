package com.junit.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class ListManagerTest {
	
	//Create object
	ListManager test = new ListManager();
	
	ArrayList<Integer> list = new ArrayList<>();

	@Test
	void testAdd() {
		assertEquals(true , test.addElement(list,10));
		assertEquals(true , test.addElement(list,20));
	}
		
	@Test
	void testRemove() {
		assertEquals(true , test.addElement(list,10));
		assertEquals(true , test.addElement(list,20));
		assertEquals(true , test.removeElement(list,10));
	}
		
	@Test
	void testSize() {
		assertEquals(true , test.addElement(list,10));
		assertEquals(true , test.addElement(list,20));
		assertEquals(true , test.removeElement(list,10));
		assertEquals(1 , test.getSize(list));
	}

}
