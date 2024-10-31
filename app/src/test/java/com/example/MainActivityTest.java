package com.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.junit.MainActivity;

import org.junit.Before;
import org.junit.Test;

public class MainActivityTest {

    private MainActivity mainActivity;

    @Before
    public void setUp() {
        mainActivity = new MainActivity();
    }

    /**
     * Test for a valid password that meets all complexity requirements.
     */
    @Test
    public void testValidPassword() {
        String validPassword = "Password123#";
        assertTrue("Expected password to meet all complexity requirements",
                mainActivity.checkPasswordComplexity(validPassword));
    }

    /**
     * Test for password missing an uppercase letter.
     */
    @Test
    public void testMissingUpperCase() {
        String password = "password123#";
        assertFalse("Expected password to fail due to missing uppercase letter",
                mainActivity.checkPasswordComplexity(password));
    }

    /**
     * Test for password missing a lowercase letter.
     */
    @Test
    public void testMissingLowerCase() {
        String password = "PASSWORD123#";
        assertFalse("Expected password to fail due to missing lowercase letter",
                mainActivity.checkPasswordComplexity(password));
    }

    /**
     * Test for password missing a number.
     */
    @Test
    public void testMissingNumber() {
        String password = "Password#";
        assertFalse("Expected password to fail due to missing number",
                mainActivity.checkPasswordComplexity(password));
    }

    /**
     * Test for password missing a special character.
     */
    @Test
    public void testMissingSpecialCharacter() {
        String password = "Password123";
        assertFalse("Expected password to fail due to missing special character",
                mainActivity.checkPasswordComplexity(password));
    }

    /**
     * Test for password containing only special characters.
     */
    @Test
    public void testOnlySpecialCharacters() {
        String password = "!@#$%^&*";
        assertFalse("Expected password to fail as it contains only special characters",
                mainActivity.checkPasswordComplexity(password));
    }

    /**
     * Test for password containing only numbers.
     */
    @Test
    public void testOnlyNumbers() {
        String password = "12345678";
        assertFalse("Expected password to fail as it contains only numbers",
                mainActivity.checkPasswordComplexity(password));
    }

    /**
     * Test for password containing only uppercase letters.
     */
    @Test
    public void testOnlyUpperCaseLetters() {
        String password = "PASSWORD";
        assertFalse("Expected password to fail as it contains only uppercase letters",
                mainActivity.checkPasswordComplexity(password));
    }

    /**
     * Test for password containing only lowercase letters.
     */
    @Test
    public void testOnlyLowerCaseLetters() {
        String password = "password";
        assertFalse("Expected password to fail as it contains only lowercase letters",
                mainActivity.checkPasswordComplexity(password));
    }
}
