package com.junit.practice;

public class StringUtils {
	
	// Reverse String
	public String reverse(String str) {
		String reversedString= "";
		for(int  i = str.length()-1; i >= 0; i--) {
			char ch = str.charAt(i);
			reversedString += ch;
		}
		return reversedString;
	}
	
	// Check Palindrome
	public boolean isPalindrome(String str) {
		if(str.equals(reverse(str))) {
			return true;
		}
		return false;
	}
	
	// Convert to uppercase
	public String toUpperCase(String str) {
		return str.toUpperCase();
	}
	
}
