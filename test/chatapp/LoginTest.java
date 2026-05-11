/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package chatapp;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nizaam
 */


public class LoginTest {

    Login login = new Login();

    @Test
    public void testUsernameValid() {
        assertTrue(login.checkUserName("abc_1"));
    }

    @Test
    public void testUsernameInvalid() {
        assertFalse(login.checkUserName("abcdef"));
    }

    @Test
    public void testPasswordValid() {
        assertTrue(login.checkPasswordComplexity("Password@1"));
    }

    @Test
    public void testPasswordInvalid() {
        assertFalse(login.checkPasswordComplexity("pass"));
    }

    @Test
    public void testCellphoneValid() {
        assertTrue(login.checkCellphoneNumber("0831234567"));
    }

    @Test
    public void testLoginSuccess() {
        login.registerUser("abc_1", "Password@1", "0831234567", "A", "B");
        assertTrue(login.loginUser("abc_1", "Password@1"));
    }
}
    