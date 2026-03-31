package com.junit.practice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenNumberTest {
	
	EvenNumber even = new EvenNumber();

	@ParameterizedTest
	@ValueSource(ints = {2,4,6,8})
	
	void testEvenNumber(int num) {
		assertTrue(even.isEven(num));
	}
	
	@ParameterizedTest
    @ValueSource(ints = {7, 9})
    void testOddNumbers(int num) {
		assertFalse(even.isEven(num));
    }
}
