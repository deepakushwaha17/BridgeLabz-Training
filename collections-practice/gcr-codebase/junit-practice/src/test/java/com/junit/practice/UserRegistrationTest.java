package com.junit.practice;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserRegistrationTest {

    UserRegistration registration = new UserRegistration();

    @Test
    void testValidUserRegistration() {
        assertTrue(registration.registerUser("Deepa","deepa@gmail.com","password123"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class,() -> 
        registration.registerUser("De","deepa@gmail.com","password123"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class,() -> 
        registration.registerUser("Deepa", "deepagmail.com", "password123"));
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class,() -> 
        registration.registerUser("Deepa","deepa@gmail.com","123"));
    }
}
