package com.junit.practice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

	PasswordValidator validator = new PasswordValidator();
	
	@Test
	void testPassword() {
		assertTrue(validator.isValid("Deepa1234"));
	}
	
	@Test
	void testPasswordFalse() {
		assertFalse(validator.isValid("Deepa@1234"));
	}
}
