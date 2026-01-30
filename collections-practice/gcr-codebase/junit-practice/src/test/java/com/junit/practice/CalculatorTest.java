package com.junit.practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    // Create Calculator object
    Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(7, calc.add(3, 4));
    }

    @Test
    void testSubtract() {
        assertEquals(2, calc.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(15, calc.multiply(3, 5));
    }

    @Test
    void testDivide() {
        assertEquals(4, calc.divide(8, 2));
    }

    @Test
    void testDivideByZero() {
        // Check that ArithmeticException is thrown
        Exception exception = assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
        assertEquals("Division by zero is not allowed!", exception.getMessage());
    }
}
