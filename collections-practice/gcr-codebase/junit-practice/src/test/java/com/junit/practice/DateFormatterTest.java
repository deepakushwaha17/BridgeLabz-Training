package com.junit.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DateFormatterTest {
	
	DateFormatter format = new DateFormatter();
	
	@Test
	void textDate() {
		assertEquals("30-01-2026" , format.formatDate("2026-01-30"));
	}

}
