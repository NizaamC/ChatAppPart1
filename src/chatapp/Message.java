/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;
import java.util.Random;

/**
 *
 * @author nizaam
 */

public class Message {

    private String messageID;
    private String recipient;
    private String messageText;
    private String messageHash;
    private String flag;

    private static int messageCount = 0;

    public Message(String recipient, String messageText, String flag) { 
        this.messageID = generateMessageID();
        this.recipient = recipient;
        this.messageText = messageText;
        this.flag = flag;
        this.messageHash = createMessageHash();
        messageCount++;
        
    }

    private String generateMessageID() {
        Random rand = new Random();
        long number = (long)(rand.nextDouble() * 10000000000L);
        return String.format("%010d", number);
    }

    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    public boolean checkRecipientCell() {
        return recipient.matches("^\\+27\\d{9}$");
    }

    public String validateMessageLength() {
        if (messageText.length() > 250) {
            int excess = messageText.length() - 250;
            return "Message exceeds 250 characters by " + excess + "; please reduce the size.";
        }
        return "Message ready to send.";
    }

    public String createMessageHash() {
        
        String[] words = messageText.trim().split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return (messageID.substring(0, 2)
                + ":" + messageCount
                + ":" + firstWord + lastWord).toUpperCase();
    }

    public String sentMessage(int option) {
        switch (option) {
            case 1: return "Message successfully sent.";
            case 2: return "Press 0 to delete the message.";
            case 3: return "Message successfully stored.";
            default: return "Invalid option.";
        }
    }

    public String printMessage() {
        return "Message ID: " + messageID +
               "\nHash: " + messageHash +
               "\nRecipient: " + recipient +
               "\nMessage: " + messageText;
    }

    public static int returnTotalMessages() {
        return messageCount;
    }

    // Getters
    public String getMessageID() { return messageID; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public String getMessageHash() { return messageHash; }
    
    public String getFlag() {
    return flag;
}
}