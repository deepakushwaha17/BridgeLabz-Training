package com.junit.practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UnitTest {

    @Test
    public void Test_Deposit_ValidAmount() {
        // Arrange
        Program account = new Program(1000);

        // Act
        account.deposit(500);

        // Assert
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void Test_Deposit_NegativeAmount() {
        // Arrange
        Program account = new Program(1000);

        // Act + Assert
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-200);
        });

        assertEquals("Deposit amount cannot be negative", ex.getMessage());
    }

    @Test
    public void Test_Withdraw_ValidAmount() {
        // Arrange
        Program account = new Program(1000);

        // Act
        account.withdraw(300);

        // Assert
        assertEquals(700, account.getBalance());
    }

    @Test
    public void Test_Withdraw_InsufficientFunds() {
        // Arrange
        Program account = new Program(500);

        // Act + Assert
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(1000);
        });

        assertEquals("Insufficient funds.", ex.getMessage());
    }
}