/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;
/**
 *
 * @author nizaam
 */


public class Message {

    private String messageText;
    private boolean isSent;
    private boolean isReceived;
    private boolean isRead;

    public Message(String messageText) {
        this.messageText = messageText;
        this.isSent = false;
        this.isReceived = false;
        this.isRead = false;
    }

    public void sendMessage() {
        isSent = true;
    }

    public void receiveMessage() {
        if (isSent) {
            isReceived = true;
        }
    }

    public void readMessage() {
        if (isReceived) {
            isRead = true;
        }
    }

    public String getMessageText() {
        return messageText;
    }

    public boolean isSent() {
        return isSent;
    }

    public boolean isReceived() {
        return isReceived;
    }

    public boolean isRead() {
        return isRead;
    }

    @Override
    public String toString() {
        return "Message: " + messageText +
               "\nSent: " + isSent +
               "\nReceived: " + isReceived +
               "\nRead: " + isRead;
    }
}