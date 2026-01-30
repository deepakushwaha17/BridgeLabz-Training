package com.junit.practice;

public class BankAccount {
	
	double balance;
	public boolean deposit(double amount) {
		balance += amount;
		return true;
	}

	public boolean withdraw(double amount) {
		if(amount > balance) {
			return false;
		}
		balance -= amount;
		return true; 
	}
	
	public double getBalance() {
		return balance;
	}
}
