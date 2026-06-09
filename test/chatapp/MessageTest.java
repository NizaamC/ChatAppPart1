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

        Message msg =
                new Message(
                        "+27718693002",
                        "Hello world",
                        "Sent");

        assertEquals(
                "Message ready to send.",
                msg.validateMessageLength());
    }

    @Test
    public void testMessageLengthInvalid() {

        String longMsg = "a".repeat(260);

        Message msg =
                new Message(
                        "+27718693002",
                        longMsg,
                        "Sent");

        assertTrue(
                msg.validateMessageLength()
                        .contains("exceeds"));
    }

    @Test
    public void testRecipientValid() {

        Message msg =
                new Message(
                        "+27718693002",
                        "Hi",
                        "Sent");

        assertTrue(msg.checkRecipientCell());
    }

    @Test
    public void testRecipientInvalid() {

        Message msg =
                new Message(
                        "0831234567",
                        "Hi",
                        "Sent");

        assertFalse(msg.checkRecipientCell());
    }

    @Test
    public void testMessageIDLength() {

        Message msg =
                new Message(
                        "+27718693002",
                        "Hi",
                        "Sent");

        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testHashFormat() {

        Message msg =
                new Message(
                        "+27718693002",
                        "Hi Mike",
                        "Sent");

        String hash = msg.createMessageHash();

        assertTrue(hash.contains(":"));
    }

    @Test
    public void testSendMessageOption() {

        Message msg =
                new Message(
                        "+27718693002",
                        "Hello",
                        "Sent");

        assertEquals(
                "Message successfully sent.",
                msg.sentMessage(1));
    }

    @Test
    public void testDisregardMessageOption() {

        Message msg =
                new Message(
                        "+27718693002",
                        "Hello",
                        "Disregard");

        assertEquals(
                "Press 0 to delete the message.",
                msg.sentMessage(2));
    }

    @Test
    public void testStoreMessageOption() {

        Message msg =
                new Message(
                        "+27718693002",
                        "Hello",
                        "Stored");

        assertEquals(
                "Message successfully stored.",
                msg.sentMessage(3));
    }

    @Test
    public void testFlagStoredCorrectly() {

        Message msg =
                new Message(
                        "+27718693002",
                        "Hello",
                        "Stored");

        assertEquals(
                "Stored",
                msg.getFlag());
    }
}