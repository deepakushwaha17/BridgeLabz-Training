package com.junit.practice;

public class TemperatureConverter {

	public double celsiusToFahrenheit(double celsius) {
		return (celsius * 1.8) + 32;
	}
	
	public double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5/9.0;
	}
}