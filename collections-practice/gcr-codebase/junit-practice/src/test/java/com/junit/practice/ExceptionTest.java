package com.junit.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ExceptionTest {
	
	ExceptionHandling obj = new ExceptionHandling();
	@Test
	void testDivide() {
		assertEquals(2, obj.divide(4, 2));
	}
	@Test
    void testDivideByZero() {
        // Check that ArithmeticException is thrown
        Exception exception = assertThrows(ArithmeticException.class, () -> obj.divide(5, 0));
        assertEquals("Division by zero is not allowed!", exception.getMessage());
    }

}
