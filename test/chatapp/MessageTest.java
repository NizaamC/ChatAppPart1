/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

package chatapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {

    @Test
    public void testMessageLengthValid() {
        Message msg = new Message("+27718693002", "Hello world");
        assertEquals("Message ready to send.", msg.validateMessageLength());
    }

    @Test
    public void testMessageLengthInvalid() {
        String longMsg = "a".repeat(260);
        Message msg = new Message("+27718693002", longMsg);
        assertTrue(msg.validateMessageLength().contains("exceeds"));
    }

    @Test
    public void testRecipientValid() {
        Message msg = new Message("+27718693002", "Hi");
        assertTrue(msg.checkRecipientCell());
    }

    @Test
    public void testMessageIDLength() {
        Message msg = new Message("+27718693002", "Hi");
        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testHashFormat() {
        Message msg = new Message("+27718693002", "Hi there");
        String hash = msg.createMessageHash();
        assertTrue(hash.contains(":"));
    }
}