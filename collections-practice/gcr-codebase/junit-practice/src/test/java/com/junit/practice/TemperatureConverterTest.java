package com.junit.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

	TemperatureConverter convert = new TemperatureConverter();
	
	@Test
	void testCelsius() {
		assertEquals(68,convert.celsiusToFahrenheit(20));
	}
	
	@Test
	void testFahrenheit() {
		assertEquals(20,convert.fahrenheitToCelsius(68));
	}
}
