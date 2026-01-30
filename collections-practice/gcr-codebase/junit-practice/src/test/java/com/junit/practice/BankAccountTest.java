package com.junit.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BankAccountTest {
	
	BankAccount acc = new BankAccount();	
	
	@Test
	void testDeposit() {
		acc.balance = 1000;
		assertTrue(acc.deposit(1000));
		assertEquals(2000,acc.getBalance());
	}

	@Test
	void testWithdraw() {
		acc.balance = 1500;
		assertTrue(acc.withdraw(1000));
		assertEquals(500,acc.getBalance());
	}

	@Test
	void testWithdrawFail() {
		acc.balance = 1500;
		assertFalse(acc.withdraw(2000));
		assertEquals(1500,acc.getBalance());
	}
	
	@Test
	void testGetBalance() {
		acc.balance = 500;
		assertEquals(500,acc.getBalance());
	}	
}