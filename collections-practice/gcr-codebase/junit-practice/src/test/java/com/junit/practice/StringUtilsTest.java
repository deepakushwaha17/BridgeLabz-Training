package com.junit.practice;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
	
	//Create object
	StringUtils util ;
	
	@BeforeEach
	void setUp() {
		util = new StringUtils();
		 System.out.println("Before each test");
	}
	
	@Test
	void testReverse() {
		assertEquals("olleh" , util.reverse("hello"));
	}
	
	@Test
	void testIsPlaindrome() {
		assertEquals(true , util.isPalindrome("mom"));
	}
	
	@Test
	void testToUppercase() {
		assertEquals("DEEPA" , util.toUpperCase("Deepa"));
	}

}
