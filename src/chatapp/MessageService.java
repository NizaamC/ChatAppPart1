/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;

import java.util.ArrayList;
/**
 *
 * @author nizaam
 */

public class MessageService {

    private ArrayList<Message> messages = new ArrayList<>();

    public void sendMessage(String text) {
        Message msg = new Message(text);
        msg.sendMessage();
        msg.receiveMessage(); // simulate delivery
        messages.add(msg);

        System.out.println("Message sent successfully.");
    }

    public void readMessages() {
        if (messages.isEmpty()) {
            System.out.println("No messages available.");
            return;
        }

        for (Message msg : messages) {
            msg.readMessage();
            System.out.println("----------------------");
            System.out.println(msg);
        }
    }
}