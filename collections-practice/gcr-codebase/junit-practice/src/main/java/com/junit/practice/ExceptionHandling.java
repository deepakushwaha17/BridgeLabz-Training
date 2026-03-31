package com.junit.practice;

public class ExceptionHandling {
	
	 // Division with exception handling
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed!");
        }
        return a / b;
    }
}